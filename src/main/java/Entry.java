// interface provides a template for Table entry objects

public interface Entry {
    @Override
    String toString();

    Entry newInstance(String[] sList);

    public int id(); // id

    public int getPrice(); // prices

    public String getAttr1(); // type

    public String getAttr2(); // abv

    public String getAttr3(); // abv


}
