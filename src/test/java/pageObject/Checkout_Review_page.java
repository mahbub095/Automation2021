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

import java.time.Duration;

public class Checkout_Review_page extends Setup {

    public Checkout_Review_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Faker faker = new Faker();
    public static String productArea;
    Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
            .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
    // Elements
    @FindBy(how = How.XPATH, using = "(//div[@class='checkbox-text']//parent::label)[1]")
    public WebElement CHECKOUT_TERMS_CONDITIONS_CHECKBOX;
    @FindBy(how = How.XPATH, using = "//span[text()='Change Shipping Method']//following::button[1]")
    public WebElement CHECKOUT_PLACE_ORDER_BUTTON;
    @FindBy(how = How.XPATH, using = "//input[@id='customer-email']")
    public WebElement CHECKOUT_EMAIL_INPUT;
    @FindBy(how = How.XPATH, using = "//input[@name='telephone']")
    public WebElement CHECKOUT_PHONE_INPUT;
    @FindBy(how = How.XPATH, using = "//input[@name='firstname']")
    public WebElement CHECKOUT_FIRST_NAME_INPUT;
    @FindBy(how = How.XPATH, using = "//input[@name='lastname']")
    public WebElement CHECKOUT_LAST_NAME_INPUT;
    @FindBy(how = How.XPATH, using = "//span[text()='Address']/following::input[1]")
    public WebElement CHECKOUT_ADDRESS_INPUT;
    @FindBy(how = How.XPATH, using = "//input[@name='city']")
    public WebElement CHECKOUT_CITY_INPUT;
    @FindBy(how = How.XPATH, using = "//select[@name='region_id']")
    public WebElement CHECKOUT_REGION_DROPDOWN;
    @FindBy(how = How.XPATH, using = "//input[@name='postcode']")
    public WebElement CHECKOUT_POSTCODE_INPUT;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
    public WebElement CHECKOUT_SAVE_BUTTON;
    @FindBy(how = How.XPATH, using = "//span[text()='Use This Address']")
    public WebElement CHECKOUT_USE_THIS_ADDRESS_BUTTON;
    @FindBy(how = How.XPATH, using = "//input[@value='entered-address']")
    public WebElement CHECKOUT_ENTERED_ADDRESS_SECTION;
    @FindBy(how = How.XPATH, using = "//input[@value='suggested-address']")
    public WebElement CHECKOUT_SUGGESTED_ADDRESS_SECTION;
    @FindBy(how = How.XPATH, using = "//span[text()='Continue to payment']")
    public WebElement CHECKOUT_CONTINUE_PAYMENT_BUTTON;

    public void clickTermsConditionsFromReviewPage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKOUT_TERMS_CONDITIONS_CHECKBOX));
        Thread.sleep(2000);
        CHECKOUT_TERMS_CONDITIONS_CHECKBOX.click();
        Thread.sleep(1000);
    }

    public void clickPlaceOrderButtonFromReviewPage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKOUT_PLACE_ORDER_BUTTON));
        CHECKOUT_PLACE_ORDER_BUTTON.click();
        Thread.sleep(1000);
    }

    public void enter_contact_shipping_info() {
        GlobalTestData.GLOBAL_CUSTOMER_EMAIL = faker.internet().safeEmailAddress();
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        String address1 = null;
        String city = null;
        String state = null;
        String zipcode = null;
        if (productArea.contains("CA")) {
            address1 = GlobalTestData.GLOBAL_CA_ADDRESS1;
            city = GlobalTestData.GLOBAL_CA_CITY;
            state = GlobalTestData.GLOBAL_CA_STATE;
            zipcode = GlobalTestData.GLOBAL_CA_ZIPCODE;
        } else if (productArea.contains("NY")) {
            address1 = GlobalTestData.GLOBAL_NY_ADDRESS1;
            city = GlobalTestData.GLOBAL_NY_CITY;
            state = GlobalTestData.GLOBAL_NY_STATE;
            zipcode = GlobalTestData.GLOBAL_NY_ZIPCODE;
        } else if (productArea.contains("TX")) {
            address1 = GlobalTestData.GLOBAL_TX_ADDRESS1;
            city = GlobalTestData.GLOBAL_TX_CITY;
            state = GlobalTestData.GLOBAL_TX_STATE;
            zipcode = GlobalTestData.GLOBAL_TX_ZIPCODE;
        }
        enterContactInformation(GlobalTestData.GLOBAL_CUSTOMER_EMAIL,
                GlobalTestData.GLOBAL_CUSTOMER_PHONE_NUMBER, GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME,
                GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME, address1, city, state, zipcode);
    }

    public void enterContactInformation(String email, String phoneNumber, String firstName, String lastName,
                                        String address, String city, String state, String zipcode) {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKOUT_EMAIL_INPUT));
        CHECKOUT_EMAIL_INPUT.sendKeys(email);
        CHECKOUT_PHONE_INPUT.sendKeys(phoneNumber);
        CHECKOUT_FIRST_NAME_INPUT.sendKeys(firstName);
        CHECKOUT_LAST_NAME_INPUT.sendKeys(lastName);
        CHECKOUT_ADDRESS_INPUT.sendKeys(address);
        CHECKOUT_CITY_INPUT.sendKeys(city);
        CHECKOUT_REGION_DROPDOWN.click();
        CHECKOUT_REGION_DROPDOWN.sendKeys(state);
        CHECKOUT_POSTCODE_INPUT.sendKeys(zipcode);
    }


}
