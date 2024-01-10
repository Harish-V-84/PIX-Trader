package com.steps.register;

import com.runner.AdminOTP;
import com.runner.AdminOTP2;
import com.trader.applicationData.RegisterData;
import com.trader.utils.TraderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterWithValidCredentials extends TraderUtils {

    static RegisterData userData = new RegisterData("validCredentials");
    @Given("the user should click on Register Now hyperlink")
    public void the_user_should_click_on_register_now_hyperlink() {

        clickElement(po_manager.getLogin().getRegisterNow());
    }
    @Then("validate Register page url")
    public void validate_register_page_url() {

        Assert.assertEquals(getUrl(), userData.url);
    }
    @Then("user fills the form by entering the first name")
    public void user_fills_the_form_by_entering_the_first_name() {

        sendKeys(po_manager.getRegisterPage().getFirstName(), RegisterData.firstName);
    }
    @Then("last name")
    public void last_name() {

        sendKeys(po_manager.getRegisterPage().getLastName(), RegisterData.lastName);
    }
    @Then("email ID")
    public void email_id() {

        sendKeys(po_manager.getRegisterPage().getEmail(), RegisterData.emailID);
    }
    @Then("password")
    public void password() {

        sendKeys(po_manager.getRegisterPage().getPassword(), RegisterData.password);
    }
    @Then("user click on check box for terms and conditions")
    public void user_click_on_check_box_for_terms_and_conditions() {

        clickElement(po_manager.getRegisterPage().getCheckBox());

        sleep(500);

        List<WebElement> checkBoxes = po_manager.getRegisterPage().getCheckBoxes();

        for (int i = 0; i < checkBoxes.size(); i++){

            if (i == 1 || i == 2){

                clickElement(checkBoxes.get(i));
            }
        }

        scrollToElement(po_manager.getRegisterPage().getAcceptBtn());

        clickElement(po_manager.getRegisterPage().getAcceptBtn());
    }
    @Then("at last user click the Create Account button")
    public void at_last_user_click_the_create_account_button() {

        clickElement(po_manager.getRegisterPage().getCreateAccountBtn());
    }
    @When("user click on Get code for email OTP")
    public void user_click_on_get_code_for_email_otp() {

        clickElement(po_manager.getRegisterPage().getGetCode());
    }

    @Then("toast message should display to the user {string}")
    public void toast_message_should_display_to_the_user(String message) {

        textShouldBePresent("//div[text() = 'OTP sent successfully']", message);
    }

    @When("user should enter the email OTP")
    public void user_should_enter_the_email_otp() {

        AdminOTP2.getMailAndMobileOTP(RegisterData.emailID, "", "Register");

        sendKeys(po_manager.getRegisterPage().getOtpField(), AdminOTP2.emailOTP);
    }
    @When("click on Submit button")
    public void click_on_submit_button() {

        clickElement(po_manager.getRegisterPage().getSubmitBtn());
    }
    @Then("validate user navigate to KYC verification page")
    public void validate_user_navigate_to_kyc_verification_page() {

        Assert.assertEquals("KYC Verification", getElementText(po_manager.getKycVerification().getKycText()));
    }

}
