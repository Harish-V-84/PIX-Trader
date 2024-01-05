Feature: Validating KYC Verification Functionality

  @KYC_WithValidCredentials
  Scenario: KYC Verification with Valid Credentials
    Given user entering the phone number
    And click the get code text for mobile OTP
    Then toast message for mobile OTP should display to the user "OTP sent successfully"
    And click the get code text for email OTP
    Then toast message for email OTP should display to the user "OTP sent successfully"
    And user enter the email OTP in input field
    And enter the mobile OTP in input field
    And user must click the verify mobile button
    Then validate the user navigated to "Personal Information" fields
    And user must select gender from the gender drop down
    And enter the date of birth
    And user must select the current occupation from the occupation drop down
    And user must select the current annual income from the drop down
    And enter the purpose of account in input field
    And user should enter the permanent address state
    And enter the permanent address city
    And enter the permanent address street
    And enter the permanent address door number
    And click current address same check box
    When click on Submit button present in the personal information field
    Then validate user navigated to "Suitability Assessment" fields
    And user must enter the assessment one in the input field
    And user must enter the assessment two in the input field
    And user must enter the education level in the input field
    And click on Submit button present in the Suitability Assessment field
    Then validate user navigated to Bank Details fields
    And user should enter the bank name
    And enter the branch name in the input field
    And enter the account number in the input field
    And enter SWIFT details in the input field
    And enter IBAN details in the input field
    And enter the bank address details
    And user select the bank account type in drop down
    And click on Submit button present in the Bank Details field
    Then validate user navigated to "Documents" field
    And user click the passport radio button
    And enter the document ID in the input field
    And click the upload file and form your pc select the passport image
    And click on Submit button present in the Documents field
    Then Validate user navigated to "Selfie" field
    And click the upload file and select selfie image from your pc
    And click the privacy policy checkbox
    And click on Submit button present in the Selfie field

