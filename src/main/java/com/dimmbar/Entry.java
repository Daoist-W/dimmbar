package com.dimmbar;// interface provides a template for Table entry objects

import java.util.HashMap;

public abstract class Entry {
    // fields
    private HashMap<String, Integer> intData;
    private HashMap<String, String> stringData;

    // constructors
    public Entry() {
    }

    public Entry(HashMap<String, Integer> intData, HashMap<String, String> stringData) {
        this.intData = intData;
        this.stringData = stringData;
    }

    public abstract Entry newInstance(HashMap<String, Integer> intData, HashMap<String, String> stringData);

    public HashMap<String, Integer> getIntData() {
        return intData;
    }

    // overloading
    public Integer getIntData(String field) {
        if (getIntData().containsKey(field)) {
            return getIntData().get(field);
        }
        System.out.println("field not found");
        return null;
    }

    public HashMap<String, String> getStringData() {
        return stringData;
    }

    // overloading
    public String getStringData(String field) {
        if (getStringData().containsKey(field)) {
            return getStringData().get(field);
        }
        System.out.println("field not found");
        return null;
    }

    public abstract String displayEntry(String appendToName, double discount);

    @Override
    public abstract String toString();

}
