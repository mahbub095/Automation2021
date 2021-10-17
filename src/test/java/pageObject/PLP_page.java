package pageObject;

import base.Setup;
import stepDef.Cart_Steps;
import stepDef.PLP_steps;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PLP_page extends Setup {

	public PLP_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
			.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);

	// Elements
	@FindBy(how = How.XPATH, using = "//div[@class='title']/h1")
	public WebElement ATC_OLED_PAGE_TITLE;
	@FindBy(how = How.XPATH, using = "//a[contains(@id,'products-info')]")
	public List<WebElement> ATC_PRODUCT_NAME;
	@FindBy(how = How.XPATH, using = "//div[@class='price ga-price']")
	public List<WebElement> ATC_PRICE;
	@FindBy(how = How.XPATH, using = "//a[text()='Add to Cart'][contains(@class,'active')]")
	public List<WebElement> ATC_ADD_TO_CART_BUTTON;
	@FindBy(how = How.XPATH, using = "//div[@class='modal-subs-body']/h2")
	public WebElement ATC_SUBSCRIPTION_TITLE;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'PROCEED TO CART')]")
	public WebElement ATC_PROCEED;

	public void verifyOLEDPage() {
		wait.until(ExpectedConditions.elementToBeClickable(ATC_OLED_PAGE_TITLE));
		Boolean isDisplayed = ATC_OLED_PAGE_TITLE.isDisplayed();
		if (isDisplayed) {
			String actualTitle = ATC_OLED_PAGE_TITLE.getText().trim();
			String expectedTitle = "OLED TVs";
			Assert.assertEquals(actualTitle, expectedTitle);
		} else {
			Assert.fail("Page Title is not displayed");
		}
	}

	public void verifyOLEDTV() {
		wait.until(ExpectedConditions.elementToBeClickable(ATC_PRODUCT_NAME.get(0)));
		int size = ATC_PRODUCT_NAME.size();
		for (int i = 0; i < size; i++) {
			String productName = ATC_PRODUCT_NAME.get(i).getText().trim();
			if (!productName.contains("OLED")) {
				Assert.fail("Displayed product :" + productName + " is not OLED TV");
			}
		}
	}

	public String addCartHighPrice() throws ParseException, InterruptedException {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		wait.until(ExpectedConditions.elementToBeClickable(ATC_ADD_TO_CART_BUTTON.get(0)));
		wait.until(ExpectedConditions.elementToBeClickable(ATC_PRICE.get(0)));
		int size = ATC_ADD_TO_CART_BUTTON.size();

		// Iterating through Available Items and fetching the Price
		ArrayList<String> prices = new ArrayList<String>();
		for (int j = 0; j < size; j++) {
			String productID = ATC_ADD_TO_CART_BUTTON.get(j).getAttribute("aria-describedby");
			String price = driver
					.findElement(By.xpath("//a[@id='" + productID + "']/following::div[@class='price ga-price']"))
					.getText().trim();
			prices.add(price);
			System.out.println(price);
		}

		int size1 = prices.size();
		double highestPrice = 0;

		// Code Block for finding the Highest Price
		for (int i = 0; i < size1; i++) {
			String price1 = prices.get(i);
			Number prc1 = format.parse(price1);
			Number prc2 = 0;
			if (i != size1 - 1) {
				String price2 = prices.get(i + 1);
				prc2 = format.parse(price2);
			}
			double price = Math.max(Double.parseDouble(prc1.toString()), Double.parseDouble(prc2.toString()));
			highestPrice = Math.max(price, highestPrice);
		}
		String highPrice = format.format(highestPrice);
		System.out.println(highPrice);

		// Clicking on Add to Cart Button for Product with Highest Price
		WebElement addCart = driver.findElement(By.xpath("//div[text()='" + highPrice + "']/following::a[1]"));
		WebElement product = driver.findElement(By.xpath(
				"//div[text()='" + highPrice + "']/parent::div/parent::div/preceding-sibling::div[@class='sku']"));
		System.out.println("//div[text()='" + highPrice + "']/following::a[1]");
		System.out.println(
				"//div[text()='" + highPrice + "']/parent::div/parent::div/preceding-sibling::div[@class='sku']");

		String productCode = product.getText().trim();
		wait.until(ExpectedConditions.elementToBeClickable(addCart));
		Thread.sleep(1000);
		addCart.click();
		Thread.sleep(1000);

		// returns the selected Product Code and Price
		return productCode + "#" + highPrice;
	}

	// Verify Subscription Options Popup Title
	public void verifySubscription() {
		wait.until(ExpectedConditions.visibilityOf(ATC_SUBSCRIPTION_TITLE));
		String subscriptionTitle = ATC_SUBSCRIPTION_TITLE.getText().trim();
		if (!subscriptionTitle.contains("Subscription Options")) {
			Assert.fail("Subscription Options Popup is not Displayed");
		}
	}

	// Selects the subscription for the product
	public void selectSubscription(String subscriptionFrequency) throws ParseException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(ATC_SUBSCRIPTION_TITLE));
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//input[contains(@id,'" + subscriptionFrequency + "')]"))));
		driver.findElement(By.xpath("//input[contains(@id,'" + subscriptionFrequency + "')]")).click();
		String price=driver.findElement(By.xpath("//input[@id='"+subscriptionFrequency+"']/following::strong[1]")).getText();
		String[]a=price.split(" ");
		System.out.println(a[0]);
		if (Cart_Steps.initialPrice.equalsIgnoreCase("")) {
			Cart_Steps.initialPrice = a[0];
		}
		
	}

	// Clicks on Proceed Button in PLP Page
	public void clickProceedButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(ATC_PROCEED));
		wait.until(ExpectedConditions.elementToBeClickable(ATC_PROCEED));
		ATC_PROCEED.click();
		Thread.sleep(1000);
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(expectation);
	}

}
