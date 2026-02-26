package testing.stepdefinition.web;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import testing.model.web.ModeloExcel;
import testing.model.web.ModeloLogin;
import testing.question.web.loginq;
import testing.task.web.LoginUser;
import testing.task.web.LoginUserxls;
import testing.userinterface.BaseURL;
import testing.util.LeerExcel;


import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
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
                LoginUser.onTheSite(ModeloLogin.setData(dataTable).get(0))
        );

    }

    @When("ingresa sus credenciales válidas")
    public void ingresaElUsername() {
        List<ModeloExcel> users =
                LeerExcel.readLoginData("src/test/resources/data/Excel.xlsx", "Hoja1");

        ModeloExcel user = users.get(0);

        theActorInTheSpotlight().attemptsTo(
                LoginUserxls.onTheSite(user)
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
                LoginUser.onTheSite(ModeloLogin.setData(dataTable).get(0))
        );

    }

    @Then("debería visualizar el mensaje de error {string}")
    public void deberíaVisualizarElMensajeDeError(String mensaje) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(loginq.GetValidationCredencial(), equalTo(mensaje))
        );
    }
}
