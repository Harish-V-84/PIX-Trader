package com.trader.po_manager;

import com.trader.po_models.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public static LoginPage login;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver2) {

        this.driver = driver2;
    }

    public LoginPage getLogin(){

        return login == null ? new LoginPage(driver) : login;
    }

}
