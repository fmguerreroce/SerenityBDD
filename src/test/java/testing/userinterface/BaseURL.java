package testing.userinterface;


import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class BaseURL {

    private static EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getUrlExtern() {
        return EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getProperty("webdriver.base.url");
    }
}
