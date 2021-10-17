Feature: Checkout Flow using Klarna Payment Method
  As a tester
  I want to ensure Klarna Checkout feature working as expected
  So that our end user can Shop from LG.com without any issues

  Background:
    Given I am at LG Home Page

  @checkout @guest @klarna @smoke @regression @TC_001
  Scenario: As a brand new guest user, ensure user able to checkout the HE OMD Innoval Product with Klarna monthly installment
    Given I enter OMD Klarna enabled product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMD Klarna enabled product displays in search results page
    When  I will enter zipCode for checking the delivery availability for OMD Klarna enabled Product
    When  I click on Secure Checkout button
    And   I click on Continue as Guest from Sign in page
    And   I click on Save and Continue button after fill out Shipping Info
    And   I verify the suggested address
    Then  I will select the "Standard" shipment Method
    When  I click on Continue to Payment button
    Then  I will see Payment method option list in Billing Page
    When  I choose the "Klarna" radio button from Billing Page
    And   I click on Review and Place order button from Billing Page
    And   I click on Place Order button after agreeing Terms and Conditions from Review Page
    Then  I Enter Klarna SSN Details
    # confirmation page TODO


  @checkout @guest @klarna @smoke @regression @TC_003
  Scenario: As a brand new guest user, ensure user able to checkout HE OMD Innoval Product with financing
    Given I enter OMD Klarna enabled product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMD Klarna enabled product displays in search results page
    When  I will enter zipCode for checking the delivery availability for OMD Klarna enabled Product
    When  I click on Secure Checkout button
    And   I click on Continue as Guest from Sign in page
    And   I click on Save and Continue button after fill out Shipping Info
    And   I verify the suggested address
    Then  I will select the "Standard" shipment Method
    When  I click on Continue to Payment button
    Then  I will see Payment method option list in Billing Page
    When  I choose the "Klarna" radio button from Billing Page
    And   I click on Review and Place order button from Billing Page
    And   I click on Place Order button after agreeing Terms and Conditions from Review Page
    Then  I Enter Klarna SSN Details
    # confirmation page TODO 