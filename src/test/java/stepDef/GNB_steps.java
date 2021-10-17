package stepDef;

import base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObject.GNB_page;

import java.util.Iterator;
import java.util.Set;


public class GNB_steps extends Setup {
    GNB_page GNB = new GNB_page(driver);

    @Given("I am at LG Home Page")
    public void homePage() {
        Set<String> winIds = driver.getWindowHandles();
        System.out.println ("Total windows -> " + winIds.size());
        if (winIds.size () == 2){
            Iterator<String> iter = winIds.iterator();
            String mainWinID = iter.next();
            String popupWindID = iter.next();
            driver.switchTo().window(popupWindID);
            driver.close();
            driver.switchTo().window(mainWinID);
        }
    }

    @Given("I came to Signup page from GNB")
    public void imInSignUpPage() {
        GNB.clickOnMyAccountIconFromGNB();
        GNB.clickSignInSignUpLinkFromGNB();
    }

    @And("I navigates to LG Sign Up page")
    public void iNavigatesToLGSignUpPage() {
        driver.navigate().to(Hook.url);
        GNB.clickOnMyAccountIconFromGNB();
        GNB.clickSignInSignUpLinkFromGNB();
    }
    
   


}
