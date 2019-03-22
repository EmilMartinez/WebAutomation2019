package com.homedepo.qa.inputdata;

import databases.ConnectToSqlDB;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuOptions {

    @FindBy(xpath = "")

    static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

    public static List<String> getItemValue() {
        List<String> menuList = new ArrayList<String>();
        menuList.add("SHOP");
        menuList.add("NEW");
        menuList.add("BRANDS");
        menuList.add("GIFTS");
        menuList.add("QUIZZES");
        menuList.add("COMMUNITY");
        menuList.add("HAPPENING IN STORE");

        return menuList;
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