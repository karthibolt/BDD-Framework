package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class dropdownpage {

    WebDriver driver;
    public dropdownpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[text()='Selenium']//preceding-sibling::td//input")
    WebElement selectdrop;

    @FindBy(id = "ContentPlaceHolder1_ddlState")
    WebElement cascade;

    public List<WebElement> getAllHeaders() {
        return driver.findElements(By.xpath("//table[@id=\"customers\"]//th"));
    }
    public int getHeadersize() {
        return getAllHeaders().size(); // Returns the size of the header list
    }

    public List<WebElement> getAllRows() {
        return driver.findElements(By.xpath("//table[@id='customers']//tr"));
    }
    public int getRowsize() {
        return getAllRows().size(); // Returns the size of the header list
    }

    public List<WebElement> getColumndata() {
        return driver.findElements(By.xpath("//table[@id='customers']//td"));
    }
    public int getColumnsize() {
        return getColumndata().size(); // Returns the size of the header list
    }
    public void clickdropdown() {
        selectdrop.click();
    }

    public WebElement getstatedrop() {
        return cascade;

    }
}
