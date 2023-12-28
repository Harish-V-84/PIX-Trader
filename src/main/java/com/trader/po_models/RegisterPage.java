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

    @FindBy(xpath = "//div[text() = 'Get Code']")
    private WebElement getCode;

    @FindBy(xpath = "//div[text() = 'OTP sent successfully']")
    private WebElement otpSentMessage;

    @FindBy(name = "email_otp")
    private WebElement otpField;

    @FindBy(xpath = "//span[text() = 'Submit']//parent::div")
    private WebElement submitBtn;
}
