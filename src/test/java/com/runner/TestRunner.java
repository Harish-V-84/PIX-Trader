package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = "com.steps",
        dryRun = false, monochrome = true,
        tags = "@loginWithValidCredentials"

)
public class TestRunner {


}
