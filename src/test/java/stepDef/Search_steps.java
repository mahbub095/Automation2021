package stepDef;

import java.text.ParseException;

import base.GlobalTestData;
import base.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Cart_page;
import pageObject.Search_page;


public class Search_steps extends Setup {
    Search_page SEARCH = new Search_page(driver);
    Cart_page Cart = new Cart_page(driver);

    @When("I click on search icon from GNB")
    public void iClickOnSearchIconFromGNB() throws InterruptedException {
        SEARCH.clickSearchIconFromGNB();
    }

    @Given("I enter OMV subscription product Code into search edit box from GNB")
    public void iSearchForOMVSubscriptionProductFromGNB() {
        SEARCH.enterAnItemToSearchFromGNB(GlobalTestData.OMV_Subscription);
    }

    @Given("I enter OMV Non subscription product Code into search edit box from GNB")
    public void iEnterForOMVNonSubscriptionProductCodeIntoSearchEditBoxFromGNB() {
        SEARCH.enterAnItemToSearchFromGNB(GlobalTestData.OMV_Non_Subscription);
    }
    
    @Given("I enter OMD HE Innovel product Code into search edit box from GNB")
    public void iSearchForOMDHESubscriptionProductFromGNB() {
        SEARCH.enterAnItemToSearchFromGNB(GlobalTestData.OMD_HE_Innovel);
    }
    
    @Given("I enter OMD HA Innovel product Code into search edit box from GNB")
    public void iSearchForOMDHAInnovelSubscriptionProductFromGNB() {
        SEARCH.enterAnItemToSearchFromGNB(GlobalTestData.OMD_HA_Innovel);
    }
    
    @Given("I enter OMD HE Non Innovel product Code into search edit box from GNB")
    public void iSearchForOMDHENonInnovelSubscriptionProductFromGNB() {
        SEARCH.enterAnItemToSearchFromGNB(GlobalTestData.OMD_HE_Non_Innovel);
    }
    
    @Given("I enter OMD Klarna enabled product Code into search edit box from GNB")
    public void iSearchForOMDKlarnaProductFromGNB() {
        SEARCH.enterAnItemToSearchFromGNB(GlobalTestData.OMD_KLARNA);
    }

    @Then("I will verify OMV Subscription product displays in search results page")
    public void iWillVerifyOMVSubscriptionProductDisplaysInSearchResultsPage() {
        SEARCH.verifySearchedItemFromSearchResultPage(GlobalTestData.OMV_Subscription);
    }

    @Then("I will verify OMV Non Subscription product displays in search results page")
    public void iWillVerifyOMVNonSubscriptionProductDisplaysInSearchResultsPage() {
        SEARCH.verifySearchedItemFromSearchResultPage(GlobalTestData.OMV_Non_Subscription);
    }
    
    @Then("I will verify OMD HE Innovel product displays in search results page")
    public void iWillVerifyOMDHESubscriptionProductDisplaysInSearchResultsPage() {
        SEARCH.verifySearchedItemFromSearchResultPage(GlobalTestData.OMD_HE_Innovel);
    }
    
    @Then("I will verify OMD HA Innovel product displays in search results page")
    public void iWillVerifyOMDHASubscriptionProductDisplaysInSearchResultsPage() {
        SEARCH.verifySearchedItemFromSearchResultPage(GlobalTestData.OMD_HA_Innovel);
    }
    
    @Then("I will verify OMD HE Non Innovel product displays in search results page")
    public void iWillVerifyOMDHENonInnovelSubscriptionProductDisplaysInSearchResultsPage() {
        SEARCH.verifySearchedItemFromSearchResultPage(GlobalTestData.OMD_HE_Non_Innovel);
    }
    
    @Then("I will verify OMD Klarna enabled product displays in search results page")
    public void iWillVerifyOMDKlarnaProductDisplaysInSearchResultsPage() {
        SEARCH.verifySearchedItemFromSearchResultPage(GlobalTestData.OMD_KLARNA);
    }

    @Given("I enter OMD HA Non Innovel product Code into search edit box from GNB")
    public void iEnterOMDHANonInnovelProductCodeIntoSearchEditBoxFromGNB() {
        SEARCH.enterAnItemToSearchFromGNB(GlobalTestData.OMD_HA_Non_Innovel);
    }

    @Then("I will verify OMD HA Non Innovel product displays in search results page")
    public void iWillVerifyOMDHANonInnovelProductDisplaysInSearchResultsPage() {
        SEARCH.verifySearchedItemFromSearchResultPage(GlobalTestData.OMD_HA_Non_Innovel);
    }

    @Given("I search for OLED TV")
    public void iSearchForOledTv() {
        SEARCH.enterAnItemToSearchFromGNB("oled tv");
    }
   
    @Then("^I will click on add to cart Button from Search Results Page for \"([^\"]*)\"$")
	public void IwillclickonAddToCartPage(String productSubscription) throws ParseException, InterruptedException {
	 if(productSubscription.equalsIgnoreCase("OMV_Subscription")) {
     SEARCH.addCartProduct(GlobalTestData.OMV_Subscription);
	 Cart.productCode[0]=GlobalTestData.OMV_Subscription;
	 } else if(productSubscription.equalsIgnoreCase("OMD_HE_Innovel")) {
	 SEARCH.addCartProduct(GlobalTestData.OMD_HE_Innovel);
	 Cart.productCode[0]=GlobalTestData.OMD_HE_Innovel;
	 }
 }
    
    @Given("^I search for \"([^\"]*)\"$")
    public void iSearchProduct(String productName) {
        SEARCH.enterAnItemToSearchFromGNB(productName);
    }
    
    @Then("^I will verify list of \"([^\"]*)\" in my search results page$")
    public void iWillVerifyListOfOledTvInMySearchResultsPage(String productName) throws ParseException, InterruptedException {
    	SEARCH.verifyProductName(productName);
    }
    
    
}
