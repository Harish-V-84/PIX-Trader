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

    @FindBy(xpath = "//div[text() = 'OTP sent successfully']")
    private WebElement otpSentMessage;

    @FindBy(xpath = "//input[@name='new_phone_otp']")
    private WebElement mobileOTPInputField;

    @FindBy(xpath = "//input[@name='email_otp']//parent::div//child::a//child::div[text() = 'Get Code']")
    private WebElement clickEmailCode;

    @FindBy(xpath = "//input[@name='email_otp']")
    private WebElement emailOTPInputField;

    @FindBy(xpath = "//span[text() ='Verify Mobile']")
    private WebElement verifyMobileBtn;

    /* ===== Personal Information ===== */

    @FindBy(xpath = "//h3[text() = 'Personal Information']")
    private WebElement personalInformationText;

    @FindBy(xpath = "//select[@name ='gender']")
    private WebElement selectGender;

    @FindBy(xpath = "//input[@name ='dob']")
    private WebElement DateOfBrithInputField;

    @FindBy(xpath = "//select[@name ='occupation']")
    private WebElement selectOccupation;

    @FindBy(xpath = "//select[@name ='annual_income']")
    private WebElement selectAnnualIncome;

    @FindBy(xpath = "//input[@name = 'account_purpose']")
    private WebElement purposeOfAccountFiled;

    @FindBy(xpath = "//input[@name = 'permanent_address_state']")
    private WebElement permanentAddressState;

    @FindBy(xpath = "//input[@name = 'permanent_address_city']")
    private WebElement permanentAddressCity;

    @FindBy(xpath = "//input[@name = 'permanent_address_street']")
    private WebElement permanentAddressStreet;

    @FindBy(xpath = "//input[@name = 'permanent_address_door_number']")
    private WebElement permanentAddressDoorNum;

    @FindBy(xpath = "//input[@name = 'is_current_address_same']")
    private WebElement currentAddressCheckbox;

    @FindBy(name = "current_address_state")
    private WebElement currentAddressState;

    @FindBy(name = "current_address_city")
    private WebElement currentAddressCity;

    @FindBy(name = "current_address_street")
    private WebElement currentAddressStreet;

    @FindBy(name = "current_address_door_number")
    private WebElement currentAddressDoorNum;

    @FindBy(xpath = "//span[text() = 'Submit']//parent::div")
    private WebElement submitBtn;

    /* ===== suitability Assessment ===== */

    @FindBy(xpath = "//h3[text() = 'Suitability Assessment']")
    private WebElement suitabilityAssessmentText;

    @FindBy(name = "assessment_1")
    private WebElement assessment1;

    @FindBy(name = "assessment_2")
    private WebElement assessment2;

    @FindBy(name = "education_level")
    private WebElement educationLevel;

    /* ===== Bank Details ===== */

    @FindBy(xpath = "//h3[text() = 'Bank Details']")
    private WebElement bankDetailsText;

    @FindBy(name = "bank_name")
    private WebElement bankName;

    @FindBy(name = "branch_name")
    private WebElement branchName;

    @FindBy(name = "account_number")
    private WebElement accountNumber;

    @FindBy(name = "swift")
    private WebElement swift;

    @FindBy(name = "iban")
    private WebElement iban;

    @FindBy(name = "bank_address")
    private WebElement bankAddress;

    @FindBy(name = "account_type")
    private WebElement selectAccountType;

    /** ===== Documents ===== **/

    @FindBy(xpath = "//h3[text() = 'Documents']")
    private WebElement documentText;

    @FindBy(xpath = "//span[text() = 'PASSPORT']//parent::label//child::input")
    private WebElement passportRadioBtn;

    @FindBy(name = "PASSPORTdocument_id")
    private  WebElement documentID;

    @FindBy(xpath = "//span[contains(text(), 'Upload the ')]")
    private WebElement uploadDocumentFile;

    /** ===== selfie ===== **/

    @FindBy(xpath = "//h3[text() = 'Selfie']")
    private WebElement selfieText;

    @FindBy(xpath = "//span[contains(text(), 'Upload ')]")
    private WebElement uploadSelfie;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private WebElement privacyPolicyCheckbox;

}
