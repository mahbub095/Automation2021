package stepDef;


import base.Setup;
import io.cucumber.java.en.And;
import pageObject.Checkout_Review_page;

public class Checkout_Review_steps extends Setup {
	Checkout_Review_page  Review = new Checkout_Review_page(driver);
	
	
	@And("I click on Place Order button after agreeing Terms and Conditions from Review Page")
	public void iClickOnTermsAndConditionsCheckbox() throws InterruptedException {
		Review.clickTermsConditionsFromReviewPage();
		Review.clickPlaceOrderButtonFromReviewPage();
	}
}
