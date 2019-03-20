package datasource;

import databases.ConnectToSqlDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlData {
    static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
    String filepath = "../Amazon/src/test/resources/secret.properties";

    public List<String> getItemsListFromDB()throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        list = connectToSqlDB.readDataBase("ItemList", "items", filepath);
        return list;
    }
}
