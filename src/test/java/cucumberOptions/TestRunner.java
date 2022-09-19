package cucumberOptions;

import com.selenium.cbh.base;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}
        , glue = {"stepDefinitions"}
        , plugin = {"pretty", "json:target/cucumber.json", "junit:target/cucumber.xml"}
        , monochrome = true
//        , tags = "@FullRegression"
//        , tags = "not @ignore"

/* To ignore any scenario while running we can  put @ignore tags to it in feature file */

)
public class TestRunner extends base {


    @AfterClass
    public static void endThis() {

//        the clear() method is used to only empty an existing Properties
        prop.clear();
        prop1.clear();


    }

}
