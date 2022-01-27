//import org.junit.Test;
//
//import java.util.HashMap;
//
//import static org.junit.Assert.assertEquals;
//
//public class TestTableManager {
//    // can execute CRUD operations
//
//    // can add an entry
//    @Test
//    public void shouldAddEntryToBeersTable() {
//        HashMap<String, Integer> intData = new HashMap<>();
//        intData.put("beer_id", 106);
//        intData.put("price", 0);
//        intData.put("abv", 0);
//
//        HashMap<String, String> stringData = new HashMap<>();
//        stringData.put("name_", "TEST");
//        stringData.put("subtype", "TEST");
//        stringData.put("brewery", "TEST");
//
//        com.dimmbar.Entry entry = new com.dimmbar.Beer(intData, stringData);
//        com.dimmbar.TableManager beerManager = new com.dimmbar.BeerManager(new com.dimmbar.JDBC_Beers("dimmbarmanager", "D1mb@rrman@g3r9468"));
//        beerManager.addEntry(entry);
//
//        com.dimmbar.Beer expected = (com.dimmbar.Beer) beerManager.viewEntry(106);
//
//        assertEquals(expected.toString(), entry.toString());
//    }
//
//}
