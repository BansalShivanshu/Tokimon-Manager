package com.sfu.cmpt213.model;

public class Tokimon {

    /*
    Instance Variables
     */
    String mName;
    String mType; //Equivalent to abilities
    double mHeight;
    double mWeight;
    int mStrength;

    /*
    Methods
     */

    public Tokimon() {
        mName = "TO BE SET";
        mType = "TO BE SET";
        mHeight = -1;
        mWeight = -1;
        mStrength = -1;
    }

    public Tokimon(String name, String type, double height, double weight, int strength) {
        setName(name);
        setType(type);
        setHeight(height);
        setWeight(weight);
        setStrength(strength);
    }

    /*
    Getters
     */

    public String getName() {
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

    public int getStrength() {
        return mStrength;
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

    public void setStrength(int strength) throws IllegalArgumentException {
        if (strength < 0 || strength > 100) {
            throw new IllegalArgumentException("Value of strength follows [0, 100] domain");
        }
        mStrength = strength;
    }

    @Override
    public String toString() {
        return  mName +
                ", " + mType +
                ", " + mHeight + " inch(s)" +
                ", " + mWeight + "kg" +
                ", " + mStrength + "/100 strength";
    }
}
