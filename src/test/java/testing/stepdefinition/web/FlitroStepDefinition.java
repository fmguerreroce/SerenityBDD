package testing.stepdefinition.web;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import testing.question.web.FiltroQuestion;
import testing.userinterface.web.CompraUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class FlitroStepDefinition {


    @When("When selecciona el filtro {string}")
    public void seleccionaElFiltro(String precio) {
        theActorInTheSpotlight().attemptsTo(
                SelectFromOptions.byVisibleText(precio)
                        .from(CompraUI.FILTROS_PRODUCTOS)
        );

    }

    @Then("los productos se muestran ordenados por precio de forma ascendente")
    public void losProductosSeMuestranOrdenadosPorPrecioDeFormaAscendente() {

        OnStage.theActorInTheSpotlight().should(
                seeThat(FiltroQuestion.enLaPagina(), equalTo(true))
        );

    }
}
