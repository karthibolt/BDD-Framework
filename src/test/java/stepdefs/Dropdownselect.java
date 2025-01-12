package stepdefs;

import Pages.dropdownpage;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdownselect {

    private WebDriver driver;
    private dropdownpage dropdown;

    String url2= PropertyReader.getBaseUrl2();
    String cascadeurl= PropertyReader.getCascadeUrl();
    public String browsername = PropertyReader.getbrowser();

    @Before
    public void setup(){

        driver = DriverFactory.getDriver(browsername);
        dropdown = new dropdownpage(driver);
        ExtentReport.createTest("Extent report test");

    }
    @After
    public void teardown(){

        DriverFactory.closeDriver();
        ExtentReport.getTest().log(Status.INFO, "Driver closed successfully");
        ExtentReport.flush();
    }
    @Test
    @Given("User launches the application")
    public void user_launches_the_application() throws InterruptedException {

        ExtentReport.getTest().log(Status.INFO, "Navigating to the URL");
        driver.get(url2);
        LoggerUtil.info("Application opened successfully.");
        dropdown = new dropdownpage(driver);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> allheader = dropdown.getAllHeaders();
        int allheadersize = allheader.size();
        System.out.println("The number of headers is " + allheadersize);
        ExtentReport.getTest().log(Status.INFO, "Header size: " + allheadersize);
        Assert.assertEquals(allheadersize, 5, "Column count is not the same");

        boolean status = false;
        for(WebElement ele: allheader){
            String value= ele.getText();
            System.out.println(value);
            if(value.contains("Country")){
                status = true;
                break;
            }
        }
        Assert.assertTrue(status, "Headers is not present");

        List<WebElement> totalrows = dropdown.getAllRows();
        int Alltotalrows = totalrows.size();
        Assert.assertEquals(Alltotalrows, 7, "Table row has not matched ");

    }
    @Test
    @When("User enters click the dropdown")
    public void user_enters_click_the_dropdown() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dropdown.clickdropdown();
    }
    @Then("User able to get the total columns")
    public void user_able_to_get_the_total_columns() {

        List<WebElement> numberofCoulmndata = dropdown.getColumndata();

        boolean datastatus = false;
        for(WebElement ele: numberofCoulmndata){
            String value= ele.getText();
            System.out.println(value);
            if(value.contains("California")){
                datastatus = true;
                break;
            }
        }
        Assert.assertTrue(datastatus, "Column Records did not present in the table");
        ExtentReport.getTest().log(Status.INFO, "Column Records: " + datastatus);


    }
    @When("User launches the another cascading application")
    public void user_launches_the_another_cascading_application() {

        driver.get(cascadeurl);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement Statedrop = dropdown.getstatedrop();
        Select sle = new Select(Statedrop);
        List<WebElement> ele = sle.getOptions();
        List<String> actualstate = new ArrayList<>();
        for(WebElement element: ele){

            actualstate.add(element.getText());

        }
        System.out.println("Total states are :"+ actualstate);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Statedrop);
        WebElement lastOption = ele.get(ele.size() - 1);
        String lastText = lastOption.getText();
        sle.selectByVisibleText(lastText);
        System.out.println("Selected Option: " + lastText);
        ExtentReport.getTest().log(Status.INFO, "Selected Option: " + lastText);


    }

}
