import java.util.ArrayList;
import java.util.HashMap;

public class StockManager {
    // fields
    private HashMap<String, Entry> stock = new HashMap<>();
    private HashMap<String, Entry> stockQtys = new HashMap<>();


    public HashMap<String, Entry> getStock() {
        return stock;
    }

    public HashMap<String, Entry> getStockQtys() {
        return stockQtys;
    }

    public void putStock(String key, Entry entry) {
        getStock().put(key, entry);
    }

    public void putStockQtys(String key, Entry entry) {
        getStockQtys().put(key, entry);
    }

    public void putAllStock(ArrayList<String> keys, ArrayList<Entry> entries) {
        for (int i = 0; i < keys.size(); i++) {
            putStock(keys.get(i), entries.get(i));
        }
    }

    public void putAllStockQtys(ArrayList<String> keys, ArrayList<Entry> entries) {
        for (int i = 0; i < keys.size(); i++) {
            putStockQtys(keys.get(i), entries.get(i));
        }
    }

    public void refresh(ArrayList<String> keys, ArrayList<Entry> entries) {
        putAllStock(keys, entries);
//        putAllStockQtys(keys, qtys);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        getStock().forEach((item, value) -> sb.append(item)
                .append("\nClass: ")
                .append(value).append("\n"));
        return "StockManager{ \n" +
                "stock: \n" + sb +
                '}';
    }
    // to store Entry objects from Manager
    // to store stock information from Manager
    // transfer information to inputImplementer via get methods


}
