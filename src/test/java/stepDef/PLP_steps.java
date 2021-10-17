package stepDef;

import java.text.ParseException;
import base.GlobalTestData;
import base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Cart_page;
import pageObject.GNB_page;
import pageObject.PLP_page;

public class PLP_steps extends Setup {
	GNB_page GNB = new GNB_page(driver);
	PLP_page PLP = new PLP_page(driver);
	Cart_page Cart = new Cart_page(driver);

	@Given("I am able to add an HE OMD Innoval product from PLP")
	public void iAmAbleToClickATCButtonForHEOMDInnovalProduct() throws ParseException, InterruptedException {
		GNB.mouseOverTVLink();
		GNB.clickOLEDSection();
		PLP.verifyOLEDPage();
		PLP.verifyOLEDTV();
		Cart.productCode = PLP.addCartHighPrice().split("#");
	}

	@Then("^I will select the subscription Frequency as \"([^\"]*)\"$")
	public void I_will_select_the_subscription_Frequency(String frequency) throws ParseException, InterruptedException {
		PLP.selectSubscription(frequency);
	}

	@When("I will click on Proceed to Cart Button")
	public void I_will_click_on_Proceed_to_Cart_Button() throws ParseException, InterruptedException {
		PLP.clickProceedButton();
	}

}
