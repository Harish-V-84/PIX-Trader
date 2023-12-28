package com.steps.kyc;

import com.runner.AdminOTP;
import com.trader.applicationData.KYC_VerificationData;
import com.trader.applicationData.RegisterData;
import com.trader.utils.TraderUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class KYCWIthValidCredentials extends TraderUtils {

    private static final KYC_VerificationData valid = new KYC_VerificationData("validCredentials");

    @Given("user entering the phone number")
    public void user_entering_the_phone_number() {

        sendKeys(po_manager.getKycVerification().getEnterMobileNum(), valid.mobileNum);
    }
    @Given("click the get code text for mobile OTP")
    public void click_the_get_code_text_for_mobile_otp() {

        clickElement(po_manager.getKycVerification().getClickMobileCode());
    }
    @Given("click the get code text for email OTP")
    public void click_the_get_code_text_for_email_otp() {

        clickElement(po_manager.getKycVerification().getClickEmailCode());
    }
    @Given("user enter the email OTP in input field")
    public void user_enter_the_email_otp_in_input_field() {

        sleep(5000);

        AdminOTP.getOTP(RegisterData.emailID, valid.mobileNum);

        sendKeys(po_manager.getKycVerification().getEmailOTPInputField(), AdminOTP.emailOTP);

    }
    @Given("enter the mobile OTP in input field")
    public void enter_the_mobile_otp_in_input_field() {

        sendKeys(po_manager.getKycVerification().getMobileOTPInputField(), AdminOTP.mobileOTP);
    }
    @Given("user must click the verify mobile button")
    public void user_must_click_the_verify_mobile_button() {

        clickElement(po_manager.getKycVerification().getVerifyMobileBtn());
    }
    @Then("validate the user navigated to personal information fields")
    public void validate_the_user_navigated_to_personal_information_fields() {

        Assert.assertEquals("Personal Information",getElementText(po_manager.getKycVerification().getPersonalInformationText()));
    }
    @Then("user must select gender from the gender drop down")
    public void user_must_select_gender_from_the_gender_drop_down() {

        selectByValue(po_manager.getKycVerification().getSelectGender(), valid.gender);
    }
    @Then("enter the date of birth")
    public void enter_the_date_of_birth() {

        sendKeys(po_manager.getKycVerification().getDateOfBrithInputField(), valid.dob);
    }
    @Then("user must select the current occupation from the occupation drop down")
    public void user_must_select_the_current_occupation_from_the_occupation_drop_down() {

        selectByValue(po_manager.getKycVerification().getSelectOccupation(), valid.occupation);
    }
    @Then("user must select the current annual income from the drop down")
    public void user_must_select_the_current_annual_income_from_the_drop_down() {

        selectByValue(po_manager.getKycVerification().getSelectAnnualIncome(), valid.annualIncome);
    }
    @Then("enter the purpose of account in input field")
    public void enter_the_purpose_of_account_in_input_field() {

        sendKeys(po_manager.getKycVerification().getPurposeOfAccountFiled(), valid.purposeOfAccount);
    }
    @Then("user should enter the permanent address state")
    public void user_should_enter_the_permanent_address_state() {

        sendKeys(po_manager.getKycVerification().getPermanentAddressState(), valid.permanentAddressState);
    }
    @Then("enter the permanent address city")
    public void enter_the_permanent_address_city() {

        sendKeys(po_manager.getKycVerification().getPermanentAddressCity(), valid.permanentAddressCity);

    }
    @Then("enter the permanent address street")
    public void enter_the_permanent_address_street() {

        sendKeys(po_manager.getKycVerification().getPermanentAddressStreet(), valid.permanentAddressStreet);

    }
    @Then("enter the permanent address door number")
    public void enter_the_permanent_address_door_number() {

        sendKeys(po_manager.getKycVerification().getPermanentAddressDoorNum(), valid.permanentAddressDoorNo);
    }
    @Then("click current address same check box")
    public void click_current_address_same_check_box() {

        clickElement(po_manager.getKycVerification().getCurrentAddressCheckbox());
    }
    @When("click on Submit button present in the personal information field")
    public void click_on_submit_button_present_in_the_personal_information_field() {

        clickElement(po_manager.getKycVerification().getSubmitBtn());
    }
    @Then("validate user navigated to suitability Assessment fields")
    public void validate_user_navigated_to_suitability_assessment_fields() {

        Assert.assertEquals("Suitability Assessment", getElementText(po_manager.getKycVerification().getSuitabilityAssessmentText()));
    }
    @Then("user must enter the assessment one in the input field")
    public void user_must_enter_the_assessment_one_in_the_input_field() {

        sendKeys(po_manager.getKycVerification().getAssessment1(), valid.assessment1);
    }
    @Then("user must enter the assessment two in the input field")
    public void user_must_enter_the_assessment_two_in_the_input_field() {

        sendKeys(po_manager.getKycVerification().getAssessment2(), valid.assessment2);
    }
    @Then("user must enter the education level in the input field")
    public void user_must_enter_the_education_level_in_the_input_field() {

        sendKeys(po_manager.getKycVerification().getEducationLevel(), valid.educationLevel);
    }
    @Then("click on Submit button present in the Suitability Assessment field")
    public void click_on_submit_button_present_in_the_suitability_assessment_field() {

        clickElement(po_manager.getKycVerification().getSubmitBtn());
    }
    @Then("validate user navigated to Bank Details fields")
    public void validate_user_navigated_to_bank_details_fields() {

        Assert.assertEquals("Bank Details", getElementText(po_manager.getKycVerification().getBankDetailsText()));
    }
    @Then("user should enter the bank name")
    public void user_should_enter_the_bank_name() {

        sendKeys(po_manager.getKycVerification().getBankName(), valid.bankName);
    }
    @Then("enter the branch name in the input field")
    public void enter_the_branch_name_in_the_input_field() {

        sendKeys(po_manager.getKycVerification().getBranchName(), valid.branchName);
    }
    @Then("enter the account number in the input field")
    public void enter_the_account_number_in_the_input_field() {

        sendKeys(po_manager.getKycVerification().getAccountNumber(), valid.accountNumber);
    }
    @Then("enter SWIFT details in the input field")
    public void enter_swift_details_in_the_input_field() {

        sendKeys(po_manager.getKycVerification().getSwift(), valid.swift);
    }
    @Then("enter IBAN details in the input field")
    public void enter_iban_details_in_the_input_field() {

        sendKeys(po_manager.getKycVerification().getIban(), valid.iban);
    }
    @Then("enter the bank address details")
    public void enter_the_bank_address_details() {

        sendKeys(po_manager.getKycVerification().getBankAddress(), valid.bankAddress);
    }
    @Then("user select the bank account type in drop down")
    public void user_select_the_bank_account_type_in_drop_down() {

        selectByValue(po_manager.getKycVerification().getSelectAccountType(), valid.accountType);
    }
    @Then("click on Submit button present in the Bank Details field")
    public void click_on_submit_button_present_in_the_bank_details_field() {

        clickElement(po_manager.getKycVerification().getSubmitBtn());
    }
    @Then("validate user navigated to Documents fields")
    public void validate_user_navigated_to_documents_fields() {

        Assert.assertEquals("Documents", getElementText(po_manager.getKycVerification().getDocumentText()));
    }
    @Then("user click the passport radio button")
    public void user_click_the_passport_radio_button() {

        clickElement(po_manager.getKycVerification().getPassportRadioBtn());
    }
    @Then("enter the document ID in the input field")
    public void enter_the_document_id_in_the_input_field() {

        sendKeys(po_manager.getKycVerification().getDocumentID(), "NA");
    }
    @Then("click the upload file and form your pc select the passport image")
    public void click_the_upload_file_and_form_your_pc_select_the_passport_image() {

        clickElement(po_manager.getKycVerification().getUploadDocumentFile());

        uploadImage(filePaths().get("image"));

        sleep(700);
    }
    @Then("click on Submit button present in the Documents field")
    public void click_on_submit_button_present_in_the_documents_field() {

        scrollToElement(po_manager.getKycVerification().getSubmitBtn());

        clickElement(po_manager.getKycVerification().getSubmitBtn());
    }
    @Then("validate user navigated to Selfie fields")
    public void validate_user_navigated_to_selfie_fields() {

        Assert.assertEquals("Selfie", getElementText(po_manager.getKycVerification().getSelfieText()));
    }
    @Then("click the upload file and select selfie image from your pc")
    public void click_the_upload_file_and_select_selfie_image_from_your_pc() {

        clickElement(po_manager.getKycVerification().getUploadSelfie());

        uploadImage(filePaths().get("image"));

        sleep(700);
    }
    @Then("click the privacy policy checkbox")
    public void click_the_privacy_policy_checkbox() {

        scrollToElement(po_manager.getKycVerification().getPrivacyPolicyCheckbox());

        clickElement(po_manager.getKycVerification().getPrivacyPolicyCheckbox());
    }
    @Then("click on Submit button present in the Selfie field")
    public void click_on_submit_button_present_in_the_selfie_field() {

        clickElement(po_manager.getKycVerification().getSubmitBtn());
    }

}
