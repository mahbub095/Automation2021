Feature: Checkout Flow using PayPal Payment Method
  As a tester
  I want to ensure PayPal Checkout feature working as expected
  So that our end user can Shop from LG.com without any issues

  Background:
    Given I am at LG Home Page

  @checkout @paypal @smoke @regression @TC_001
  Scenario: As a brand new guest, ensure user able to checkout OMV Subscription product with promotion code and standard shipping using PayPal
    Given I enter OMV subscription product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMV Subscription product displays in search results page
    Then  I will click on add to cart Button from Search Results Page for "OMV_Subscription"
    Then  I will select the subscription Frequency as "0months"
    When  I will click on Proceed to Cart Button
    When  I will enter zipCode to check the delivery availability
    Then  I will verify product is added into Cart Page
    When  I will enter promo code
    Then  I should able to use promo code
    When  I click on Secure Checkout button
    And   I click on Continue as Guest from Sign in page
    And   I click on Save and Continue button after fill out Shipping Info
    And   I verify the suggested address
    Then  I will select the "Standard" shipment Method
    When  I click on Continue to Payment button
    Then  I will see Payment method option list in Billing Page
    When  I choose the "Paypal" radio button from Billing Page
    And   I click on Review and Place order button from Billing Page
    And   I click on Place Order button after agreeing Terms and Conditions from Review Page
    When  I will click on Paypal Pay with Debit or Credit Card Button
    Then  I will enter card Details on Paypal Page
    Then  I will enter contact Details on Paypal Page
    And   I will click on Continue Button

  @checkout @paypal @smoke @regression @TC_002
  Scenario: As a brand new guest, ensure user able to checkout OMV Subscription product after removing promotion code once it was applied with overnight shipping
    Given I enter OMV subscription product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMV Subscription product displays in search results page
    Then  I will click on add to cart Button from Search Results Page for "OMV_Subscription"
    Then  I will select the subscription Frequency as "0months"
    When  I will click on Proceed to Cart Button
    When  I will enter zipCode to check the delivery availability
    Then  I will verify product is added into Cart Page
    When  I will enter promo code
    Then  I should able to use promo code
    When  I will remove promo code
    Then  I should able to remove promo code
    When  I click on Secure Checkout button
    And   I click on Continue as Guest from Sign in page
    And   I click on Save and Continue button after fill out Shipping Info
    And   I verify the suggested address
    Then  I will select the "Standard" shipment Method
    When  I click on Continue to Payment button
    Then  I will see Payment method option list in Billing Page
    When  I choose the "Paypal" radio button from Billing Page
    And   I click on Review and Place order button from Billing Page
    And   I click on Place Order button after agreeing Terms and Conditions from Review Page
    When  I will click on Paypal Pay with Debit or Credit Card Button
    Then  I will enter card Details on Paypal Page
    Then  I will enter contact Details on Paypal Page
    And   I will click on Continue Button

  @checkout @paypal @smoke @regression @TC_005
  Scenario: As a guest user, checkout OMD HE Innovel product and Create an account from confirmation page
    Given I enter OMD HE Innovel product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMD HE Innovel product displays in search results page
    When  I will enter zipCode for checking the delivery availability for OMD HE Innovel Product
    When  I click on Secure Checkout button
    And   I click on Continue as Guest from Sign in page
    And   I click on Save and Continue button after fill out Shipping Info
    And   I verify the suggested address
    Then  I will select the "Standard" shipment Method
    When  I click on Continue to Payment button
    Then  I will see Payment method option list in Billing Page
    When  I choose the "Paypal" radio button from Billing Page
    And   I click on Review and Place order button from Billing Page
    And   I click on Place Order button after agreeing Terms and Conditions from Review Page
    When  I will click on Paypal Pay with Debit or Credit Card Button
    Then  I will enter card Details on Paypal Page
    Then  I will enter contact Details on Paypal Page
    And   I will click on Continue Button


  @checkout @paypal @smoke @regression @TC_022
  Scenario: As a brand new guest, ensure user able to checkout OMD non innovel  product with promotion code using PayPal
    Given I enter OMD HE Non Innovel product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMD HE Non Innovel product displays in search results page
    When  I will enter zipCode for checking the delivery availability for OMD HE Non Innovel Product
    And   I click on Continue as Guest from Sign in page
    And   I click on Save and Continue button after fill out Shipping Info
    And   I verify the suggested address
    Then  I will select the "Standard" shipment Method
    When  I click on Continue to Payment button
    Then  I will see Payment method option list in Billing Page
    When  I choose the "Paypal" radio button from Billing Page
    And   I click on Review and Place order button from Billing Page
    And   I click on Place Order button after agreeing Terms and Conditions from Review Page
    When  I will click on Paypal Pay with Debit or Credit Card Button
    Then  I will enter card Details on Paypal Page
    Then  I will enter contact Details on Paypal Page
    And   I will click on Continue Button

