package com.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = "com.steps",
        plugin = {

                "json:target/reports/WebAutomationJsonReports.json",

                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        dryRun = false, monochrome = true,
        tags = "@registerValidCredentials or @KYC_WithValidCredentials"
//        tags = "@registerValidCredentials"
)

public class TestRunner {


}
