package pageObject;

import base.GlobalTestData;
import base.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Signup_page extends Setup {

    public Signup_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
            .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
    // Elements
    @FindBy(how = How.CSS, using = "h1.title")
    public WebElement SIGN_UP_PAGE_HEADER_TEXT;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign Up now')]")
    public WebElement SIGN_UP_NOW_BUTTON;
    @FindBy(how = How.ID, using = "txtBoxEmail")
    public WebElement SIGN_UP_EMAIL_TXT_BOX;
    @FindBy(how = How.ID, using = "txtBoxEmailError")
    public WebElement SIGN_UP_EMAIL_ERROR_MESSAGE;
    @FindBy(how = How.ID, using = "txtBoxPassword")
    public WebElement SIGN_UP_PASSWORD_TXT_BOX;
    @FindBy(how = How.NAME, using = "passwordConfirm")
    public WebElement SIGN_UP_CONFIRM_PASSWORD_TXT_BOX;
    @FindBy(how = How.CSS, using = "span.match")
    public WebElement SIGN_UP_PASSWORD_VALIDATION_MESSAGE;
    @FindBy(how = How.NAME, using = "first_name")
    public WebElement SIGN_UP_FIRST_NAME_TXT_BOX;
    @FindBy(how = How.ID, using = "txtBoxFNameError")
    public WebElement SIGN_UP_FIRST_NAME_ERROR;
    @FindBy(how = How.NAME, using = "last_name")
    public WebElement SIGN_UP_LAST_NAME_TXT_BOX;
    @FindBy(how = How.ID, using = "txtBoxLNameError")
    public WebElement SIGN_UP_LAST_NAME_ERROR;
    @FindBy(how = How.ID, using = "requestDate")
    public WebElement SIGN_UP_CALENDAR_VIEW;
    @FindBy(how = How.XPATH, using = "//select[@aria-label='Year']")
    public WebElement SIGN_UP_DOB_YEAR;
    @FindBy(how = How.XPATH, using = "//a[text()='1']")
    public WebElement SIGN_UP_CLICK_CURRENT_DATE;
    @FindBy(how = How.CSS, using = "span.ageInvalid")
    public WebElement SIGN_UP_AGE_VALIDATION_MESSAGE;
    @FindBy(how = How.XPATH, using = "//p[2]/label/span")
    public WebElement SIGN_UP_PRIVACY_POLICY_CHECKBOX;
    @FindBy(how = How.ID, using = "signUp-chk2Error")
    public WebElement SIGN_UP_PRIVACY_POLICY_VALIDATION_MESSAGE;
    @FindBy(how = How.XPATH, using = "//p[3]/label/span")
    public WebElement SIGN_UP_TERMS_AND_CONDITIONS_CHECKBOX;
    @FindBy(how = How.ID, using = "signUp-chk3Error")
    public WebElement SIGN_UP_TERMS_AND_CONDITIONS_VALIDATION_MESSAGE;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'CANCEL')]")
    public WebElement SIGN_UP_CANCEL_BUTTON;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement SIGN_UP_BUTTON;
    @FindBy(how = How.CSS, using = "h1.title")
    public WebElement SIGN_UP_COMPLETE_TITLE_TEXT;
    @FindBy(how = How.XPATH, using = "//div[@id='lgContents']/div/div/div/div")
    public WebElement SIGN_UP_COMPLETE_CONFIRMATION_TEXT;

    public void clickOnSignUpNowButtonFromSignUpPage() {
        SIGN_UP_NOW_BUTTON.click();
    }

    public void enterEmailInSignUpPage(String email) throws InterruptedException {
        SIGN_UP_EMAIL_TXT_BOX.clear();
        SIGN_UP_EMAIL_TXT_BOX.sendKeys(email);
        Thread.sleep(500);
    }

    public void enterPasswordInSignUpPage(String password) {
        SIGN_UP_PASSWORD_TXT_BOX.sendKeys(password);
    }

    public void enterConfirmPasswordInSignUpPage(String password) {
        SIGN_UP_CONFIRM_PASSWORD_TXT_BOX.sendKeys(password);
    }

    public void enterFirstNameInSignUpPage(String firstName) throws InterruptedException {
        SIGN_UP_FIRST_NAME_TXT_BOX.sendKeys(firstName);
        Thread.sleep(1500);
    }

    public void enterLastNameInSignUpPage(String lastName) throws InterruptedException {
        SIGN_UP_LAST_NAME_TXT_BOX.sendKeys(lastName);
        Thread.sleep(1500);
    }

    public void viewCalender() throws InterruptedException {
        SIGN_UP_CALENDAR_VIEW.click();
        Thread.sleep(1500);
    }

    public void selectYear(String dob_year) {
        Select year = new Select(SIGN_UP_DOB_YEAR);
        year.selectByValue(dob_year);
    }

    public void selectCurrentDate() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_UP_CLICK_CURRENT_DATE));
        SIGN_UP_CLICK_CURRENT_DATE.click();
        Thread.sleep(1500);
    }

    public void clickPrivacyPolicyCheckbox() {
        SIGN_UP_PRIVACY_POLICY_CHECKBOX.click();
    }

    public void clickTermsAndConditionsCheckbox() {
        SIGN_UP_TERMS_AND_CONDITIONS_CHECKBOX.click();
    }

    public void clickSignUpButtonToRegister() {
        SIGN_UP_BUTTON.click();
    }

    public void clearFirstNameField() {
        SIGN_UP_FIRST_NAME_TXT_BOX.clear();
    }

    public void clearLastNameField() {
        SIGN_UP_LAST_NAME_TXT_BOX.clear();
    }

    public void clearEmailField() {
        SIGN_UP_EMAIL_TXT_BOX.clear();
    }

    public void assertSignUpCompleteText() {
        String exp = "Sign Up";
        String act = SIGN_UP_COMPLETE_TITLE_TEXT.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertPasswordMatchErrorMessage() {
        String exp = "Password and Confirm Password do not match.";
        String act = SIGN_UP_PASSWORD_VALIDATION_MESSAGE.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertAccountIsCreatedText() {
        String exp = "LG.com account has been created";
        String act = SIGN_UP_COMPLETE_CONFIRMATION_TEXT.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertUnderAgeErrorMessage() {
        String exp = "It is possible to join over 16 years old.";
        String act = SIGN_UP_AGE_VALIDATION_MESSAGE.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertPrivacyPolicyErrorMessage() {
        String exp = "Agreement check is not checked.";
        String act = SIGN_UP_PRIVACY_POLICY_VALIDATION_MESSAGE.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertTermsAndConditionsErrorMessage() {
        String exp = "Agreement check is not checked.";
        String act = SIGN_UP_TERMS_AND_CONDITIONS_VALIDATION_MESSAGE.getText();
        Assert.assertEquals(act, exp);
    }

    public void cancelSignUp() {
        SIGN_UP_CANCEL_BUTTON.click();
    }

    public void assertSignInScreen() {
        String exp = "Sign In";
        String act = SIGN_UP_PAGE_HEADER_TEXT.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertEmailIsRequired() {
        String exp = "Email Account is required.";
        String act = SIGN_UP_EMAIL_ERROR_MESSAGE.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertInvalidEmail() {
        String exp = "Email Address Invalid.";
        String act = SIGN_UP_EMAIL_ERROR_MESSAGE.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertFirstNameErrorMessage() {
        String exp = "First Name is required.";
        String act = SIGN_UP_FIRST_NAME_ERROR.getText();
        Assert.assertEquals(act, exp);
    }

    public void assertLastNameErrorMessage() {
        String exp = "Last Name is required.";
        String act = SIGN_UP_LAST_NAME_ERROR.getText();
        Assert.assertEquals(act, exp);
    }

    public void generateRandomMailUsing_emailFake() throws Exception {
        driver.get("https://emailfake.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text'][@id='userName']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text'][@id='userName']")));
        Thread.sleep(5000);
        GlobalTestData.GLOBAL_CUSTOMER_BRAND_NEW_EMAIL_USER_ID =
                driver.findElement(By.xpath("//input[@type='text'][@id='userName']")).getAttribute("value");
        GlobalTestData.GLOBAL_CUSTOMER_BRAND_NEW_EMAIL_DOMAIN =
                driver.findElement(By.xpath("//input[@type='text'][@id='domainName2']")).getAttribute("value");
        GlobalTestData.GLOBAL_CUSTOMER_BRAND_NEW_EMAIL =
                GlobalTestData.GLOBAL_CUSTOMER_BRAND_NEW_EMAIL_USER_ID + "@" + GlobalTestData.GLOBAL_CUSTOMER_BRAND_NEW_EMAIL_DOMAIN;
    }

    public void activateAccount_emailFake() throws InterruptedException {
        driver.get("https://emailfake.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text'][@id='userName']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text'][@id='userName']")));
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='VERIFY ACCOUNT']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='VERIFY ACCOUNT']")));
        driver.findElement(By.xpath("//a[text()='VERIFY ACCOUNT']")).click();
        Thread.sleep(3000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='txt-wrap']/h1")));
            String actualMsg = driver.findElement(By.xpath("//div[@class='txt-wrap']/h1")).getText().trim();
            Assert.assertEquals("Verification Complete", actualMsg, "Account verification Message not Displayed");
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='txt-wrap']/h1")));
            String actualMsg = driver.findElement(By.xpath("//div[@class='txt-wrap']/h1")).getText().trim();
            Assert.assertEquals("Verification Complete", actualMsg, "Account verification Message not Displayed");
        }
    }


}
