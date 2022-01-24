import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    // fields
    Implementer currentImpl;

    // constructor
    public InputHandler(Implementer currentImpl) {
        this.currentImpl = currentImpl;
    }

    // getters / setters

    public void setCurrentImpl(Implementer currentImpl) {
        this.currentImpl = currentImpl;
    }

    // Login support
    public boolean validateLogin() {
        return currentImpl.attemptLogin();
    }

    public boolean mainMenu(String user) throws InterruptedException {
        String input = "";
        currentImpl.refreshStock(false);
        pause();


        while (!input.equals("exit")) {
            Scanner scanner = new Scanner(System.in);
            String display = String.format(
                    "Current User: %s \n" +
                            "Main menu (select option by number) \n" +
                            "1 -> Beers \n" +
                            "2 -> Drinks \n" +
                            "3 -> Snacks \n" +
                            "4 -> Stock Manager (Manager/Admin only) \n" +
                            "5 -> Staff Manager (Manager/Admin only) \n" +
                            "6 -> Change Mode (Current Mode: %s)\n" +
                            "7 -> Logout \n" +
                            "8 -> Shutdown \n",
                    user, currentImpl.toString()
            );

            System.out.println("Loading main menu...");
            pause();
            System.out.println(display);
            System.out.println("Type selection here: ");
            input = scanner.nextLine();
            boolean b = user.equals("dimmbarmanager") ||
                    user.equals("dimmbaradmin") ||
                    user.equals("dev"); // DELETE THIS AT THE END
            switch (input) {
                case "1":
                    menuBeers();
                    break;
                case "2":
                    menuDrinks();
                    break;
                case "3":
                    menuSnacks();
                    break;
                case "4":
                    if (b) {
                        menuStock();
                    } else {
                        System.err.println("access declined: unauthorised action");
                    }
                    break;
                case "5":
                    if (b) {
                        menuStaff();
                    } else {
                        System.err.println("access declined: unauthorised action");
                    }
                    break;
                case "6":
                    System.out.println("Select Mode: \n 1) Default \n 2) HappyHour");
                    String mode = scanner.nextLine();
                    changeMode(mode);
                    break;
                case "7":
                    input = "exit";
                    return false;
                case "8":
                    System.out.println("Shutting down...");
                    pause();
                    System.out.println("Goodbye!");
                    input = "exit";
                    return true;
                default:
                    System.out.println("Invalid input, please try again.");
                    input = "";

            }

        }
        return false;
    }

    private void menuBeers() {
        System.out.println("Menu -> Beers");
        currentImpl.displayEntries("Beer");
        exitMethod();
    }

    private void menuSnacks() throws InterruptedException {
        System.out.println("Menu -> Snacks");
        currentImpl.displayEntries("Snack");
        pause();
        exitMethod();
    }

    private void menuDrinks() throws InterruptedException {
        System.out.println("Menu -> Drinks");
        currentImpl.displayEntries("Drink");
        pause();
        exitMethod();
    }

    private void menuStock() throws InterruptedException {
        String input = "";
        while (!input.equals("exit")) {
            Scanner scanner = new Scanner(System.in);
            String display =
                    "Stock Manager menu (select option by number) \n" +
                            "1 -> Check Tables \n" +
                            "2 -> Add Entry \n" +
                            "3 -> Update Entry \n" +
                            "4 -> Delete Entry \n" +
                            "5 -> Empty Table \n" +
                            "6 -> Back \n";

            System.out.println("Loading menu...");
            pause();
            System.out.println(display);
            System.out.println("Type selection here: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    // Check tables
                    System.out.println("Displaying Stocked products...");
                    pause();
                    System.out.println(currentImpl.getStockManager().toString());
                    pause();
                    exitMethod();
                    break;
                case "2":
                    // Add Entry
                    stockManAddEntry();
                    break;
                case "3":
                    // Update Entry
                    stockManUpdateEntry();
                    break;
                case "4":
                    // Delete Entry
                    stockManDeleteEntry();
                    break;
                case "5":
                    // Delete by subtype
                    stockManDeleteTable();
                    break;
                default:
                    System.out.println("exiting...");
                    input = "exit";
            }
        }
        pause();
        exitMethod();
    }

    // add entry option for stock manager
    private void stockManAddEntry() throws InterruptedException {
        String input = "";
        while (!input.equals("exit")) {
            Scanner scanner = new Scanner(System.in);
            String display =
                    "Add Entry menu (select option by number) \n" +
                            "1 -> Add Beer \n" +
                            "2 -> Add Drink \n" +
                            "3 -> Add Snack \n" +
                            "4 -> Back \n";

            System.out.println("Loading menu...");
            pause();
            System.out.println(display);
            System.out.println("Type selection here: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    // do something
                    currentImpl.getTableManager("Beers").addEntry();
                    currentImpl.refreshStock(false);
                    break;
                case "2":
                    // do something
                    currentImpl.getTableManager("Drinks").addEntry();
//                    currentImpl.refreshStock(false);
                    break;
                case "3":
                    // do something
                    currentImpl.getTableManager("Snacks").addEntry();
//                    currentImpl.refreshStock(false);
                    break;
                default:
                    System.out.println("exiting...");
                    input = "exit";
            }
        }
        pause();
    }

    private void stockManUpdateEntry() throws InterruptedException {
        String input = "";
        while (!input.equals("exit")) {
            Scanner scanner = new Scanner(System.in);
            String display =
                    "Update Entry menu (select option by number) \n" +
                            "1 -> Update Beer \n" +
                            "2 -> Update Drink \n" +
                            "3 -> Update Snack \n" +
                            "4 -> Back \n";

            System.out.println("Loading menu...");
            pause();
            System.out.println(display);
            System.out.println("Type selection here: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    // do something
                    stockManUpdateBy("Beers", "beer_id");
                    currentImpl.refreshStock(false);
                    break;
                case "2":
                    // do something
                    stockManUpdateBy("Drinks", "drink_id");
//                    currentImpl.refreshStock();
                    break;
                case "3":
                    // do something
                    stockManUpdateBy("Snacks", "snack_id");
//                    currentImpl.refreshStock();
                    break;
                default:
                    System.out.println("exiting...");
                    input = "exit";
            }
        }
        pause();
    }

    private void stockManUpdateBy(String productType, String idLabel) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to update by Product ID? (y/n): \n");
        String s = scanner.nextLine();
        if (s.equals("y")) {
            System.out.println("Please enter id: ");
            int n = scanner.nextInt();
            Entry entry = currentImpl.getTableManager("Beers").createEntry();
            currentImpl.getTableManager(productType).updateByInt(entry, idLabel, n);
            return;
        }
        System.out.println("Would you like to update by Product Name? (y/n):\n");
        s = scanner.nextLine();
        if (s.equals("y")) {
            System.out.println("Updating by name...");
            pause();
            System.out.println("Please enter the Product Name: ");
            String n = scanner.nextLine();
            Entry entry = currentImpl.getTableManager(productType).createEntry();
            currentImpl.getTableManager(productType).updateByString(entry, "name_", n);
            return;
        }
        System.out.println("Would you like to update by Product Subtype? (y/n):\n");
        s = scanner.nextLine();
        if (s.equals("y")) {
            System.out.println("Updating by Subtype...");
            pause();
            System.out.println("Please enter the Product Subtype: ");
            String n = scanner.nextLine();
            Entry entry = currentImpl.getTableManager(productType).createEntry();
            currentImpl.getTableManager(productType).updateByString(entry, "subtype", n);
        }

    }

    private void stockManDeleteEntry() throws InterruptedException {
        String input = "";
        while (!input.equals("exit")) {
            Scanner scanner = new Scanner(System.in);
            String display =
                    "Delete Entry menu (select option by number) \n" +
                            "1 -> Delete Beer \n" +
                            "2 -> Delete Drink \n" +
                            "3 -> Delete Snack \n" +
                            "4 -> Back \n";

            System.out.println("Loading menu...");
            pause();
            System.out.println(display);
            System.out.println("Type selection here: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    // Delete beer entry
                    deleteEntrySubroutine("Beers", "beer_id");
                    currentImpl.refreshStock(false);
                    break;
                case "2":
                    // Delete Drink entry
                    deleteEntrySubroutine("Drinks", "drink_id");
                    currentImpl.refreshStock(false);
                    break;
                case "3":
                    // Delete Snack entry
                    deleteEntrySubroutine("Snacks", "snack_id");
                    currentImpl.refreshStock(false);
                    break;
                default:
                    System.out.println("exiting...");
                    input = "exit";
            }
        }
        pause();
    }

    private void deleteEntrySubroutine(String tableName, String idName) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Accessing " + tableName + " data...");
        pause();
        System.out.println("Would you like to delete by subtype? (y/n): ");
        String s = scanner.nextLine();
        if (s.equals("y")) {
            System.out.println("Please enter subtype: ");
            String subtype = scanner.nextLine();
            System.out.println("This will delete all " + subtype + "... are you sure? (y/n): ");
            String yn = scanner.nextLine();
            if (yn.equals("y")) {
                currentImpl.getTableManager(tableName).deleteBySubtype(subtype);
            }
        } else {
            System.out.println("Please enter ID:");
            try {
                int n = scanner.nextInt();
                currentImpl.getTableManager(tableName).deleteEntry(n, idName);
            } catch (InputMismatchException e) {
                System.err.println("Invalid ID, please enter an Integer");
            }

        }
    }

    private void stockManDeleteTable() throws InterruptedException {
        String input = "";
        while (!input.equals("exit")) {
            Scanner scanner = new Scanner(System.in);
            String display =
                    "Select Table to clear (select option by number) \n" +
                            "1 -> Clear Beer \n" +
                            "2 -> Clear Drink \n" +
                            "3 -> Clear Snack \n" +
                            "4 -> Back \n";

            System.out.println("Loading menu...");
            pause();
            System.out.println(display);
            System.out.println("Type selection here: ");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    // Delete beer entry
                    if (doubleCheck()) {
                        currentImpl.getTableManager("Beers").deleteAll();
                        System.out.println("Table cleared!");
                        currentImpl.refreshStock(false);
                    }
                    break;
                case "2":
                    if (doubleCheck()) {
                        currentImpl.getTableManager("Drinks").deleteAll();
                        System.out.println("Table cleared!");
                        currentImpl.refreshStock(false);
                    }
                    break;
                case "3":
                    // Delete Snack entry
                    if (doubleCheck()) {
                        currentImpl.getTableManager("Snacks").deleteAll();
                        System.out.println("Table cleared!");
                        currentImpl.refreshStock(false);
                    }
                    break;
                default:
                    System.out.println("exiting...");
                    input = "exit";
            }
        }
        pause();
    }


    private void pause() throws InterruptedException {
        Thread.sleep(1000);
    }

    private void exitMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type and enter any letter to exit: ");
        scanner.nextLine();
    }

    private boolean doubleCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure?(y/n): ");
        String yn = scanner.nextLine();
        return yn.equals("y");
    }


    // to be completed

    private void menuStaff() throws InterruptedException {
        System.out.println("Coming soon ;)...");
        pause();
        exitMethod();
    }

    private void changeMode(String mode) throws InterruptedException {
        System.out.println("Coming soon ;)...");
        pause();
        exitMethod();
    }


}
