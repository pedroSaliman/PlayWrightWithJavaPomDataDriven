package org.example;

import com.microsoft.playwright.*;
import config.Property;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class First {

    Page page;
    Playwright play;
    Browser browser;
    Home home;
    Dash dash;
 public static    String browserName=null;
    public static    String Url=null;


    @BeforeTest
    void set() throws IOException {

        play = Playwright.create();
        Property.proper();
        switch (browserName){
            case "chrome":
                browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
                break;
            case "firefox":
                browser = play.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
                break;
            case "safari":
                browser = play.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
                break;
            default:
                System.out.println("there something wrong");
                break;
        }
        page = browser.newPage();
        page.navigate(Url);

    }


    @Test(dataProvider = "data")
    void shouldClickButton(String email,String pass,String theemail) {
        home = new Home(page);
        home.enterinfo(email, pass);

        dash = new Dash(page);
        dash.customer(theemail, "2521997", "mohamed", "walled", "mansoura", "this is very good", "1");


    }

    @DataProvider(name = "data")
    Object[][] enter() {
        Object[][] data = {{"admin@yourstore.com","admin","adminml@gmail.com"}, {"admin@yourstore.com","admin","waledadmin@gmail.com"}, {"admin@yourstore.com","admin","amn@gmail.com"}};
        return  data;
    }


}
