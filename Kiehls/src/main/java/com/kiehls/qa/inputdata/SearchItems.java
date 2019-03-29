package com.kiehls.qa.inputdata;

import databases.ConnectToSqlDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchItems {

    static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
    static String filePath = "C:\\Users\\Mira\\Documents\\GitHub\\WebAutomation2019\\Kiehls\\src\\test\\resources\\secret.properties";

    public static List<String> getItemValue() {
        List<String> shoppingList = new ArrayList<String>();
        shoppingList.add("face mask");
        shoppingList.add("eyecream");
        shoppingList.add("shampoo");
        shoppingList.add("lotion");
        shoppingList.add("deodorant");
        shoppingList.add("moisturizer ");
        shoppingList.add("sunscreen");

        return shoppingList;
    }

    public static String getFilePath(){

        return SearchItems.filePath;
    }

    public static void insertDataIntoDB() {
        List<String> list = getItemValue();
        connectToSqlDB.insertDataFromStringArrayListToSqlTable(list, "MenuOptions", "menuList", filePath);
    }

    public List<String> getItemsListFromDB() throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<String>();
        list = connectToSqlDB.readDataBase("MenuOptions", "menuList", filePath);
        return list;
    }

    public static void main(String[] args) throws Exception, IOException, SQLException, ClassNotFoundException {
        //insertDataIntoDB();
        List<String> list = getItemValue();

        connectToSqlDB.insertDataFromStringArrayListToSqlTable(list, "MenuOptions", "menuList", filePath);

        List<String> list1 = connectToSqlDB.readDataBase("MenuOptions", "menuList", filePath);
        for (String st : list1) {
            System.out.println(st);
        }

    }
}