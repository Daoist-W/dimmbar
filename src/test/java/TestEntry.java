import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;

public class TestEntry {

    // can create own instance of its class
    @Test
    public void shouldCreateNewInstance() {
        Entry beer = new Beer();

        HashMap<String, Integer> intData = new HashMap<>();
        intData.put("beer_id", 106);
        intData.put("price", 0);
        intData.put("abv", 0);

        HashMap<String, String> stringData = new HashMap<>();
        stringData.put("name_", "TEST");
        stringData.put("subtype", "TEST");
        stringData.put("brewery", "TEST");

        Entry newInstance = beer.newInstance(intData, stringData);

        assertNotNull(newInstance);
    }


}
