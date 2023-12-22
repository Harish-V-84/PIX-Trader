package com.runner;

import com.trader.utils.TraderUtils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = "steps",
//        dryRun = true, monochrome = true,
        tags = "@loginWithValidCredentials"

)
public class TestRunner {


}
