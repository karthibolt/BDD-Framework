package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

    WebDriver driver;
    public loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    WebElement usernameField;

    @FindBy(xpath= "//input[@placeholder=\"Password\"]")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value=\"LOGIN\"]")
    WebElement loginButton;

    @FindBy(xpath = "//button[text()='Open Menu']")
    WebElement tabButton;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    WebElement errormessageelement;

    public void enterUsername(String username) {

        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void tabButtonClick() {
        tabButton.click();
    }
    public void logoutButtonClick() {
        logoutButton.click();
    }
    public Object Errormessage() {
        errormessageelement.getText();
        return errormessageelement;
    }


}
