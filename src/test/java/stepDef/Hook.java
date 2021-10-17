package stepDef;

import base.GlobalTestData;
import base.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.util.Strings;

public class Hook extends Setup {
    public static String url;
    public static String baseURL = System.getProperty("env");
    public static String browserType = System.getProperty("browser");
    Logger logger = LoggerFactory.getLogger(Hook.class);

    @Before
    public void openBrowser() throws InterruptedException {
        if (Strings.isNullOrEmpty(browserType)){
            browserType="ch";
        }
        if (Strings.isNullOrEmpty(baseURL)){
            baseURL="prod";
        }
        driver = initDriver(browserType);
        switch (baseURL){
            case "qa" :
                url = "https://webqa.us.lg.com/us";
                GlobalTestData.VISA_CARD_NO = "4111111111111111";
                GlobalTestData.VISA_EXP_NO = "04/29";
                GlobalTestData.VISA_CVV = "353";
                break;
            case "stg" :
                url = "https://wwwstg.us.lg.com/us";
                GlobalTestData.VISA_CARD_NO = "4111111111111111";
                GlobalTestData.VISA_EXP_NO = "04/29";
                GlobalTestData.VISA_CVV = "353";
                break;
            case "prod" :
                url = "http://lg.com/us";
                GlobalTestData.OMV_Subscription = "LT600P";
                GlobalTestData.OMV_Non_Subscription = "5215ER2002G";
                GlobalTestData.OMD_HE_Innovel = "LSCE365ST";
                GlobalTestData.OMD_HE_Non_Innovel = "AN-MR18BA";
                GlobalTestData.OMD_HA_Innovel = "WKGX201HBA";
                GlobalTestData.OMD_HA_Non_Innovel = "A929KVM";
                GlobalTestData.OMD_KLARNA = "65NANO90UPA";
                GlobalTestData.VISA_CARD_NO = "4111111111111111";
                GlobalTestData.VISA_EXP_NO = "04/29";
                GlobalTestData.VISA_CVV = "353";
                GlobalTestData.MASTER_CARD_NO = "5425233430109903";
                GlobalTestData.MASTER_EXP_NO = "04/23";
                GlobalTestData.MASTER_CVV = "123";
                GlobalTestData.AMEX_CARD_NO = "371100001000131";
                GlobalTestData.AMEX_EXP_NO = "05/23";
                GlobalTestData.AMEX_CVV = "1234";              
                break;
        }
        driver.get(url);
        logger.info("Test Started");
    }

    @After
    public void tearDown(Scenario scenario){
        try{
            if (scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } catch (Exception e){
            System.out.println(e + "failed to take screenshot");
        }
        driver.quit();
        logger.info("Test Ended");
    }

}
