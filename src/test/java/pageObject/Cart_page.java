package pageObject;

import base.GlobalTestData;
import base.Setup;
import stepDef.Cart_Steps;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class Cart_page extends Setup {

    public Cart_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();
    public static String productArea;
    public static String[] productCode = new String[5];

    Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
            .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
    // Elements
    @FindBy(how = How.XPATH, using = "//h1[@class='page-title']/span")
    public WebElement CART_ZIPCODE_PAGE;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'sku')]")
    public WebElement CART_PRODUCT_CODE;
    @FindBy(how = How.XPATH, using = "//span[text()='Check']//preceding::input[1]")
    public WebElement CART_ZIPCODE;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Promotion Code']")
    public WebElement CART_PROMOCODE;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'You used promotion code')]")
    public WebElement CART_PROMOCODE_MSG;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'You canceled the promotion code')]")
    public WebElement CART_REMOVE_PROMOCODE_MSG;
    @FindBy(how = How.XPATH, using = "//span[text()='Apply']")
    public WebElement APPLY_BUTTON;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'cancel')]")
    public WebElement CANCEL_BUTTON;
    @FindBy(how = How.XPATH, using = "//span[text()='Check']")
    public WebElement CART_CHECK_BUTTON;
    @FindBy(how = How.XPATH, using = "//div[contains(@data-bind,'message')]/div")
    public WebElement CART_POSTALCODE_MESSAGE;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement CART_PROCEED_BUTTON;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'sku')]")
    public WebElement CART_PRODUCTCODE;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'cart-price')]/span")
    public WebElement CART_PRODUCTPRICE;
    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'Need Help')]")
    public WebElement CART_NEED_HELP_SECTION;
    @FindBy(how = How.XPATH, using = "//button[@title='Secure Checkout']")
    public WebElement CART_SECURE_BUTTON;
    @FindBy(how = How.XPATH, using = "//h1[@class='title']")
    public WebElement CART_SIGNIN_TITLE;
    @FindBy(how = How.XPATH, using = "//a[text()='Continue as guest']")
    public WebElement CART_CONTINUE_AS_GUEST;
    @FindBy(how = How.XPATH, using = "//a[text()='Add to Cart']")
    public WebElement CART_ADD_TO_CART;
    @FindBy(how = How.XPATH, using = "//a[text()='PROCEED TO CHECKOUT']")
    public WebElement CART_PROCEED_TO_CHECKOUT;
    @FindBy(how = How.XPATH, using = "//select[@title='Qty']")
    public WebElement CART_QUANTITY;
    @FindBy(how = How.XPATH, using = "//span[@class='cart-price']/span")
    public WebElement CART_PRICE;
    @FindBy(how = How.XPATH, using = "//th[text()='Estimated Tax']/following::span[1]")
    public WebElement CART_ESTIMATED_PRICE;
    @FindBy(how = How.XPATH, using = "//strong[text()='Order Total']/following::span[1]")
    public WebElement CART_TOTAL_PRICE;
    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Recommended based on your cart')]/following::span[text()='Add to Cart']")
    public WebElement CART_RECOMMENDATION_ADD_CART;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Accessories')]/following::a[text()='Add to Cart']")
    public WebElement CART_ACCESSORIES_ADD_CART;
    @FindBy(how = How.XPATH, using = "//span[text()='Remove Item']/parent::a[1]")
    public WebElement CART_REMOVE_ITEM_BUTTON;
    @FindBy(how = How.XPATH, using = "//div[text()='Your ZIP code qualifies for delivery']")
    public WebElement CART_ZIP_CODE_MSG;
    
    public void verifyZipCodePage() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ZIPCODE_PAGE));
        Boolean isDisplayed = CART_ZIPCODE_PAGE.isDisplayed();
        if (isDisplayed) {
            String actualTitle = CART_ZIPCODE_PAGE.getText().trim();
            String expectedTitle = "ZIP Code Entry";
            Assert.assertEquals(actualTitle, expectedTitle);
        } else {
            Assert.fail("Page Title is not displayed");
        }
    }

    public void verifySelectedProduct(String expectedCode) {
        wait.until(ExpectedConditions.elementToBeClickable(CART_PRODUCT_CODE));
        Boolean isDisplayed = CART_PRODUCT_CODE.isDisplayed();
        if (isDisplayed) {
            String actualCode = CART_PRODUCT_CODE.getText().trim();
            Assert.assertEquals(actualCode, expectedCode);
        } else {
            Assert.fail("Selected Product Code is not displayed");
        }
    }

    public String validateEnterZipCode() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ZIPCODE));
        enterZipCode(GlobalTestData.GLOBAL_NY_ZIPCODE);
        String productArea = "";
        CART_CHECK_BUTTON.click();
        Boolean isAvailable = checkProductAvailable();
        if (!isAvailable) {
            enterZipCode(GlobalTestData.GLOBAL_TX_ZIPCODE);
            CART_CHECK_BUTTON.click();
            isAvailable = checkProductAvailable();
            if (!isAvailable) {
                enterZipCode(GlobalTestData.GLOBAL_CA_ZIPCODE);
                CART_CHECK_BUTTON.click();
                productArea = "GLOBAL_CA";
            } else {
                productArea = "GLOBAL_TX";
            }
        } else {
            productArea = "GLOBAL_NY";
        }
        return productArea;
    }
    
    @SuppressWarnings("unused")
	public String validateEnterZipCode(String stateName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ZIPCODE));
        if(stateName.equalsIgnoreCase("NewYork"))
        {
        enterZipCode(GlobalTestData.GLOBAL_NY_ZIPCODE);
        String productArea = "";
        CART_CHECK_BUTTON.click();
        checkProductAvailable();
        productArea = "GLOBAL_NY";
        }
        else if(stateName.equalsIgnoreCase("HAWAII"))
        {
        enterZipCode(GlobalTestData.GLOBAL_HI_ZIPCODE);
        String productArea = "";
        CART_CHECK_BUTTON.click();
        checkProductAvailable();
        productArea = "GLOBAL_HU";
        }   
        wait.until(ExpectedConditions.elementToBeClickable(CART_ZIP_CODE_MSG));
        Thread.sleep(3000);
        return productArea;
    }


    public void enterZipCode(String zipCode) {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ZIPCODE));
        CART_ZIPCODE.clear();
        CART_ZIPCODE.sendKeys(zipCode);
    }

    public void enterPromoCode(String promoCode) {
        wait.until(ExpectedConditions.elementToBeClickable(CART_PROMOCODE));
        CART_PROMOCODE.clear();
        CART_PROMOCODE.sendKeys(promoCode);
    }

    public void clickApplyButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(APPLY_BUTTON));
        APPLY_BUTTON.click();
        Thread.sleep(1000);
    }

    public void clickProceedCart() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CART_PROCEED_TO_CHECKOUT));
        jsClick(CART_PROCEED_TO_CHECKOUT);
        // CART_PROCEED_TO_CHECKOUT.click();
        Thread.sleep(1000);
    }

    public void clickRemovePromoCode() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CANCEL_BUTTON));
        Thread.sleep(1000);
        // CANCEL_BUTTON.click();
        jsClick(CANCEL_BUTTON);
        Thread.sleep(1000);
    }

    public void verifyPromoCode() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_PROMOCODE_MSG));
        Boolean isDisplayed = CART_PROMOCODE_MSG.isDisplayed();
        if (!isDisplayed) {
            Assert.fail("Promo code is not Applied");
        }
    }

    public void verifyRemovePromoCode() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_REMOVE_PROMOCODE_MSG));
        Boolean isDisplayed = CART_REMOVE_PROMOCODE_MSG.isDisplayed();
        if (!isDisplayed) {
            Assert.fail("Promo code is not removed");
        }
    }

    public Boolean checkProductAvailable() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(CART_POSTALCODE_MESSAGE));
        Thread.sleep(2000);
        String postalCheck = CART_POSTALCODE_MESSAGE.getText().trim();
        Boolean value = true;
        if (postalCheck.contains("This product is not available to ship to your ZIP code")) {
            value = false;
        }
        return value;
    }

    public void clickProceedButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CART_PROCEED_BUTTON));
        CART_PROCEED_BUTTON.click();
        Thread.sleep(1000);
    }

    public void verifyCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ZIPCODE_PAGE));
        Boolean isDisplayed = CART_ZIPCODE_PAGE.isDisplayed();
        if (isDisplayed) {
            String actualTitle = CART_ZIPCODE_PAGE.getText().trim();
            String expectedTitle = "Your Cart";
            Assert.assertEquals(actualTitle, expectedTitle);
        } else {
            Assert.fail("Page Title is not displayed");
        }
    }

    public void verifyProductDetails(String productCode, String productPrice) {
        String actualProductCode = CART_PRODUCTCODE.getText().trim();
        String actualProductPrice = CART_PRODUCTPRICE.getText().trim();
        Assert.assertEquals(actualProductCode, productCode);
        Assert.assertEquals(actualProductPrice, productPrice);
    }

    public void verifyHelpSection() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_NEED_HELP_SECTION));
        Boolean isDisplayed = CART_NEED_HELP_SECTION.isDisplayed();
        if (isDisplayed) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Help Section is not Available");
        }
    }

    public void clickSecureCheckOut() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_SECURE_BUTTON));
        CART_SECURE_BUTTON.click();
    }

    public void clickAddCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ADD_TO_CART));
        CART_ADD_TO_CART.click();
    }

    public void verifySignInPage() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_SIGNIN_TITLE));
        Boolean isDisplayed = CART_SIGNIN_TITLE.isDisplayed();
        if (isDisplayed) {
            String actualTitle = CART_SIGNIN_TITLE.getText().trim();
            String expectedTitle = "Sign in";
            Assert.assertEquals(actualTitle, expectedTitle);
        } else {
            Assert.fail("Page Title is not displayed");
        }
    }

    public void clickContinueAsGuest() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_CONTINUE_AS_GUEST));
        CART_CONTINUE_AS_GUEST.click();
    }

    public void selectQuantity(String quantity) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CART_QUANTITY));
        Thread.sleep(4000);
        Select options = new Select(CART_QUANTITY);
        options.selectByVisibleText(quantity);
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

    public void verifyPrice(String price, String quantity) {
        char[] a = price.toCharArray();
        StringBuffer str = new StringBuffer();
        for (Character ch : a) {
            if (Character.isDigit(ch) || ch == '.') {
                str.append(ch);
            }
        }
        String priceValue = str.toString();
        double expectedPrice = (Double.parseDouble(priceValue)) * (Double.parseDouble(quantity));
        expectedPrice = Math.round(expectedPrice * 100D) / 100D;
        char[] splitPrice = getPrice().toCharArray();
        StringBuffer str1 = new StringBuffer();
        for (Character ch1 : splitPrice) {
            if (Character.isDigit(ch1) || ch1 == '.') {
                str1.append(ch1);
            }
        }
        String spltPrice = str1.toString();
        double actualPrice = Double.parseDouble(spltPrice);
        if (actualPrice != expectedPrice) {
            Assert.fail("Price Value is not updated as per selected quantity");
        }

    }

    public String getPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_PRICE));
        String price = CART_PRICE.getText().trim();
        return price;
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void verifyEstimatedTax() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ESTIMATED_PRICE));
        Boolean isDisplayed = CART_ESTIMATED_PRICE.isDisplayed();
        if (!isDisplayed) {
            Assert.fail("Estimated Price is not displayed");
        }
    }
    
    public String getEstimatedTax() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ESTIMATED_PRICE));
        Boolean isDisplayed = CART_ESTIMATED_PRICE.isDisplayed();
        return CART_ESTIMATED_PRICE.getText().trim();
    }
    
    public Boolean compareEstimatedTax(String tax1,String tax2)
    {
    	//Fetching the Value of Tax1
    	Boolean value = false;
        char[] a = tax1.toCharArray();
        StringBuffer str = new StringBuffer();
        for (Character ch : a) {
            if (Character.isDigit(ch) || ch == '.') {
                str.append(ch);
            }
        }
        String priceValue1 = str.toString();
        double tax1Price = Double.parseDouble(priceValue1);
        
      //Fetching the Value of Tax2
        char[] b = tax2.toCharArray();
        StringBuffer str1 = new StringBuffer();
        for (Character ch1 : b) {
            if (Character.isDigit(ch1) || ch1 == '.') {
            	str1.append(ch1);
            }
        }
        String priceValue2 = str1.toString();
        double tax2Price = Double.parseDouble(priceValue2);
        System.out.println(tax1Price);
        System.out.println(tax2Price);
    	
        if(tax1Price<tax2Price)
        {
        	System.out.println("Huwai Tax is less than other Country Tax");
        }
        else
        {
        	Assert.fail("Huwai Tax is greater than other Country Tax");
        }
             
    	return value;
    }

    public void verifyTotalTax() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_TOTAL_PRICE));
        Boolean isDisplayed = CART_TOTAL_PRICE.isDisplayed();
        if (!isDisplayed) {
            Assert.fail("Total Price is not displayed");
        }
    }

    public void clickAddCartRecommendation() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_RECOMMENDATION_ADD_CART));
        CART_RECOMMENDATION_ADD_CART.click();
    }

    public void clickAddCartAccessories() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_ACCESSORIES_ADD_CART));
        CART_ACCESSORIES_ADD_CART.click();
    }

    public void clickRemoveItem() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CART_REMOVE_ITEM_BUTTON));
        Thread.sleep(4000);
        jsClick(CART_REMOVE_ITEM_BUTTON);
    }

}
