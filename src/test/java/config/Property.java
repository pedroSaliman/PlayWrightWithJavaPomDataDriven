package config;

import org.example.First;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {
    public static void main(String[] args) {


    }
    public  static void proper() throws IOException {
        Properties prop=new Properties();
        InputStream input = new FileInputStream("E://seleniumprojects//gitendtoend//PLAY//src//test//java//config//config.properties");
        prop.load(input);
        String browser=prop.getProperty("browser");
        First.browserName=browser;
        String theUrl = prop.getProperty("url");
        First.Url=theUrl;
    }
}
