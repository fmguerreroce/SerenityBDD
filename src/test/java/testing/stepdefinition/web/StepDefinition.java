package testing.stepdefinition.web;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class StepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
