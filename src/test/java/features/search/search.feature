Feature: Search functionality
  As a tester
  I want to ensure functionality feature working as expected
  So that our end user can browse around in LG.com without any issues

  Background:
    Given I am at LG Home Page

  @search @smoke @regression @omd
  Scenario: Verify user should be able to search OMD HA Innovel product
    Given I enter OMD HA Innovel product Code into search edit box from GNB
    When I click on search icon from GNB
    Then I will verify OMD HA Innovel product displays in search results page

  @search @smoke @regression @omd
  Scenario: Verify user should be able to search OMD HA Non-Innovel product
    Given I enter OMD HA Non Innovel product Code into search edit box from GNB
    When I click on search icon from GNB
    Then I will verify OMD HA Non Innovel product displays in search results page

  @search @smoke @regression @omd
  Scenario: Verify user should be able to search OMD HE Innovel product
    Given I enter OMD HE Innovel product Code into search edit box from GNB
    When I click on search icon from GNB
    Then I will verify OMD HE Innovel product displays in search results page

  @search @smoke @regression @omd
  Scenario: Verify user should be able to search OMD HE Non-Innovel product
    Given I enter OMD HE Non Innovel product Code into search edit box from GNB
    When I click on search icon from GNB
    Then I will verify OMD HE Non Innovel product displays in search results page

  @search @smoke @regression @omv
  Scenario: Verify user should be able to search OMV Subscription product
    Given I enter OMV subscription product Code into search edit box from GNB
    When I click on search icon from GNB
    Then I will verify OMV Subscription product displays in search results page

  @search @smoke @regression @omv
  Scenario: Verify user should be able to search OMV Non Subscription product
    Given I enter OMV Non subscription product Code into search edit box from GNB
    When I click on search icon from GNB
    Then I will verify OMV Non Subscription product displays in search results page

  @search @smoke @regression
  Scenario Outline: Verify user should be able to search item with space
    Given I search for "<productName>"
    When I click on search icon from GNB
    Then I will verify list of "<productName>" in my search results page
    
    Examples:
      | productName |
      | OLED        |
      | SMART TV    |
      | 4K SMART    |