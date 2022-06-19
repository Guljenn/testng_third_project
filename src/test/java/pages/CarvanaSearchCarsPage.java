package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaSearchCarsPage {

    public CarvanaSearchCarsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-test='HeaderFacets'] button")
    public List<WebElement> searchFilterOptions;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;
}
