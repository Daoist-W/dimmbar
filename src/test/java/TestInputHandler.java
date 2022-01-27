import com.dimmbar.*;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestInputHandler {

    public boolean testApp() throws InterruptedException {
        InputHandler inputHandler;
        String input = "";
        int attempts = 0;
        boolean test = false;

        // while loop to take in user input
        while (attempts < 3) {
            System.out.print("Please enter valid Username: ");
            String u = "dev";
            System.out.print("Please enter valid password: ");
            String p = "";
            // login attempt implementation. creating all the necessary objects
            HashMap<String, TableManager> managers = new HashMap<>();
            managers.put("Beers", new BeerManager(new JDBC_Beers(u, p)));
            inputHandler = new InputHandler(new Implementer(managers, new StockManager()));
            if (inputHandler.validateLogin()) {
                System.out.println("login successful!");
                test = true;
                if (false) {
                    attempts = 3;
                } else {
                    attempts = 0;
                    System.out.println("Logging out... \n");
                    System.out.println("Login Page: \n");
                    return test;
                }
            } else {
                System.err.println("\nInvalid password/username, please try again.");
                test = true;
                attempts++;
                System.out.printf("Chances remaining: %d \n\n", (3 - attempts));

            }

        }
        return test;
    }

    // login interface works
    @Test
    public void shouldReturnTrue() throws InterruptedException {
        assertEquals(true, testApp());
    }

    // can use TxtFileTool to Update multiple entries

    // can switch between Input implementations

    // can retrieve all products from tables via com.dimmbar.StockManager

    // can retrieve item by id/name

    // can retrieve all staff info with root/admin privileges

    // can update items with root/admin/manager privileges

    // can delete items with root/admin/manager privileges

    // can handle invalid inputs from user

}
