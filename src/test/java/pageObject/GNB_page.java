package pageObject;

import base.Setup;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class GNB_page extends Setup {

    public GNB_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
            .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);

    // Elements
    @FindBy(how = How.LINK_TEXT, using = "My LG")
    public WebElement GNB_MY_ACCOUNT_ICON_LINK;
    @FindBy(how = How.LINK_TEXT, using = "Sign In / Sign Up")
    public WebElement GNB_SIGN_IN_SIGN_UP_LINK;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'TV')]")
    public WebElement GNB_TV_SECTION;
    @FindBy(how = How.LINK_TEXT, using = "OLED TVs")
    public WebElement GNB_OLED;


    public void clickOnMyAccountIconFromGNB() {
        GNB_MY_ACCOUNT_ICON_LINK.click();
    }

    public void clickSignInSignUpLinkFromGNB() {
        GNB_SIGN_IN_SIGN_UP_LINK.click();
    }

    public void mouseOverTVLink() {
        wait.until(ExpectedConditions.elementToBeClickable(GNB_TV_SECTION));
        Actions actions = new Actions(driver);
        actions.moveToElement(GNB_TV_SECTION).perform();
    }

    public void clickOLEDSection() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(GNB_OLED));
        GNB_OLED.click();
        Thread.sleep(1000);
    }

}
