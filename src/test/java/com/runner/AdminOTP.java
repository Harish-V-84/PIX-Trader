package com.runner;

import com.trader.utils.TraderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminOTP {

    private static WebDriver driver;
    public static String  emailOTP;
    public static String  mobileOTP;

    public static void getOTP(String emailID, String mobileNum){

        new AdminOTP().getMailAndMobileOTP(emailID, mobileNum);
    }

    private AdminOTP(){}


    private void getMailAndMobileOTP(String emailID, String mobileNum){

        try {
            TraderUtils baseClass = new TraderUtils();

            ChromeOptions options = new ChromeOptions();

//            options.addArguments("--headless=new");

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://pix-admin.pibase.info/login");

            WebElement email = driver.findElement(By.name("email"));

            sendKeys(email, "sunil@pibase.info");

            WebElement password = driver.findElement(By.name("password"));

            sendKeys(password, "nullvoid@13");

            baseClass.sleep(1000);

            WebElement submitBtn = driver.findElement(By.xpath("//span[text() = 'Sign in']"));

            clickElement(submitBtn);

            clickElement(driver.findElement(By.xpath("//p[text() = 'Notifications']")));

//        //table//child::tbody//following-sibling::td[text() = 'harish.venkat2018@gmail.com']//parent::tr//child::td//child::div//child::button

            if (!emailID.isEmpty() && !mobileNum.isEmpty()) {

                WebElement emailMore = driver.findElement(By.xpath("//table//child::tbody//following-sibling::td[text() = '" + emailID + "']//parent::tr//child::td//child::div//child::button"));

                clickElement(emailMore);

                WebElement emailView = driver.findElement(By.xpath("//div[text() = 'View']"));

                clickElement(emailView);

                WebElement emailOtp = driver.findElement(By.xpath("//div[text() = 'Notification Payload']//parent::div//child::p"));

                emailOTP = getText(emailOtp);

                driver.navigate().back();

                baseClass.sleep(500);

                WebElement mobileMore = driver.findElement(By.xpath("//table//child::tbody//following-sibling::td[text() = '+91" + mobileNum + "']//parent::tr//child::td//child::div//child::button"));

                clickElement(mobileMore);

                WebElement mobileView = driver.findElement(By.xpath("//div[text() = 'View']"));

                clickElement(mobileView);

                WebElement mobileOtp = driver.findElement(By.xpath("//div[text() = 'Notification Payload']//parent::div//child::p"));

                mobileOTP = getText(mobileOtp);

            }else {

                WebElement emailMore = driver.findElement(By.xpath("//table//child::tbody//following-sibling::td[text() = '" + emailID + "']//parent::tr//child::td//child::div//child::button"));

                clickElement(emailMore);

                WebElement view = driver.findElement(By.xpath("//div[text() = 'View']"));

                clickElement(view);

                WebElement otp = driver.findElement(By.xpath("//div[text() = 'Notification Payload']//parent::div//child::p"));

                emailOTP = getText(otp);
            }

            Thread.sleep(400);
            driver.close();
//        driver.quit();

        } catch (Exception exception) {

            System.out.println("problem in Admin class for get OTP "+ exception.getMessage());
        }
    }

    static WebDriverWait wait;

    public WebDriverWait waitObj() {

        return wait == null ? new WebDriverWait(driver, Duration.ofSeconds(20)) : wait;
    }
    private void sendKeys(WebElement element, String value){

        waitObj().until(ExpectedConditions.elementToBeClickable(element)).sendKeys(value);
    }
    private void clickElement(WebElement element){

        waitObj().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    private String getText(WebElement element){

        return waitObj().until(ExpectedConditions.elementToBeClickable(element)).getText();
    }

}
