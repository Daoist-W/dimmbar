import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JDBC_Setup {
    // variables to connect to our database
    // a driver is a piece of software to aid communication
    // from one node to another
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //
    final String db_url = "jdbc:mysql://localhost:3306/dimmbar";
    // Adding our Database credentials
    final private String user;
    final private String password;
    // creating a connection object and setting it to null
    Connection conn = null;

    public JDBC_Setup(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // return a connection object
    public Connection connect() {
//        System.out.println("Attempting to connect to database...");
        // we are attempting to connect to something outside of Java JDK
        try {
            // What class.forname does is basically check that a java class
            // exists at that location, that it is a valid class
            // as the sql needs it
//            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(db_url, user, password);
//            System.out.println("Database connected!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        return null;
    }

    // This is a method to get data from JDCB and use data to create an object
    // MUST be overriden to be table specific
    public abstract Entry returnResults(ResultSet resultSet);
}
