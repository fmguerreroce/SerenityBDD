package testing.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import testing.model.LoginModel;
import testing.question.LoginQ;
import testing.task.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static testing.userinterface.LoginInterface.TXT_VALIDATION;
import static testing.util.GlobalData.ACTOR;
import static testing.util.GlobalData.URL;

public class LoginStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
//    @After
//    public void CloseDriver() throws IOException, InterruptedException{
//        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
//        KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
//}

    @Given("el usuario accede a la pagina")
    public void el_usuario_acceda_la_pagina() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }

    @When("ingresa sus credenciales")
    public void ingresaSusCredenciales(DataTable  dataTable) {
     OnStage.theActorInTheSpotlight().attemptsTo(
             Login.onTheSite(LoginModel.setData(dataTable).get(0))
     );
    }

    @Then("^valido el texto en pantalla (.*)$")
    public void validoElTextoEnPantallaMensaje(String texto) {
        OnStage.theActorInTheSpotlight().should(seeThat(LoginQ.of(TXT_VALIDATION),containsString(texto)));
        System.out.println("texto: " +texto);


    }

    @And("selecciono el")
    public void seleccionoElPais(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onTheSite(LoginModel.setData(dataTable).get(0)));
              //  System.out.println("El país es: " + (LoginModel.setData(dataTable).get(0));
                // Debug




    }

    @And("^valido el nombre el pais filtrado (.*)")
    public void validoElNombreElPaisFiltradoNombreFiltrado() {


    }


}

