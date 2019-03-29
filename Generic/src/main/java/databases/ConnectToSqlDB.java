package databases;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by mrahman on 04/02/18.
 */

public class ConnectToSqlDB {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public static Properties loadProperties(String filePath) throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream(filePath);
        prop.load(ism);
        ism.close();
        return prop;
    }

    public static Connection connectToSqlDatabase(String filePath) throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties(filePath);
        //String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("url");
        String userName = prop.getProperty("username");
        String password = prop.getProperty("password");
        connect = DriverManager.getConnection(url, userName, password);
        System.out.println("Database is connected");
        return connect;
    }

    public List<String> readDataBase(String tableName, String columnName, String filePath) throws Exception {
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase(filePath);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }



    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    private List<String> getResultSetData(ResultSet resultSet2, String columnName) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while (resultSet.next()) {
            String itemName = resultSet.getString(columnName);
            dataList.add(itemName);
        }
        return dataList;
    }


    public void insertDataFromArrayToSqlTable(int[] ArrayData, String tableName, String columnName, String filePath) {
        try {
            connectToSqlDatabase(filePath);
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (int n = 0; n < ArrayData.length; n++) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setInt(1, ArrayData[n]);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromStringToSqlTable(String ArrayData, String tableName, String columnName, String filePath) {
        try {
            connectToSqlDatabase(filePath);
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
            ps.setString(1, ArrayData);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Created this method to pass an ArrayList of type Integer.
    public void insertDataFromIntegerArrayListToSqlTable(List<Integer> list, String tableName, String columnName, String filePath) {
        try {
            connectToSqlDatabase(filePath);
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (Integer i : list) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setObject(1, i);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromStringArrayListToSqlTable(List<String> list, String tableName, String columnName, String filePath) {
        try {
            connectToSqlDatabase(filePath);
            ps = connect.prepareStatement("DROP TABLE IF EXISTS " + tableName + ";");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` VARCHAR(30) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (String st : list) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setObject(1, st);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromWebElementArrayListToSqlTable(List<WebElement> list, String tableName, String columnName, String filePath) {
        try {
            connectToSqlDatabase(filePath);
            ps = connect.prepareStatement("DROP TABLE IF EXISTS " + tableName + ";");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` VARCHAR(30) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (WebElement we : list) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setObject(1, we);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataToExistingSqlTable(String value, String tableName, String columnName,String filePath) {
        try {
            connectToSqlDatabase(filePath);
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES (\'" + value + "\')");
            ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> directDatabaseQueryExecute(String passQuery, String dataColumn, String filePath) throws Exception {
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase(filePath);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, dataColumn);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }


    public void insertProfileToSqlTable(String tableName, String columnName1, String columnName2, String filePath) {
        try {
            connectToSqlDatabase(filePath);
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
            ps.setString(1, "Mira");
            ps.setInt(2, 3456);
            ps.executeUpdate();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}