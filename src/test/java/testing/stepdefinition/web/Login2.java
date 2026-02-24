package testing.stepdefinition.web;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import testing.model.web.Modelo;
import testing.model.web.Modelo2;
import testing.question.web.loginq;
import testing.task.web.LoginUser;
import testing.task.web.LoginUser2;
import testing.userinterface.BaseURL;
import testing.util.LeerExcel;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;


public class Login2 {

//    @Given("{} navega a la página de login")
//
//    public void researchingThings(String usuario) {
//        OnStage.theActorCalled(usuario)
//                .attemptsTo(Open.url(BaseURL.getUrlExtern()));
//    }
//
    @When("ingresa sus credenciales válidas")
    public void ingresaElUsername() {
        List<Modelo2> users =
                LeerExcel.readLoginData("src/test/resources/data/Excel.xlsx", "Hoja1");

       Modelo2 user = users.get(0);

       theActorInTheSpotlight().attemptsTo(
               LoginUser2.onTheSite(user)
        );
//       for (Modelo2 user : users) {
//           theActorInTheSpotlight().attemptsTo(
//                   LoginUser2.onTheSite(user)
//           );
//      }

    }

//    @Then("deberías ver {string}")
//    public void deberíaVer(String resultado) {
//        theActorInTheSpotlight().should(
//                seeThat(loginq.GetDescription(), equalTo(resultado))
//        );
//    }

}
