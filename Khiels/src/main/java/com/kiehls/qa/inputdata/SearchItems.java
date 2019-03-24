package com.kiehls.qa.inputdata;

import databases.ConnectToSqlDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchItems {

    static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

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

    public static void insertDataIntoDB() {
        List<String> list = getItemValue();
        connectToSqlDB.insertDataFromStringArrayListToSqlTable(list, "MenuOptions", "menuList");
    }


    public List<String> getItemsListFromDB() throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<String>();
        list = connectToSqlDB.readDataBase("MenuOptions", "menuList");
        return list;
    }

    public static void main(String[] args) throws Exception, IOException, SQLException, ClassNotFoundException {
        //insertDataIntoDB();
        List<String> list = getItemValue();

        connectToSqlDB.insertDataFromStringArrayListToSqlTable(list, "MenuOptions", "menuList");

        List<String> list1 = connectToSqlDB.readDataBase("MenuOptions", "menuList");
        for (String st : list1) {
            System.out.println(st);
        }

    }
}