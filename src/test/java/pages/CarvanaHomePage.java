package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaHomePage {

    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "path[fill='#00acd8']")
    public WebElement carvanaLogo;

    @FindBy(css = "div[data-qa='menu-wrapper']")
    public List <WebElement> carvanaNavItems;

    @FindBy(css = "div[data-qa='sign-in-wrapper']")
    public WebElement signInButton;

    @FindBy(id = "usernameField")
    public WebElement emailInput;

    @FindBy(id = "passwordField")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement modulSignInButton;

    @FindBy(css = "div[data-qa='error-message-container']")
    public WebElement signInErrorMessage;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsLink;


}
