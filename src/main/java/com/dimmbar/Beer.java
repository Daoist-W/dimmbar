package com.dimmbar;

import java.util.HashMap;

public class Beer extends Entry {
    // fields

    private HashMap<String, Integer> intData;
    private HashMap<String, String> stringData;

    // constructor
    public Beer() {
    }

    public Beer(HashMap<String, Integer> intData, HashMap<String, String> stringData) {
        this.intData = intData;
        this.stringData = stringData;
    }

    @Override
    public Entry newInstance(HashMap<String, Integer> intData, HashMap<String, String> stringData) {
        return new Beer(intData, stringData);
    }

    @Override
    public HashMap<String, Integer> getIntData() {
        return intData;
    }

    // overloading
    @Override
    public Integer getIntData(String field) {
        if (getIntData().containsKey(field)) {
            return getIntData().get(field);
        }
        System.out.println("field not found");
        return null;
    }

    @Override
    public HashMap<String, String> getStringData() {
        return stringData;
    }

    // overloading
    @Override
    public String getStringData(String field) {
        if (getStringData().containsKey(field)) {
            return getStringData().get(field);
        }
        System.out.println("field not found");
        return null;
    }

    @Override
    public String displayEntry(String appendToName, double discount) {
        if (discount > 100 || discount < 0) {
            discount = 1;
            System.out.println("INVALID DISCOUNT: NOT APPLIED");
        }
        return String.format(
                "%40S %10S %7.2f%% %10.2f GBP \n",
                getStringData("name_"),
                appendToName,
                // conversion from table units to %, done to keep numerical data types as ints
                (float) getIntData("abv") * 0.1,
                getIntData("price") * 0.05 * (1 - discount) // 1/20th distributor cost default
        );
    }

    @Override
    public String toString() {
        StringBuilder sbint = new StringBuilder();
        StringBuilder sbString = new StringBuilder();
        getIntData().forEach((item, value) -> sbint.append(item)
                .append(": ")
                .append(value)
                .append("\n"));
        getStringData().forEach((item, value) -> sbString.append(item)
                .append(": ")
                .append(value)
                .append("\n"));
        return "com.dimmbar.Beer{ \n" +
                sbint +
                sbString +
                '}';
    }
}
