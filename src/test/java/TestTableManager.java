import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestTableManager {
    // can execute CRUD operations

    // can add an entry
    @Test
    public void shouldAddEntryToBeersTable() {
        HashMap<String, Integer> intData = new HashMap<>();
        intData.put("beer_id", 106);
        intData.put("price", 0);
        intData.put("abv", 0);

        HashMap<String, String> stringData = new HashMap<>();
        stringData.put("name_", "TEST");
        stringData.put("subtype", "TEST");
        stringData.put("brewery", "TEST");

        Entry entry = new Beer(intData, stringData);
        TableManager beerManager = new BeerManager(new JDBC_Beers("dimmbarmanager", "D1mb@rrman@g3r9468"));
        beerManager.addEntry(entry);

        Beer expected = (Beer) beerManager.viewEntry(106);

        assertEquals(expected.toString(), entry.toString());
    }

}
