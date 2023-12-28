package com.trader.po_models;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class KYC_VerificationPage {

    public WebDriver driver;

    public KYC_VerificationPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text() = 'KYC Verification']")
    private WebElement kycText;

    /* ===== Mobile Verification ===== */

    @FindBy(xpath = "//input[@placeholder='Phone number']")
    private WebElement EnterMobileNum;

    @FindBy(xpath = "//input[@name='new_phone_otp']//parent::div//child::a//child::div[text() = 'Get Code']")
    private WebElement clickMobileCode;

    @FindBy(xpath = "//input[@name='new_phone_otp']")
    private WebElement mobileOTPInputField;

    @FindBy(xpath = "//input[@name='email_otp']//parent::div//child::a//child::div[text() = 'Get Code']")
    private WebElement clickEmailCode;

    @FindBy(xpath = "//input[@name='email_otp']")
    private WebElement emailOTPInputField;

    @FindBy(xpath = "//span[text() ='Verify Mobile']")
    private WebElement verifyMobileBtn;

    /* ===== Personal Information ===== */

    @FindBy(xpath = "//select[@name ='gender']")
    private WebElement selectGender;

    @FindBy(xpath = "//input[@name ='dob']")
    private WebElement DateOfBrithInputField;

    @FindBy(xpath = "//select[@name ='occupation']")
    private WebElement selectOccupation;

    @FindBy(xpath = "//select[@name ='annual_income']")
    private WebElement selectAnnualIncome;



}
