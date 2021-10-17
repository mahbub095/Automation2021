Feature: Cart Page

  Background:
    Given I am at LG Home Page

  @checkout @cart @smoke @regression @TC_002
  Scenario: As a guest user, ensure you able to Increase Decrease quantity for OMV non subscription product
    Given I enter OMV subscription product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMV Subscription product displays in search results page
    Then  I will click on add to cart Button from Search Results Page for "OMV_Subscription"
    Then  I will select the subscription Frequency as "0months"
    When  I will click on Proceed to Cart Button
    Then  I will verify product is added into Cart Page
    When  I will select the "5" as quantity
    Then  I should able to see the updated price as per quantity
    When  I will select the "3" as quantity
    Then  I should able to see the updated price as per quantity

  @checkout @cart @smoke @regression @TC_003
  Scenario: As a guest user, ensure you able to verify Estimated Tax for Hawaii using OMV non subscription product
    Given I enter OMV subscription product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMV Subscription product displays in search results page
    Then  I will click on add to cart Button from Search Results Page for "OMV_Subscription"
    Then  I will select the subscription Frequency as "0months"
    When  I will click on Proceed to Cart Button
    Then  I will verify product is added into Cart Page
    When  I enter zipCode to check the delivery availability for "HAWAII"
    And   I should be able to see Estimated Price and Order Total
    And   I should be able to see Estimated Tax Price
    When  I enter zipCode to check the delivery availability for "NewYork"
    And   I should be able to see Estimated Price and Order Total
    And   I should be able to see Estimated Tax Price
    Then  I should able see Hawaii estimated tax less than New York estimated tax


  @checkout @cart @smoke @regression @TC_009
  Scenario: As a guest user, ensure system allow you to add Items from Recommended based on your cart after adding HA OMD product
    Given I enter OMD HA Innovel product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMD HA Innovel product displays in search results page
    When  I will enter zipCode for checking the delivery availability for OMD HA Innovel Product
    Then  I click on Add to Cart Button under Recommendations

  @checkout @cart @smoke @regression @TC_022
  Scenario: As a guest user , ensure that Add accessories button is displayed for the product
    Given I enter OMD HA Innovel product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMD HA Innovel product displays in search results page
    And   I click on Add to Cart Button under Accessories

  @checkout @cart @smoke @regression @TC_024
  Scenario: As a guest user , ensure that Add accessories button is displayed for the product
    Given I enter OMD HA Innovel product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMD HA Innovel product displays in search results page
    And   I click on Add to Cart Button under Accessories
    Then  I click on Remove Item Button

  @checkout @cart @smoke @regression @TC_024
  Scenario: As a guest user , ensure that Add accessories button is displayed for the product
    Given I enter OMD HA Innovel product Code into search edit box from GNB
    When  I click on search icon from GNB
    Then  I will verify OMD HA Innovel product displays in search results page
    And   I click on Add to Cart Button under Accessories
    Then  I click on Remove Item Button