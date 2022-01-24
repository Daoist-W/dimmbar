import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestStockManager {

    // test objects of all Entry subclasses are stored
    // test stock information is stored
    @Test
    public void shouldStoreBeerObjects() {
        BeerManager beerManager = new BeerManager(new JDBC_Beers("dimmbarmanager", "D1mb@rrman@g3r9468"));
        StockManager stockManager = new StockManager();

        //expected
        ArrayList<Entry> entries = beerManager.viewAll();
        ArrayList<String> keys = new ArrayList<>();
        entries.forEach(entry -> keys.add(entry.getStringData("name_")));

        // actual
        stockManager.putAllStock(keys, entries);

        assertEquals(entries.size(), stockManager.getStock().size());

    }

    // test information is updated to reflect changes


}
