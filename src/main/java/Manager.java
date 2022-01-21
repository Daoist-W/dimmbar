import java.util.ArrayList;

// This interface provides a template for all JDBC Single Table Managers
// a core set of CRUD methods are specified here
public interface Manager {

    // create
    void addEntry(Entry entry);

    // Delete
    void deleteEntry(int entry_id, String col_name);

    // Read
    Entry viewEntry(int entry_id);

    ArrayList<Entry> viewAll();

    ArrayList<Entry> viewAllWhere(String condition);

    // update
    ArrayList<Entry> updateWhere(Entry entry, String condition, String value);


}
