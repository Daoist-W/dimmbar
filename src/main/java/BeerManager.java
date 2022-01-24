import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

public class BeerManager implements TableManager {

    // Statement class is imported from JDBC - an object for our MySQL queries
    static Statement stmt;
    JDBC_Setup jdbc;

    public BeerManager(JDBC_Setup jdbc) {
        this.jdbc = jdbc;
    }

    // #################################
    // interface implementations methods
    // #################################


    @Override
    public boolean testConnection() {
        return jdbc.connect() != null;
    }

    @Override
    public Entry createEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type Entry here in the following format: \n" +
                "name, price, subtype, abv, brewery");
        String s = scanner.nextLine();
        String[] sList = s.split(", ");
        Entry entry = null;
        try {
            HashMap<String, Integer> intData = new HashMap<>();
            intData.put("price", Integer.parseInt(sList[1]));
            intData.put("abv", Integer.parseInt(sList[3]));

            HashMap<String, String> stringData = new HashMap<>();
            stringData.put("name_", sList[0]);
            stringData.put("subtype", sList[2]);
            stringData.put("brewery", sList[4]);
            entry = new Beer(intData, stringData);
            return entry;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Incorrect format: please try again");
        }

        return null;
    }

    @Override
    public void addEntry() {
        addEntry(createEntry());
    }

    @Override
    public void addEntry(Entry entry) {
        try (Connection conn = jdbc.connect()) {

            // create a new statement using the connection object
            stmt = conn.createStatement();

            // create a query to put into out statement
            // eventually we will be passing in our values with variables etc.
            StringBuilder sb = new StringBuilder();
            Formatter sbFormatter = new Formatter(sb);

            sbFormatter.format(
                    "INSERT INTO Beers (name_, price, subtype, abv, brewery)\n" +
                            "VALUES " +
                            "(\"%s\",\"%d\",\"%s\",\"%d\",\"%s\")",
                    entry.getStringData("name_"),
                    entry.getIntData("price"),
                    entry.getStringData("subtype"),
                    entry.getIntData("abv"),
                    entry.getStringData("brewery")
            );

            String query = sb.toString();

            // using our statement object, we need to run the query
            // this is for when youre sending, not recieving
            stmt.executeUpdate(query);

            // notification upon success
            System.out.printf("%s added successfully! \n", entry.getStringData("name_"));
        } catch (SQLException | NullPointerException e) {
            System.out.println("OOPS! Something went wrong...");
            e.printStackTrace();
        }
    }


    @Override
    public void deleteEntry(int entry_id, String col_name) {
        try (Connection conn = jdbc.connect()) {

            // prepared statements use SQL ? syntax
            // ? relates to a variable we can pass in
            PreparedStatement preStmnt = conn.prepareStatement("DELETE FROM Beers where " + col_name + " = ?");
            preStmnt.setInt(1, entry_id);

            // execute the statement
            preStmnt.executeUpdate();
            System.out.println(preStmnt + " successful");
        } catch (Exception e) {
            System.out.println("Something went wrong with deleteCustomer");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBySubtype(String value) {
        try (Connection conn = jdbc.connect()) {

            // prepared statements use SQL ? syntax
            // ? relates to a variable we can pass in
            PreparedStatement preStmnt = conn.prepareStatement("DELETE FROM Beers where subtype = ?");
            preStmnt.setString(1, value);

            // execute the statement
            preStmnt.executeUpdate();
            System.out.println(preStmnt + " successful");
        } catch (Exception e) {
            System.out.println("Something went wrong with deleteBySubtype");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        try (Connection conn = jdbc.connect()) {

            // prepared statements use SQL ? syntax
            // ? relates to a variable we can pass in
            PreparedStatement preStmnt = conn.prepareStatement("DELETE FROM Beers WHERE beer_id > 0;");

            // execute the statement
            preStmnt.executeUpdate();
            System.out.println(preStmnt + " successful");
        } catch (Exception e) {
            System.out.println("Something went wrong with deleteBySubtype");
            e.printStackTrace();
        }
    }

    @Override
    public Entry viewEntry(int entry_id) {
        try (Connection conn = jdbc.connect()) {

            stmt = conn.createStatement();
            String query = String.format("SELECT * FROM Beers WHERE beer_id = %d", entry_id);
            ResultSet result = stmt.executeQuery(query);
            // our result is a spreadsheet from the database, the first row being meta data
            // go down to the next row of data (our useful data)
            result.next();
            // pass in the useful data to our returnResults method, return this
            return jdbc.returnResults(result);
        } catch (Exception e) {
            System.out.println("something went wrong with viewCustomer");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Entry> viewAll() {
        try (Connection conn = jdbc.connect()) {

            stmt = conn.createStatement();
            ArrayList<Entry> beers = new ArrayList<>();
            String query = "SELECT * FROM Beers";
            ResultSet result = stmt.executeQuery(query);
            // our result is a spreadsheet from the database, the first row being meta data
            // go down to the next row of data (our useful data)
            while (result.next()) {
                beers.add(jdbc.returnResults(result));
            }
            // pass in the useful data to our returnResults method, return this
            return beers;
        } catch (SQLException e) {
            System.out.println("Something went wrong with viewAll");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<String> getKeys() {
        try (Connection conn = jdbc.connect()) {

            stmt = conn.createStatement();
            ArrayList<String> keys = new ArrayList<>();
            String query = "SELECT * FROM Beers";
            ResultSet result = stmt.executeQuery(query);
            // our result is a spreadsheet from the database, the first row being meta data
            // go down to the next row of data (our useful data)
            while (result.next()) {
                keys.add(jdbc.returnResults(result).getStringData("name_"));
            }
//            System.out.println("results successfully retrieved");
            // pass in the useful data to our returnResults method, return this
            return keys;
        } catch (SQLException e) {
            System.out.println("Something went wrong with getKeys");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Entry> viewAllWhere(String condition) {
        try (Connection conn = jdbc.connect()) {

            stmt = conn.createStatement();
            ArrayList<Entry> customers = new ArrayList<>();
            String query = "SELECT * FROM Beers WHERE " + condition + ";";
            ResultSet result = stmt.executeQuery(query);
            // our result is a spreadsheet from the database, the first row being meta data
            // go down to the next row of data (our useful data)
            while (result.next()) {
                customers.add(jdbc.returnResults(result));
            }
            System.out.println("\nPrinting results...\n\n");
            Thread.sleep(1000);
            // pass in the useful data to our returnResults method, return this
            return customers;
        } catch (SQLException | InterruptedException e) {
            System.out.println("Something went wrong with viewAllWhere");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Entry> updateByString(Entry entry, String condition, String value) {
        // can choose any string based field to apply a conditional to
        try (Connection conn = jdbc.connect()) {

            String update = String.format("UPDATE Beers SET " +
                    "name_ = ?, " +
                    "price = ?, " +
                    "subtype = ?, " +
                    "abv = ?, " +
                    "brewery = ? " +
                    "WHERE %s = ?;", condition);
            PreparedStatement prepStmt = conn.prepareStatement(update);
            prepStmt.setString(1, entry.getStringData("name_"));
            prepStmt.setInt(2, entry.getIntData("price"));
            prepStmt.setString(3, entry.getStringData("subtype"));
            prepStmt.setInt(4, entry.getIntData("abv"));
            prepStmt.setString(5, entry.getStringData("brewery"));
            prepStmt.setString(6, value);

            prepStmt.executeUpdate();
            System.out.printf("Update of entry matching %s successful! ", value);
            return viewAllWhere(String.format("%s = '%s'", condition, entry.getStringData("name_")));

        } catch (SQLException e) {
            System.out.println("something went wrong with updating entry");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Entry> updateByInt(Entry entry, String condition, int value) {
        // can choose any string based field to apply a conditional to
        try (Connection conn = jdbc.connect()) {

            String update = String.format("UPDATE Beers SET " +
                    "name_ = ?," +
                    "price = ?," +
                    "subtype = ?, " +
                    "abv = ?, " +
                    "brewery = ? " +
                    "WHERE %s = ?;", condition);
            PreparedStatement prepStmt = conn.prepareStatement(update);
            prepStmt.setString(1, entry.getStringData("name_"));
            prepStmt.setInt(2, entry.getIntData("price"));
            prepStmt.setString(3, entry.getStringData("subtype"));
            prepStmt.setInt(4, entry.getIntData("abv"));
            prepStmt.setString(5, entry.getStringData("brewery"));
            prepStmt.setInt(6, value);

            prepStmt.executeUpdate();
            System.out.printf("Update of entry matching %s successful", value);
            return viewAllWhere(String.format("%s = %s", condition, value));

        } catch (SQLException e) {
            System.out.println("something went wrong with updating entry");
            e.printStackTrace();
        }
        return null;
    }

}
