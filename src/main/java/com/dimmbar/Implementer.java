package com.dimmbar;

import java.util.HashMap;

public class Implementer {
    // fields
    private String modeName = "Default";
    private HashMap<String, TableManager> managers;
    private StockManager stockManager;

    public Implementer(HashMap<String, TableManager> managers, StockManager stockManager) {
        this.managers = managers;
        this.stockManager = stockManager;
    }

    public HashMap<String, TableManager> getManagers() {
        return managers;
    }

    public TableManager getTableManager(String manager) {
        return (TableManager) getManagers().get(manager);
    }

    public StockManager getStockManager() {
        return stockManager;
    }


    public boolean attemptLogin() {
        return getTableManager("Beers").testConnection();
    }

    public void refreshStock(boolean togglePrint) {
        System.out.println("refreshing stock...");
        stockManager.getStock().clear();
        stockManager.getStockQtys().clear();
        for (TableManager manager : getManagers().values()) {
            stockManager.putAllStock(manager.getKeys(), manager.viewAll());
        }
        if (togglePrint) {
            System.out.println(stockManager.toString());
        }
    }

    @Override
    public String toString() {
        return modeName;
    }

    // Instance specific methods

    // this displays the available products by category
    // need to add logic to check stock and add SOLD OUT to stock with qty 0
    public void displayEntries(String table) {
        for (Entry item : getStockManager().getStock().values()) {
            if (item.getClass().toString().contains(table)) {
                System.out.println(item.displayEntry("SOLD OUT", 0));
            }
        }
    }







    /*
     * what does this class need?
     * what are the variables
     * what are the dependencies
     * write these down for each methods
     *
     *
     *
     *
     * */

    // create a com.dimmbar.StockManager object at startup
    // order it to populate itself with data

    // recieves commands from com.dimmbar.InputHandler
    // translates DB data to useful information

    // whether we can generics to do this

    // Factory method

}
