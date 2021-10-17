package stepDef;

import java.text.ParseException;

import base.GlobalTestData;
import base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Checkout_Payment_page;
import pageObject.GNB_page;

public class Checkout_Payment_steps extends Setup {
	Checkout_Payment_page Payment = new Checkout_Payment_page(driver);
	String PaymentMethod;

	@Then("I will see Payment method option list in Billing Page")
	public void iWillSeePaymentMethodOptionListInBillingPage() {
		Payment.verifyPaymentInfoPage();
	}

	@When("^I choose the \"([^\"]*)\" radio button from Billing Page$")
	public void iChoosePaymentRadioButton(String paymentMethod) throws InterruptedException {
		if (paymentMethod.equalsIgnoreCase("Klarna")) {
			Payment.selectPaymentMethodFromBillingPage("Buy Now. Pay Later");
			PaymentMethod = "Buy Now. Pay Later";
		} else if (paymentMethod.equalsIgnoreCase("Credit Card")) {
			Payment.selectPaymentMethodFromBillingPage("Credit or Debit Card");
			PaymentMethod = "Credit or Debit Card";
		}
		else if (paymentMethod.equalsIgnoreCase("Paypal")) {
			Payment.selectPaymentMethodFromBillingPage("Paypal");
			PaymentMethod = "Paypal";
		}
	}

	@Then("I will enter Card Details")
	public void iwillenterCreditCardDetails() throws InterruptedException {
		Payment.enterCardDetails(GlobalTestData.VISA_CARD_NO, GlobalTestData.VISA_EXP_NO, GlobalTestData.VISA_CVV);
	}
	
	@Then("I will enter Master Credit Card Details")
	public void iwillenterMasterCreditCardDetails() throws InterruptedException {
		Payment.enterCardDetails(GlobalTestData.MASTER_CARD_NO, GlobalTestData.MASTER_EXP_NO, GlobalTestData.MASTER_CVV);
	}
	
	@Then("I will enter Amex Credit Card Details")
	public void iwillenterAmexCreditCardDetails() throws InterruptedException {
		Payment.enterCardDetails(GlobalTestData.AMEX_CARD_NO, GlobalTestData.AMEX_EXP_NO, GlobalTestData.AMEX_CVV);
	}

	@And("I click on Review and Place order button from Billing Page")
	public void iClickOnReviewAndPlaceOrderButton() {
		Payment.clickReviewPlaceOrderButtonFromBillingPage(PaymentMethod);
	}
	
	@Then("I Enter Klarna SSN Details")
	public void iEnterKlaranaDetails() throws InterruptedException {
		Payment.enterKlarnaDetails();
	}

}
