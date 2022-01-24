import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {

        // variable set up
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler;
        String input = "";
        int attempts = 0;
        boolean test = false;

        // while loop to take in user input
        while (attempts < 3) {
            // user login prompt
            System.out.print("Please enter valid Username: ");
            String u = scanner.nextLine();
            System.out.print("Please enter valid password: ");
            String p = scanner.nextLine();

            // login attempt implementation. creating all the necessary objects
            HashMap<String, TableManager> managers = new HashMap<>();
            managers.put("Beers", new BeerManager(new JDBC_Beers(u, p)));
            managers.put("Drinks", new DrinkManager(new JDBC_Drinks(u, p)));
            managers.put("Snacks", new SnackManager(new JDBC_Snacks(u, p)));
            inputHandler = new InputHandler(new Implementer(managers, new StockManager()));
            if (inputHandler.validateLogin()) {
                System.out.println("login successful!");
                if (inputHandler.mainMenu(u)) {
                    attempts = 3;
                } else {
                    attempts = 0;
                    System.out.println("Logging out... \n");
                    System.out.println("Login Page: \n");
                }
            } else {
                System.err.println("\nInvalid password/username, please try again.");
                attempts++;
                System.out.printf("Chances remaining: %d \n\n", (3 - attempts));

            }

        }
    }

}
