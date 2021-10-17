Feature: Signup to LG.com
  As a tester
  I want to ensure Signup feature working as expected
  So that our end user can Signup into LG.com without any issues

  Background:
    Given I am at LG Home Page

  @signup @smoke @regression
  Scenario: Verify user should be able verify their account from their email after successfully sign up
    Given I have brand new email address which never used in past
    And I navigates to LG Sign Up page
    And I click on Sign up now button
    And I fill out the sign up form newly created email info
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I should be able to activate the account from Mailbox

  @signup @smoke @regression
  Scenario: Verify user should be able to Signup from GNB
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form with valid Info
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I will see a confirmation message upon new account creation

  @signup @regression
  Scenario: Verify user should not be able to Signup when they are under 16 years old
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form with under aged
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I will verify error message under DOB

  @signup @regression @smoke
  Scenario: Verify user should not be able to Signup without agreeing the Terms and Conditions
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form with valid Info
    And I agree with Privacy Policy
    When I click on Sign Up button
    Then I will verify error message under Terms and Conditions

  @signup @regression @smoke
  Scenario: Verify user should not be able to Signup without agreeing the Privacy Policy
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form with valid Info
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I will verify error message under Privacy Policy

  @signup @regression @smoke
  Scenario: Verify user should not be able to Signup when password doesn't match with confirm password
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form having different password value under Confirm Password
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I will verify error message under Confirm Password

  @signup @regression @smoke
  Scenario: Verify user able to cancel signing up from Sign Up page
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form with valid Info
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Cancel button
    Then I will verify user revert back to Sign In screen

  @signup @regression
  Scenario: Verify user should not be able to Signup without entering email address
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form without email address
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I will verify email required error message

  @signup @regression
  Scenario: Verify user should not be able to Signup with invalid email address
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form with invalid email address
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I will verify email address invalid error message


  @signup @regression
  Scenario: Verify user should not be able to Signup without entering first name
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form without first name
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I will verify error message under first name

  @signup @regression
  Scenario: Verify user should not be able to Signup without entering last name
    Given I came to Signup page from GNB
    And I click on Sign up now button
    And I fill out the sign up form without last name
    And I agree with Privacy Policy
    And I agree with Terms and Conditions
    When I click on Sign Up button
    Then I will verify error message under last name
