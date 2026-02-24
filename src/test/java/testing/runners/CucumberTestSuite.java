
package testing.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "testing.stepdefinition",
        tags = "@ESC01_COMPRAA"
)
public class CucumberTestSuite {
    // Clase vacía siguiendo el estándar
}

