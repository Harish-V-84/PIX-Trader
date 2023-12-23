package com.steps;

import com.trader.utils.TraderUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    static TraderUtils base = new TraderUtils();

    @BeforeAll
    public static void launchBrowser(){

        base.deleteFolder();

        base.createNewFolder();

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

        base.takeSnapShot(TraderUtils.driver, base.filePaths().get("Screenshots")+"/img"+imageCount+".png");
        imageCount++;

    }

    @AfterAll
    public static void afterAll(){

        base.browserClose();
    }
}
