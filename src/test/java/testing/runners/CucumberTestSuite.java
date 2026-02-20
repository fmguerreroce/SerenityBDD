
package testing.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        glue = "testing.stepdefinition",
        features="src/test/resources/feature",
        tags = "@ESC01_COMPRAA"

)
public class CucumberTestSuite {

}