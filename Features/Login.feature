Feature: Validating the Login Functionality

  Background: Validating the given URL
    Then Verifying the given URL and actual web URL are same

  @loginWithValidCredentials
  Scenario: Validating the Login wih Valid credentials
    Given User must enter the Email ID in the email Field
    And enter the password in the password field
    And user should click the submit button
    Then validate the user name from the Trader dashboard
