package scripts;

import pages.CarvanaHomePage;
import pages.CarvanaMercedesSearchPage;
import pages.CarvanaSearchCarsPage;
import utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    SoftAssert softAssert;
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchCarsPage carvanaSearchCarsPage;
    CarvanaMercedesSearchPage carvanaMercedesSearchPage;



    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        carvanaHomePage = new CarvanaHomePage();
        carvanaSearchCarsPage = new CarvanaSearchCarsPage();
        carvanaMercedesSearchPage = new CarvanaMercedesSearchPage();



    }

    @AfterMethod
    public void teardown(){
        // TODO build a method that will take a screenshot of failures
        softAssert.assertAll();
        Driver.quitDriver();
    }
}

