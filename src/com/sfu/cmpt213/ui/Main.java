package com.sfu.cmpt213.ui;

import com.sfu.cmpt213.model.Tokimon;
import com.sfu.cmpt213.model.Tokimons;

import java.util.Scanner;

/**
 *  Represents the Main class for the UI of the Application
 *  Deals with getting user input and manipulating data
 *  accordingly along with excepption handling in consideration.
 *
 * @studentNumber 301386409
 * @author  Shivanshu Bansal
 * @date    September 11, 2020
 * @version 1.0
 */
public class Main {

    private static Tokimons tokimons;

    public static void main(String[] args) {

        // initialize the tokimons
        tokimons = new Tokimons();

        displayApplicationHeader();


        boolean shallContinue = true;
        while (shallContinue) {

            displayMainMenu();

            // Get user selection for main menu
            int userSelection = getUserSelection(1, 6);

            switch (userSelection) {
                case 1:
                    System.out.println("********************");
                    System.out.println("* List of Tokimons *");
                    System.out.println("********************");
                    displayAllTokis();
                    break;
                case 2:
                    addNewToki();
                    break;
                case 3:
                    deleteToki();
                    break;
                case 4:
                    alterToki();
                    break;
                case 5:
                    dumpObjects();
                    break;
                case 6:
                    shallContinue = false;
                    System.out.println("Have a good day!");
                    break;
            }
        }

    }

    private static void displayApplicationHeader() {
        System.out.println(""); //empty break line
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * **");
        System.out.println("* Tokimon Tracker by Shivanshu Bansal sn 301386409 *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * **");
    }

    private static void displayMainMenu() {
        System.out.println(""); //empty break line
        System.out.println("*************");
        System.out.println("* Main Menu *");
        System.out.println("*************");

        int count = 1;

        System.out.println("\t" + count++ + ". List Tokimons");
        System.out.println("\t" + count++ + ". Add a new Tokimon");
        System.out.println("\t" + count++ + ". Remove a Tokimon");
        System.out.println("\t" + count++ + ". Change Tokimon Strength");
        System.out.println("\t" + count++ + ". DEBUG: Dump Objects (toString)");
        System.out.println("\t" + count++ + ". Exit");
    }

    private static int getUserSelection(int minParam, int maxParam) {
        Scanner scanner = new Scanner(System.in);

        int userSelection;
        do {
            System.out.print("\t> ");
            userSelection = scanner.nextInt();
        } while (userSelection < minParam || userSelection > maxParam);

        return userSelection;
    }

    private static void displayAllTokis() {
        if (tokimons.numTokimons() == 0) {
            System.out.println("### No Tokimons Found ###");
            return;
        }

        for (int i = 0; i < tokimons.numTokimons(); i++) {
            int displayIndex = i + 1;
            System.out.println(
                        "\t" + displayIndex + ". " +
                        tokimons.getTokimon(i).getName() + ", " +
                        tokimons.getTokimon(i).getType() + ", " +
                        tokimons.getTokimon(i).getHeight() + " inch(s), " +
                        tokimons.getTokimon(i).getWeight() + "Kg, " +
                        tokimons.getTokimon(i).getStrength() + "/100 Strength"
                    );
        }
    }

    private static void addNewToki() {
        Tokimon tokimon = new Tokimon();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\tEnter Tokimon's");

        while (true) {
            System.out.print("\t\tName: ");
            String name = scanner.nextLine();

            try {
                tokimon.setName(name);
                break; // execute break if no exception is caught
            } catch (Exception e) {
                System.out.println("\tERR: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("\t\tType: ");
            String type = scanner.nextLine();

            try {
                tokimon.setType(type);
                break;
            } catch (Exception e) {
                System.out.println("\tERR: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("\t\tHeight: ");
            double height = scanner.nextDouble();

            try {
                tokimon.setHeight(height);
                break;
            } catch (Exception e) {
                System.out.println("\tERR: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("\t\tWeight: ");
            double weight = scanner.nextDouble();

            try {
                tokimon.setWeight(weight);
                break;
            } catch (Exception e) {
                System.out.println("\tERR: " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("\t\tStrength: ");
            int strength = scanner.nextInt();

            try {
                tokimon.setStrength(strength);
                break;
            } catch (Exception e) {
                System.out.println("\tERR: " + e.getMessage());
            }
        }

        tokimons.addNewTokimon(tokimon);
    }

    private static void deleteToki() {
        System.out.println("********************");
        System.out.println("* Remove a Tokimon *");
        System.out.println("********************");

        // list all the tokimons
        displayAllTokis();

        if (tokimons.numTokimons() == 0) {
            return;
        }

        // display information to abort
        System.out.println("\t\t(0 to Abort)");

        int userSelection = getUserSelection(0, tokimons.numTokimons());

        if (userSelection == 0) {
            return;
        }

        Tokimon tokimon = tokimons.getTokimon(userSelection - 1);
        tokimons.deleteTokimon(tokimon);
    }

    private static void alterToki() {
        System.out.println("********************");
        System.out.println("* Modify a Tokimon *");
        System.out.println("********************");

        // list of all the tokimons
        displayAllTokis();

        if (tokimons.numTokimons() == 0) {
            return;
        }

        // display information to abort
        System.out.println("\t\t(0 to Abort)");

        int userSelection = getUserSelection(0, tokimons.numTokimons());

        // abort if user selects 0
        if (userSelection == 0) {
            return;
        }

        Tokimon tokimon = tokimons.getTokimon(userSelection - 1);

        int maxAcceptableChange_Positive = 100 - tokimon.getStrength();
        System.out.println("Modify Strength by: ");

        /*
        Bound the user to enter either negative of the current strength to make
        the strength 0 or
        set the upper bound to allow the new strength to be 100.
         */
        int userStrength = getUserSelection(tokimon.getStrength() * -1, maxAcceptableChange_Positive); // strength input from the user

        final int NEW_STRENGTH = tokimon.getStrength() + userStrength;

        // Since the new values are bound to be between [0, 100]
        // therefore, no try-catch block is required
        tokimon.setStrength(NEW_STRENGTH);

        tokimons.replaceTokimon(userSelection - 1, tokimon);
    }

    private static void dumpObjects() {
        System.out.println("*************");
        System.out.println("* DATA DUMP *");
        System.out.println("*************");

        if (tokimons.numTokimons() == 0) {
            System.out.println("### NO DATA FOUND ###");
            return;
        }

        for (int i = 0; i < tokimons.numTokimons(); i++) {
            int displayIndex = i + 1;
            System.out.println("\t" + displayIndex + ". " + tokimons.getTokimon(i).toString());
        }
    }
}
