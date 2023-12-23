package com.trader.po_models;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class RegisterPage {

    public WebDriver driver;

    public RegisterPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "first_name")
    private WebElement firstName;

    @FindBy(name = "last_name")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//span[text() = 'Create account']//parent::div")
    private WebElement createAccountBtn;

}
