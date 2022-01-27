import com.dimmbar.Beer;
import com.dimmbar.BeerManager;
import com.dimmbar.JDBC_Beers;
import com.dimmbar.JDBC_Setup;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestJDBC_Setup {

    // test connection is successful be comparing getClass results
    @Test
    public void shouldConnect() {
        JDBC_Setup jdbc_setup = new JDBC_Beers("dimmbarmanager", "D1mb@rrman@g3r9468");
        assertNotNull(jdbc_setup.connect());
    }

    // test information can be retrieved
    @Test
    public void shouldRetrieveBeerObject() {
        JDBC_Setup jdbc_setup = new JDBC_Beers("dimmbarmanager", "D1mb@rrman@g3r9468");
        BeerManager beerManager = new BeerManager(jdbc_setup);

        Beer entry = (Beer) beerManager.viewEntry(104);

        System.out.println(entry);
        System.out.println(entry.getClass());

        assertEquals(Beer.class, entry.getClass());
    }
}
