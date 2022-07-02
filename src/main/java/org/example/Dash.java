package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Dash {
    Page page;

    public Dash(Page page) {
        this.page = page;
    }

    void customer(String email,String password,String firstname,String lastname,String company,String comment,String value){
        page.click("body > div:nth-child(3) > aside:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)");
        page.click("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
        page.click("a[class='btn btn-primary']");
        page.fill("#Email",email);
        page.fill("#Password",password);
        page.fill("#FirstName",firstname);
        page.fill("#LastName",lastname);
        page.click("#Gender_Male");
        page.fill("#Company",company);
        page.check("#IsTaxExempt");
        page.selectOption("#VendorId",value);
        page.fill("#AdminComment",comment);
        page.click("button[name='save']");
        page.click("tbody tr:nth-child(1) td:nth-child(7) a:nth-child(1)");
        page.click("#customer-delete");
        //page.click("button[class='btn btn-danger float-right']");
      page.onceDialog(dialog->{
          dialog.accept();
        });
page.click("//a[normalize-space()='Logout']");
    }


}
