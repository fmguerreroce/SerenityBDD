package testing.stepdefinition.web;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import testing.model.LoginModel;
import testing.model.web.Modelo;
import testing.question.web.loginq;
import testing.task.web.LoginUser;
import testing.userinterface.BaseURL;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class Login {

    @Given("el {} navega a la página de login")

    public void researchingThings(String usuario) {
        OnStage.theActorCalled(usuario)
                .attemptsTo(Open.url(BaseURL.getUrlExtern()));
    }

    @When("ingresa el username")
    public void ingresaElUsername(DataTable dataTable) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginUser.onTheSite(Modelo.setData(dataTable).get(0))
        );

    }

    @Then("debería visualizar la página {string}")
    public void deberíaVer(String resultado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(loginq.GetDescription(), equalTo(resultado))
        );
    }

    @When("ingresa sus credenciales invalidas")
    public void ingresaSusCredencialesInvalidas(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginUser.onTheSite(Modelo.setData(dataTable).get(0))
        );

    }

    @Then("debería visualizar el mensaje de error {string}")
    public void deberíaVisualizarElMensajeDeError(String mensaje) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(loginq.GetValidationCredencial(), equalTo(mensaje))
        );
    }
}
