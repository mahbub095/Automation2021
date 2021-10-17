package stepDef;


import base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Checkout_Shipping_page;


public class Checkout_Shipping_steps extends Setup {
	Checkout_Shipping_page Shipping = new Checkout_Shipping_page(driver);


	@And("I click on Save and Continue button after fill out Shipping Info")
	public void iClickOnSaveAndContinueButtonAfterFillOutShippingInfo() throws InterruptedException {
		Shipping.verifyContactInfoPage();
		Shipping.enter_contact_shipping_info();
		Shipping.clickSaveAndContinueButtonFromShippingPage();
	}

	@And("I verify the suggested address")
	public void iVerifyTheSuggestedAddress() throws InterruptedException {
		Shipping.clickUseThisAddressButton();
	}
	
	@Then("^I will select the \"([^\"]*)\" shipment Method$")
	public void iwillselectshipmentMethod(String shippingMethod) throws InterruptedException {
		Shipping.selectShippingMethod(shippingMethod);
	}
	
	@When("I click on Continue to Payment button")
	public void iClickOnContinueToPaymentButton() throws InterruptedException {
		Shipping.verifyShippingInfoPage();
		Shipping.clickContinuePaymentButtonFromShippingPage();
	}



}
