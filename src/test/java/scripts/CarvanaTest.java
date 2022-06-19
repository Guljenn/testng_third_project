package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base {


    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testCarvanaHomePageTitleAndUrl() {
        driver.get("https://www.carvana.com/");
        softAssert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }


    @Test(priority = 2, description = "Validate the Carvana logo")
    public void testCarvanaLogo() {

        driver.get("https://www.carvana.com/");
        softAssert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());

    }


    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testCarvanaNavigationItems() {
        driver.get("https://www.carvana.com/");
        String[] expectedTexts = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(carvanaHomePage.carvanaNavItems.get(i).isDisplayed());
            softAssert.assertEquals(carvanaHomePage.carvanaNavItems.get(i).getText(), expectedTexts[i]);
        }
    }


    @Test(priority = 4, description = "Validate the sign in error message")
    public void testCarvanaSignInErrorMessage() {
        driver.get("https://www.carvana.com/");
        String expectedMessage = "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.";
        carvanaHomePage.signInButton.click();
        carvanaHomePage.emailInput.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordInput.sendKeys("abcd1234");
        carvanaHomePage.modulSignInButton.click();
        Assert.assertTrue(carvanaHomePage.signInErrorMessage.isDisplayed());
        softAssert.assertEquals(carvanaHomePage.signInErrorMessage.getText(), expectedMessage);

    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testCarvanaSeacrhFilterAndSearchButton() {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        String[] expectedText = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < carvanaSearchCarsPage.searchFilterOptions.size(); i++) {
            Assert.assertTrue(carvanaSearchCarsPage.searchFilterOptions.get(i).isDisplayed());
            softAssert.assertEquals(carvanaSearchCarsPage.searchFilterOptions.get(i).getText(), expectedText[i]);
        }
    }

    @Test(priority = 6, description = "Validate the search result tiles")
    public void testCarvanaSearchResultTitles() {

        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaSearchCarsPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaSearchCarsPage.goButton.click();
        Waiter.pause(2);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for (WebElement element : carvanaMercedesSearchPage.imageSearchResults) {
            Assert.assertTrue(element.isDisplayed());
        }

        for (WebElement element : carvanaMercedesSearchPage.favoriteButtonResults) {
            Assert.assertTrue(element.isDisplayed());

        }

        for (WebElement element : carvanaMercedesSearchPage.tileBodyResults) {
            Assert.assertTrue(element.isDisplayed());

        }


        for (int i = 0; i < carvanaMercedesSearchPage.resultTile.size(); i++) {
            Assert.assertTrue(carvanaMercedesSearchPage.resultTile.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesSearchPage.inventoryTypes.get(i).isDisplayed() && !carvanaMercedesSearchPage.inventoryTypes.isEmpty());
            if (carvanaMercedesSearchPage.inventoryTypes.get(i).getAttribute("data-test") != null) {
                Assert.assertTrue(carvanaMercedesSearchPage.yearAndMakeInfo.get(i).isDisplayed());
                if (carvanaMercedesSearchPage.trimMileageInfo.get(i).getAttribute("class") != null)
                    Assert.assertTrue(carvanaMercedesSearchPage.trimMileageInfo.get(i).isDisplayed());
                Assert.assertTrue(Integer.parseInt(carvanaMercedesSearchPage.priceInfo.get(i).getText().replace("$", "").replace(",", "")) > 0);
                if (carvanaMercedesSearchPage.monthlyPaymentInfo.get(i).getAttribute("class") != null)
                    Assert.assertTrue(carvanaMercedesSearchPage.monthlyPaymentInfo.get(i).isDisplayed());
                if (carvanaMercedesSearchPage.downPaymentInfo.get(i).getAttribute("class") != null)
                    Assert.assertTrue(carvanaMercedesSearchPage.downPaymentInfo.get(i).isDisplayed());
                Assert.assertTrue(carvanaMercedesSearchPage.freeDeliveryResults.get(i).getText().contains("Free Shipping"));

            }
        }
    }
}
