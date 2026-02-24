package testing.stepdefinition.web;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actors.OnStage;
import testing.model.web.ModeloDatos;
import testing.model.web.ModeloProductos;
import testing.question.web.CompraQuestion;
import testing.question.web.loginq;
import testing.task.web.ProductosTask;
import testing.task.web.LlenarDatosTask;
import testing.task.web.elementosRepetitivos.ClickElement;
import testing.userinterface.web.CompraUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class CompraStepDefinition {

    @And("agrega los siguientes productos a la cesta")
    public void agredoLosProductosALaCesta(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                ProductosTask.onTheSite(ModeloProductos.setData(dataTable).get(0))
        );

    }

    @And("accede al carrito de compras")
    public void leDoyClickEnElIconoDe() {
        theActorInTheSpotlight().attemptsTo(
                ClickElement.sobre(CompraUI.BTN_CAR)
        );
    }

    @And("inicia el proceso de checkout")
    public void leDoyClickEnElBoton() {

        theActorInTheSpotlight().attemptsTo(
        ClickElement.sobre(CompraUI.BTN_CHECKOUT)
        );
    }

    @And("completa el formulario con los datos")
    public void llenoElFormularioConLosDatos(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
        LlenarDatosTask.onTheSite(ModeloDatos.setData(dataTable).get(0))
        );

    }

    @And("continúa con la compra")
    public void leDoyClickEnElBotonContinue() {
        theActorInTheSpotlight().attemptsTo(
      ClickElement.sobre(CompraUI.BTN_CONTINUE)
        );
    }

    @And("debería visualizar el resumen con el total {string}")
    public void validoQueSeMuestreElResumenDelPrecioTotal(String precioTotal) {

        theActorInTheSpotlight().should(
                seeThat(CompraQuestion.mostrado(),
                        containsString(precioTotal))
        );
    }

    @And("finaliza la compra")
    public void doyClickEnElBotonFinalizar() {
        theActorInTheSpotlight().attemptsTo(
     ClickElement.sobre(CompraUI.BTN_FINALIZAR)
);
    }

    @And("debería visualizar el mensaje exitoso {string}")
    public void validoElMensajeExitosoMensaje(String mensaje) {

        OnStage.theActorInTheSpotlight().should(
                seeThat(CompraQuestion.GetMensajeExitoso(), equalTo(mensaje))
        );
        System.out.println("El mensaje exitoso " + mensaje);

    }

}
