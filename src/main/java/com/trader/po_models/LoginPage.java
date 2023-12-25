package com.trader.po_models;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//span[text() = 'Log In']//parent::div")
    private WebElement loginBtn;

    @FindBy(xpath = "//h3[@class = 'mr-2 text-xl']")
    private WebElement dashboardName;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//span[text() = 'Accept']")
    private WebElement acceptBtn;

    @FindBy(xpath = "//a[text() = 'Register Now']")
    private WebElement registerNow;

}
