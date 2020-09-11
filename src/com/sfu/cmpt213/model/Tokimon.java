package com.sfu.cmpt213.model;

public class Tokimon {

    /*
    Instance Variables
     */
    String mName;
    String mType; //Equivalent to abilities
    double mHeight;
    double mWeight;

    /*
    Methods
     */

    public Tokimon(String name, String type, double height, double weight) {
        mName = name;
        mType = type;
        mHeight = height;
        mWeight = weight;
    }

    /*
    Getters
     */

    public String getmName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public double getHeight() {
        return mHeight;
    }

    public double getWeight() {
        return mWeight;
    }

    /*
    Setters
     */

    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        mName = name;
    }

    public void setType(String type) throws IllegalArgumentException {
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be empty");
        }
        mType = type;
    }

    public void setHeight(double height) throws  IllegalArgumentException {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }
        mHeight = height;
    }

    public void setWeight(double weight) throws IllegalArgumentException {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        mWeight = weight;
    }
}
