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

    @And("agredo los productos a la cesta")
    public void agredoLosProductosALaCesta(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                ProductosTask.onTheSite(ModeloProductos.setData(dataTable).get(0))
        );

    }

    @And("le doy click en el icono de carrito")
    public void leDoyClickEnElIconoDe() {
        theActorInTheSpotlight().attemptsTo(
                ClickElement.sobre(CompraUI.BTN_CAR)
        );
    }

    @And("le doy click en el boton checkout")
    public void leDoyClickEnElBoton() {
        theActorInTheSpotlight().attemptsTo(
        ClickElement.sobre(CompraUI.BTN_CHECKOUT)
        );
    }

    @And("lleno el formulario con los datos")
    public void llenoElFormularioConLosDatos(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
        LlenarDatosTask.onTheSite(ModeloDatos.setData(dataTable).get(0))
        );

    }

    @And("le doy click en el boton continue")
    public void leDoyClickEnElBotonContinue() {
        theActorInTheSpotlight().attemptsTo(
      ClickElement.sobre(CompraUI.BTN_CONTINUE)
        );
    }

    @And("valido que se muestre el resumen del {string}")
    public void validoQueSeMuestreElResumenDelPrecioTotal(String precioTotal) {

        theActorInTheSpotlight().should(
                seeThat(CompraQuestion.mostrado(),
                        containsString(precioTotal))
        );
    }


    @And("doy click en el boton finalizar")
    public void doyClickEnElBotonFinalizar() {
        theActorInTheSpotlight().attemptsTo(
     ClickElement.sobre(CompraUI.BTN_FINALIZAR)
);
    }

    @And("Valido el mensaje exitoso {string}")
    public void validoElMensajeExitosoMensaje(String mensaje) {

        OnStage.theActorInTheSpotlight().should(
                seeThat(CompraQuestion.GetMensajeExitoso(), equalTo(mensaje))
        );
        System.out.println("El mensaje exitoso " + mensaje);

    }

}
