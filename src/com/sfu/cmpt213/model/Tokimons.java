package com.sfu.cmpt213.model;

import java.util.Vector;

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

    public void addNewToki(Tokimon tokimon) {
        tokimons.add(tokimon);
    }

    // Remove the tokimon using the tokimon object
    public boolean deleteToki(Tokimon tokimon) {
        return tokimons.remove(tokimon);
    }

    // Remove the tokimon using index
    public Tokimon deleteToki(int index) throws IllegalArgumentException {
        if (index < 0 || index > tokimons.size() - 1) {
            throw new IllegalArgumentException("Index out of bound");
        }

        return tokimons.remove(index);
    }



}
