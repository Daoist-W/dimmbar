public class TestInputImplementer {

    // input handler sanitizes inputs and turns them into enums etc

    // implementer wraps around com.dimmbar.TableManager methods and adds conversion/manipulates

    // can transmit CRUD instructions to Manager

    // can switch between managers used

    // can retrieve information in com.dimmbar.StockManager

    // can trigger com.dimmbar.StockManager to refresh data

    // should not directly modify information stored in com.dimmbar.StockManager
    // instead it should Update database and order storage should refresh

    // can process information retrieved from com.dimmbar.StockManager

    //

}
