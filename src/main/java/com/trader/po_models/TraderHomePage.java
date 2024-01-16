package com.trader.po_models;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class TraderHomePage {

    WebDriver driver;

    public TraderHomePage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text() = 'Dashboard']")
    private WebElement dashboard;

    @FindBy(xpath = "//span[text() = 'KYC Verification']")
    private WebElement kycVerification;

    @FindBy(xpath = "//span[text() = 'Referral']")
    private WebElement referral;

    @FindBy(xpath = "//span[text() = 'Trade']")
    private WebElement trade;

    @FindBy(xpath = "//span[text() = 'Spot Orders']")
    private WebElement spotOrders;

    @FindBy(xpath = "//span[text() = 'Wallet']")
    private WebElement wallet;

    @FindBy(xpath = "//span[text() = 'Earn']")
    private WebElement earn;

    @FindBy(xpath = "//span[text() = 'Security']")
    private WebElement security;

    @FindBy(xpath = "//span[text() = 'Settings']")
    private WebElement settings;

    @FindBy(xpath = "//span[text() = 'Support']")
    private WebElement support;
}
