package com.sfu.cmpt213.model;

import java.util.Vector;

/**
 *  This class is used to handle multiple Tokimon objects
 *  Allows addition, deletion, and modification of the
 *  objects from the user interface.
 *  User Interface is highly reliant on this class
 *
 * @studentNumber 301386409
 * @author  Shivanshu Bansal
 * @date    September 11, 2020
 * @version 1.0
 */
public class Tokimons {

    // List of all the tokimons
    Vector<Tokimon> tokimons;

    public Tokimons() {
        // Initialize the vector
        tokimons = new Vector<>();
    }

    /*
    Methods
     */

    public void addNewTokimon(Tokimon tokimon) {
        tokimons.add(tokimon);
    }

    // Remove the tokimon using the tokimon object
    public boolean deleteTokimon(Tokimon tokimon) {
        return tokimons.remove(tokimon);
    }

    // Remove the tokimon using index
    public Tokimon deleteTokimon(int index) throws IllegalArgumentException {
        if (index < 0 || index > tokimons.size() - 1) {
            throw new IllegalArgumentException("Index out of bound");
        }

        return tokimons.remove(index);
    }

    public void replaceTokimon(int index, Tokimon tokimon) {
        tokimons.set(index, tokimon);
    }

    public Tokimon getTokimon(int index) throws IllegalArgumentException {
        if (index < 0 || index > tokimons.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return tokimons.get(index);
    }

    public int numTokimons() {
        return tokimons.size();
    }

    @Override
    public String toString() {
        return "Tokimons { " +
                "tokimons = " + tokimons +
                " }";
    }


}
