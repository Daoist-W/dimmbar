package com.dimmbar;

import java.sql.ResultSet;
import java.util.HashMap;

public class JDBC_Beers extends JDBC_Setup {

    public JDBC_Beers(String user, String password) {
        super(user, password);
    }

    // This is a method to get data from JDCB and use data to create an object
    // MUST be overriden to be table specific
    @Override
    public Entry returnResults(ResultSet resultSet) {
        try {
            HashMap<String, Integer> intData = new HashMap<>();
            HashMap<String, String> stringData = new HashMap<>();

            intData.put("beer_id", resultSet.getInt("beer_id"));
            intData.put("price", resultSet.getInt("price"));
            intData.put("abv", resultSet.getInt("abv"));

            stringData.put("name_", resultSet.getString("name_"));
            stringData.put("subtype", resultSet.getString("subtype"));
            stringData.put("brewery", resultSet.getString("brewery"));

            return new Beer(intData, stringData);

        } catch (Exception e) {
            System.out.println("Something went wrong with getting results");
            e.printStackTrace();
        }
        return null;
    }

}
