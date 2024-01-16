package com.trader.po_models;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class SecurityPage {

    WebDriver driver;

    public SecurityPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    /* ===== Two-Factor Authentication ===== */
    // Google Auth
    @FindBy(xpath = "//h3[text() = 'Google Authenticator (Recommended)']//parent::div//parent::div//child::button")
    private WebElement googleAuthEnableBtn;

    @FindBy(xpath = "//div[text() = 'Get Code']")
    private WebElement googleAuthEmailGetCode;

    @FindBy(name = "email_otp")
    private WebElement googleAuthEmailOTPInput;

    @FindBy(name = "gauth_otp")
    private WebElement googleAuthCodeInput;

    @FindAll(
            @FindBy(xpath = "//p[contains(text(), '2.')]//parent::div//child::p")
    )private List<WebElement> googleAuthCode;

    @FindBy(xpath = "//span[text() ='Enable google authenticator']")
    private WebElement enableGoogleAuthBtn;

    //Mobile verification
    @FindBy(xpath = "//h3[text() = 'Phone Number Verification']//parent::div//parent::div//child::button")
    private WebElement mobileNumEnableBtn;

    @FindBy(xpath = "//input[@name = 'new_phone_otp']//parent::div//child::div[text() = 'Get Code']")
    private WebElement mobileAuthNewPhoneGetCode;

    @FindBy(xpath = "//input[@name = 'email_otp']//parent::div//child::div[text() = 'Get Code']")
    private WebElement MobileAuthNewEmailGetCode;

    @FindBy(name = "new_phone_otp")
    private WebElement mobileAuthNewPhoneOTPInput;

    @FindBy(xpath = "email_otp")
    private WebElement mobileAuthNewEmailOTPInput;

    @FindBy(xpath = "//span[text() = 'Enable phone authentication']")
    private WebElement mobileAuthEnablePhoneAuth;

    //Email Change
    @FindBy(xpath = "//h3[text() = 'Email Address Verification']//parent::div//parent::div//child::button")
    private WebElement emailChangeBtn;


}