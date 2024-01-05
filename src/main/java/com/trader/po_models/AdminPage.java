package com.trader.po_models;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AdminPage {

    public WebDriver driver;

    public AdminPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "email")
    private WebElement emailId;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//span[text() = 'Sign in']")
    private WebElement submitBtn;

    @FindBy(xpath = "//p[text() = 'Notifications']")
    private WebElement notificationPage;

    public WebElement emailMore(String email) {

        return driver.findElement(By.xpath("//table//child::tbody//following-sibling::td[text() = '"
                + email + "']//parent::tr//child::td//child::div//child::button"));
    }

    public WebElement mobileMore(String mobileNum){

        return driver.findElement(By.xpath("//table//child::tbody//following-sibling::td[text() = '+91"
                + mobileNum + "']//parent::tr//child::td//child::div//child::button"));
    }

    @FindBy(xpath = "//div[text() = 'View']")
    private WebElement ViewBtn;

    @FindBy(xpath = "//div[text() = 'Notification Payload']//parent::div//child::p")
    private WebElement otpText;


}
