package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/resources/features", glue = {"stepdefs"},tags = "@LoginTest",plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"
}, monochrome = true,publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)
    public Object[][] scenario(){
        return super.scenarios();

    }


}
