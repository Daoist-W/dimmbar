import java.sql.ResultSet;
import java.util.HashMap;

public class JDBC_Drinks extends JDBC_Setup {

    public JDBC_Drinks(String user, String password) {
        super(user, password);
    }

    // This is a method to get data from JDCB and use data to create an object
    // MUST be overriden to be table specific
    @Override
    public Entry returnResults(ResultSet resultSet) {
        try {
            HashMap<String, Integer> intData = new HashMap<>();
            HashMap<String, String> stringData = new HashMap<>();

            intData.put("drink_id", resultSet.getInt("drink_id"));
            intData.put("price", resultSet.getInt("price"));

            stringData.put("name_", resultSet.getString("name_"));
            stringData.put("subtype", resultSet.getString("subtype"));

            return new Drink(intData, stringData);

        } catch (Exception e) {
            System.out.println("Something went wrong with getting results");
            e.printStackTrace();
        }
        return null;
    }

}
