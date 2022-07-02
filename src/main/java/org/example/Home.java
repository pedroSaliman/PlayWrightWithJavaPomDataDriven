package org.example;

import com.microsoft.playwright.Page;

public class Home {
    Page page;

    public Home(Page page) {
        this.page = page;
    }
    public Dash  enterinfo(String email, String pass){
        page.fill("#Email","");
        page.fill("#Email",email);
        page.fill("#Password","");
        page.fill("#Password",pass);
        page.click("button[type='submit']");

        return new Dash(page);



    }
}
