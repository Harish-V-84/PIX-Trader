package com.trader.po_models;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class CRM_LoginPage {

    WebDriver driver;

    public CRM_LoginPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    private WebElement emailId;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//span[text() = 'Sign in']//parent::div//parent::button")
    private WebElement signInBtn;

    @FindBy(xpath = "//span[text() = 'Client Management']")
    private WebElement clientManagement;

    @FindBy(xpath = "//ul//child::li//child::a//child::span[text() = 'KYC Submitted']")
    private WebElement kycSubmitted;

    public WebElement more(String emailID){

//        return driver.findElement(By.xpath("//table//child::tbody//child::tr//child::td[text() = '"+
//                emailID+"']//parent::tr//child::td//child::div//child::div//child::button//child::div//child::span[text() = 'More']"));

        return driver.findElement(By.xpath("//table//child::tbody//child::td[text() = '"+emailID+"']//parent::tr//child::button"));
    }

    @FindBy(xpath = "//div[text() = 'View']")
    private WebElement view;

    @FindBy(xpath = "//span[text() = 'Reject']")
    private WebElement rejectBtn;

    @FindBy(xpath = "//span[text() = 'Approve']")
    private WebElement approveBtn;

    @FindAll(
            @FindBy(xpath = "//span[text() = 'Approve']")
    )private List<WebElement> approveButtons;

}
