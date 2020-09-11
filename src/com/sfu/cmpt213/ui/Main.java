package com.sfu.cmpt213.ui;

public class Main {

    public static void main(String[] args) {
        displayApplicationHeader();
        displayMainMenu();
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

        int count = 0;

        System.out.println("\t" + count++ + ". List Tokimons");
        System.out.println("\t" + count++ + ". Add a new Tokimon");
        System.out.println("\t" + count++ + ". Remove a Tokimon");
        System.out.println("\t" + count++ + ". Change Tokimon Strength");
        System.out.println("\t" + count++ + ". DEBUG: Dump Objects (toString)");
        System.out.println("\t" + count++ + ". Exit");
    }
}
