package com.kiehls.qa.inputdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    Properties prop;

    public Properties loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\Mira\\Documents\\GitHub\\WebAutomation2019\\Sephora\\src\\test\\resources\\SignUp.properties");
        prop.load(ip);
        return prop;
    }
}

