import java.util.ArrayList;

// This interface provides a template for all JDBC Single Table Managers
// a core set of CRUD methods are specified here
public interface TableManager {

    // establish connection
    boolean testConnection();

    // this is for human input
    Entry createEntry();

    // create
    void addEntry();

    void addEntry(Entry entry);

    // Delete
    void deleteEntry(int entry_id, String col_name);

    void deleteBySubtype(String value);

    void deleteAll();

    // Read
    Entry viewEntry(int entry_id);

    ArrayList<Entry> viewAll();

    ArrayList<String> getKeys();

    ArrayList<Entry> viewAllWhere(String condition);

    // update
    ArrayList<Entry> updateByString(Entry entry, String condition, String value);

    ArrayList<Entry> updateByInt(Entry entry, String condition, int value);


}
