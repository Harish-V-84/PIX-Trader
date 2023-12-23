package com.steps.login;

import com.trader.applicationData.LoginData;
import com.trader.utils.TraderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginWithValidCredentials extends TraderUtils {

    LoginData data = new LoginData("validCredentials");

    @Then("Verifying the given URL and actual web URL are same")
    public void verifying_the_given_url_and_actual_web_url_are_same() {

        Assert.assertEquals(getUrl(), "https://pix-trader.pibase.info/login");
    }

    @Given("User must enter the Email ID in the email Field")
    public void user_must_enter_the_email_id_in_the_email_field() {

        sendKeys(po_manager.getLogin().getEmailField(), data.emailID);
    }

    @Given("enter the password in the password field")
    public void enter_the_password_in_the_password_field() {

        sendKeys(po_manager.getLogin().getPasswordField(), data.password);
    }

    @Given("user should click the submit button")
    public void user_should_click_the_submit_button() {

        clickElement(po_manager.getLogin().getLoginBtn());

        clickElement(po_manager.getLogin().getCheckBox());

        clickElement(po_manager.getLogin().getAcceptBtn());
    }

    @Then("validate the user name from the Trader dashboard")
    public void validate_the_user_name_from_the_trader_dashboard() {

        Assert.assertEquals(getElementText(po_manager.getLogin().getDashboardName()), "Harish V");
    }

}
