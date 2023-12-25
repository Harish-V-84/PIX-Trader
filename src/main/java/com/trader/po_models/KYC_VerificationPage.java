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


}
