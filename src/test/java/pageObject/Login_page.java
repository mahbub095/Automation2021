package pageObject;

import base.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login_page extends Setup {

    public Login_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
