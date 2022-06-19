package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaMercedesSearchPage {

    public CarvanaMercedesSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class='result-tile']")
    public List<WebElement> resultTile;

    @FindBy(css = "picture[class='vehicle-image']")
    public List<WebElement> imageSearchResults;

    @FindBy(css = "div[class='favorite-vehicle']")
    public List<WebElement> favoriteButtonResults;

    @FindBy(css = "div[class='tk-frame middle-frame']")
    public List<WebElement> tileBodyResults;

    @FindBy(css = "div[data-test='InventoryTypeExperiment']")
    public List<WebElement> inventoryTypes;

    @FindBy(css = "div[class='year-make']")
    public List<WebElement> yearAndMakeInfo;

    @FindBy(css = "div[class='trim-mileage']")
    public List<WebElement> trimMileageInfo;

    @FindBy(css = "div[class='price ']")
    public List<WebElement> priceInfo;

    @FindBy(css = "div[class='monthly-payment']")
    public List<WebElement> monthlyPaymentInfo;

    @FindBy(css = "div[class='down-payment']")
    public List<WebElement> downPaymentInfo;

    @FindBy(css = "div[class='base-delivery-chip delivery-chip']")
    public List<WebElement> freeDeliveryResults;
}
