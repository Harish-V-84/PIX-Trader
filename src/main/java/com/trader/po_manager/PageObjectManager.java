package com.trader.po_manager;

import com.trader.po_models.LoginPage;
import com.trader.po_models.RegisterPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private LoginPage login;

    private RegisterPage registerPage;

    public WebDriver driver;

    public PageObjectManager(WebDriver driver2) {

        this.driver = driver2;
    }

    public LoginPage getLogin(){

        return login == null ? new LoginPage(driver) : login;
    }

    public RegisterPage getRegisterPage(){

        return registerPage == null ? new RegisterPage(driver) : registerPage;
    }

}
