package stepDef;

import base.GlobalTestData;
import base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Cart_page;
import pageObject.Search_page;

public class Cart_Steps extends Setup {
	Cart_page Cart = new Cart_page(driver);
	public static String initialPrice = "";
	public String qty = "";
	public String tax1 = "";
	public String tax2 = "";

	@SuppressWarnings("static-access")
	@When("I enter zipCode to check the delivery availability")
	public void iEnterZipCodeToCheckTheDeliveryAvailability() throws InterruptedException {
		Cart.verifyZipCodePage();
		Cart.verifySelectedProduct(Cart.productCode[0]);
		Cart.productArea = Cart.validateEnterZipCode();
		Cart.clickProceedButton();
	}
	
	@SuppressWarnings("static-access")
	@When("I will enter zipCode to check the delivery availability")
	public void iEnterZipCodeTheDeliveryAvailability() throws InterruptedException {
		Cart.verifySelectedProduct(Cart.productCode[0]);
		Cart.productArea = Cart.validateEnterZipCode();
	}

	@When("^I enter zipCode to check the delivery availability for \"([^\"]*)\"$")
	public void iZipCodeToCheckTheDeliveryAvailability(String stateName) throws InterruptedException {
		Cart.verifySelectedProduct(Cart.productCode[0]);
		Cart.productArea = Cart.validateEnterZipCode(stateName);
	}

	@When("I will enter zipCode for checking the delivery availability for OMD HE Innovel Product")
	public void iZipCodeToCheckTDeliveryAvailability() throws InterruptedException {
		Cart.clickAddCartButton();
		Cart.verifyZipCodePage();
		Cart.verifySelectedProduct(GlobalTestData.OMD_HE_Innovel);
		Cart.productArea = Cart.validateEnterZipCode();
		Cart.clickProceedButton();
	}

	@When("I will enter zipCode for checking the delivery availability for OMD HA Innovel Product")
	public void iZipCodeCheckTDeliveryAvailability() throws InterruptedException {
		Cart.clickAddCartButton();
		Cart.verifyZipCodePage();
		Cart.verifySelectedProduct(GlobalTestData.OMD_HA_Innovel);
		Cart.productArea = Cart.validateEnterZipCode();
		Cart.clickProceedButton();
	}

	@When("I will enter zipCode for checking the delivery availability for OMD Klarna enabled Product")
	public void iZipCodeDeliveryAvailability() throws InterruptedException {
		Cart.clickAddCartButton();
		Cart.verifyZipCodePage();
		Cart.verifySelectedProduct(GlobalTestData.OMD_KLARNA);
		Cart.productArea = Cart.validateEnterZipCode();
		Cart.clickProceedButton();
	}

	@When("I will enter zipCode for checking the delivery availability for OMD HE Non Innovel Product")
	public void iZipCodeCheckDeliveryAvailability() throws InterruptedException {
		Cart.clickAddCartButton();
		Cart.clickProceedCart();
	}

	@SuppressWarnings("static-access")
	@Then("I will verify product is added into Cart Page")
	public void iWillSeeProductWillBeAddedIntoCartPage() {
		Cart.verifyCartPage();
		Cart.verifyProductDetails(Cart.productCode[0], Cart_Steps.initialPrice);
		Cart.verifyHelpSection();
	}

	@When("I click on Secure Checkout button")
	public void iClickOnSecureCheckoutButton() {
		Cart.clickSecureCheckOut();
	}

	@And("I click on Continue as Guest from Sign in page")
	public void iClickOnContinueAsGuestFromSignInPage() {
		Cart.verifySignInPage();
		Cart.clickContinueAsGuest();
	}

	@When("I will enter promo code")
	public void I_will_enter_promocode() throws InterruptedException {
		Cart.enterPromoCode(GlobalTestData.PROMO_CODE);
		Cart.clickApplyButton();
	}

	@Then("I should able to use promo code")
	public void I_should_able_to_use_promo_code() throws InterruptedException {
		Cart.verifyPromoCode();
	}

	@When("I will remove promo code")
	public void I_will_remove_promocode() throws InterruptedException {
		Cart.clickRemovePromoCode();
	}

	@Then("I should able to remove promo code")
	public void I_should_able_to_remove_promo_code() throws InterruptedException {
		Cart.verifyRemovePromoCode();
	}

	@When("^I will select the \"([^\"]*)\" as quantity$")
	public void I_will_select_quantity(String quantity) throws InterruptedException {
		/*
		 * if (initialPrice.equalsIgnoreCase("")) { initialPrice = Cart.getPrice(); }
		 */
		Cart.selectQuantity(quantity);
		qty = quantity;
	}

	@When("I should able to see the updated price as per quantity")
	public void iVerifyPrice() throws InterruptedException {
		Cart.verifyPrice(initialPrice, qty);
	}

	@And("I should be able to see Estimated Price and Order Total")
	public void VerifyPrice() throws InterruptedException {
		Cart.verifyEstimatedTax();
		Cart.verifyTotalTax();
	}

	@And("I should be able to see Estimated Tax Price")
	public void VerifyEstimatedTax() throws InterruptedException {
		Cart.verifyEstimatedTax();
		if (tax1.equalsIgnoreCase("")) {
			tax1 = Cart.getEstimatedTax();
		} else {
			tax2 = Cart.getEstimatedTax();
		}

	}
	
	@Then("I should able see Hawaii estimated tax less than New York estimated tax")
	public void CompareEstimatedTax() throws InterruptedException {
	Cart.compareEstimatedTax(tax1, tax2);	
	}

	@Then("I click on Add to Cart Button under Recommendations")
	public void clickAddCart() throws InterruptedException {
		Cart.clickAddCartRecommendation();
	}

	@And("I click on Add to Cart Button under Accessories")
	public void clickAddToCart() throws InterruptedException {
		Cart.clickAddCartAccessories();
	}

	@Then("I click on Remove Item Button")
	public void clickRemoveItem() throws InterruptedException {
		Cart.clickRemoveItem();
	}

}
