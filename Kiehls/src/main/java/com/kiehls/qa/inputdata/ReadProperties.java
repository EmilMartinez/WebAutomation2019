package com.kiehls.qa.inputdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    static Properties prop = null;

    public static Properties loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\Mira\\Documents\\GitHub\\" +
                "WebAutomation2019\\Kiehls\\src\\test\\resources\\LogIn.properties");
        prop.load(ip);

        return prop;
    }
}

