//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//
//public class TestStockManager {
//
//    // test objects of all com.dimmbar.Entry subclasses are stored
//    // test stock information is stored
//    @Test
//    public void shouldStoreBeerObjects() {
//        com.dimmbar.BeerManager beerManager = new com.dimmbar.BeerManager(new com.dimmbar.JDBC_Beers("dimmbarmanager", "D1mb@rrman@g3r9468"));
//        com.dimmbar.StockManager stockManager = new com.dimmbar.StockManager();
//
//        //expected
//        ArrayList<com.dimmbar.Entry> entries = beerManager.viewAll();
//        ArrayList<String> keys = new ArrayList<>();
//        entries.forEach(entry -> keys.add(entry.getStringData("name_")));
//
//        // actual
//        stockManager.putAllStock(keys, entries);
//
//        assertEquals(entries.size(), stockManager.getStock().size());
//
//    }
//
//    // test information is updated to reflect changes
//
//
//}
