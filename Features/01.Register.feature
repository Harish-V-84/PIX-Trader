Feature: Validating Register Functionality

  @registerValidCredentials
  Scenario: Registering with valid credentials
    Given the user should click on Register Now hyperlink
    Then validate Register page url
    And user fills the form by entering the first name
    And last name
    And email ID
    And password
    And user click on check box for terms and conditions
    And at last user click the Create Account button
    When user click on Get code for email OTP
    And user should enter the email OTP
    And click on Submit button
    Then validate user navigate to KYC verification page
