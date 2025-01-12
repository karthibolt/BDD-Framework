package stepdefs;

import Pages.loginpage;
import Utility.DriverFactory;
import Utility.ExtentReport;
import Utility.LoggerUtil;
import Utility.PropertyReader;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginStepDef {

  private WebDriver driver;
  private loginpage login;

  public String baseurl = PropertyReader.getBaseUrl();
    public String browsername = PropertyReader.getbrowser();

  @Before
  public void setup(){

      driver = DriverFactory.getDriver(browsername);
      login = new loginpage(driver);
      ExtentReport.createTest("Extent report test");
  }
  @After
  public void teardown(){

       DriverFactory.closeDriver();
      ExtentReport.getTest().log(Status.INFO, "Driver closed successfully");
      ExtentReport.flush();

  }
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        ExtentReport.getTest().log(Status.INFO, "Navigating to the URL");
        driver.get(baseurl);
        LoggerUtil.info("Application opened successfully.");

    }
    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);

    }
    @Then("User is navigated to the dashboard")
    public void user_is_navigated_to_the_dashboard() {
        login.clickLogin();
        String expectedtitle = "Swag Labs";
        String actualtitle = driver.getTitle();
        ExtentReport.getTest().log(Status.INFO, "Page Title: " + actualtitle);
        LoggerUtil.info("Page title: " + actualtitle);
      if(expectedtitle.equals(actualtitle)){
        System.out.println("Login successfully");
          ExtentReport.getTest().log(Status.PASS, "Page title validated successfully");

      }else {
        System.out.println("Login Failed");
      }
    }
  @Then("user is able to click the logout")
  public void user_is_able_to_click_the_logout() {

    login.tabButtonClick();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    login.logoutButtonClick();


  }
  @When("user enter invalid credentials")
  public void user_enter_invalid_credentials() {

      driver.get(baseurl);
      login = new loginpage(driver);
    login.enterUsername("1234");
    login.enterPassword("1234");
    login.clickLogin();

  }
  @Then("User should throw message")
  public void user_should_throw_message() {
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    WebElement actualerror = driver.findElement(By.xpath("//h3[contains(@data-test, 'error')]"));
    String expectederror = "Username and password do not match any user in this service";
    if(expectederror.equals(actualerror)){
     System.out.println("Error message validation successful");
   }else {
     System.out.println("Error message validation failed");
        LoggerUtil.error("Error message validation failed");
   }

  }

}
