package datasource;

import databases.ConnectToMongoDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MongoDbData {
    ConnectToMongoDB connectToMongoDB = new ConnectToMongoDB();
    String database = "pnt";
    String profile = "searchItems";

    public List<String> getItemsListFromDB()throws Exception, IOException, SQLException, ClassNotFoundException {
        return connectToMongoDB.readMongoDbData(database, profile);
    }
}
