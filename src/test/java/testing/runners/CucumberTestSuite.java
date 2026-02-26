
package testing.runners;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/web/Compra.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "testing.stepdefinition")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ESC01_COMPRA")
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty, io.cucumber.core.plugin.SerenityReporterParallel"
)
public class CucumberTestSuite {

}

