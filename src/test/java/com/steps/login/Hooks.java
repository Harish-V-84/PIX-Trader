package com.steps.login;

import com.trader.utils.TraderUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @BeforeAll
    public static void launchBrowser(){

        TraderUtils.launchBrowser("chrome", "https://pix-trader.pibase.info/login", "");
    }

    static int imageCount = 0;
    @AfterStep
    public static void takeScreenshot(Scenario scenario) {

        String name = scenario.getName();

//		System.out.println("scenario Name :"+name);

        if (scenario.isFailed()) {

            System.out.println("Scenario Fail : "+name);

            byte[] screenshot = ((TakesScreenshot)TraderUtils.driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "imagepass");

            Status status = scenario.getStatus();

            System.out.println("scenario status :"+status);
        }

        new TraderUtils().takeSnapShot(TraderUtils.driver, "\\Screenshot\\img"+imageCount+".png");
        imageCount++;

    }

    @AfterAll
    public static void afterAll(){

        TraderUtils.browserClose();
    }
}
