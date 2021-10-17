package pageObject;

import base.GlobalTestData;
import base.Setup;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class Checkout_page extends Setup {

	public Checkout_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	Faker faker = new Faker();
	public static String productArea;
	public static String[] productCode = new String[5];

	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
			.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
	// Elements
	@FindBy(how = How.XPATH, using = "//p[text()='LG’s Best TVs']")
	public WebElement CHECKOUT_TV_LINK;
	@FindBy(how = How.XPATH, using = "//img[@alt='LG OLED TV']")
	public WebElement CHECKOUT_LG_OLED_TV;
	@FindBy(how = How.XPATH, using = "//img[@alt='LG OLED TV']")
	public WebElement CHECKOUT_OLED_TV_CHECKBOX;
	@FindBy(how = How.XPATH, using = "//span[text()='Quantity']/following::span[@class='price']")
	public WebElement CHECKOUT_CART_PRICE;

	@FindBy(how = How.XPATH, using = "//h1[@class='modal-title']")
	public WebElement CHECKOUT_ADDRESS_POPUP;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Buy Now')]/ancestor::label")
	public WebElement CHECKOUT_KLARNA_PAYMENT_RADIO_BUTTON;



	
	
	
	
	

}
