package databases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectToSqlDB {
    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public static Properties loadProperties(String filepath) throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream(filepath);
        prop.load(ism);
        ism.close();
        return prop;
    }

    public static Connection connectToSqlDatabase(String filepath) throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties(filepath);
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url,userName,password);
        System.out.println("Database is connected");
        return connect;
    }

    public List<String> readDataBase(String tableName, String columnName, String propertiesFilePath)throws Exception{
        List<String> data = new ArrayList<String>();
        try {
            connectToSqlDatabase(propertiesFilePath);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            //data = getResultSetData(resultSet, columnName);
            while(resultSet.next()){
                String itemName = resultSet.getString(columnName);
                data.add(itemName);
            }
        } catch (ClassNotFoundException e) {
            throw e;
        }finally{
            close();
        }
        return data;
    }

    private void close() {
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connect != null){
                connect.close();
            }
        }catch(Exception e){

        }
    }
}
