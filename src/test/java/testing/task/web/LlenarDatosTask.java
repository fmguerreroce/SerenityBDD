package testing.task.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import testing.model.web.ModeloDatos;
import testing.model.web.ModeloProductos;
import testing.userinterface.web.CompraUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarDatosTask implements Task {

    ModeloDatos modeloDatos;
    public LlenarDatosTask(ModeloDatos modeloDatos){
        this.modeloDatos = modeloDatos;
    }

    public static LlenarDatosTask onTheSite(ModeloDatos modeloDatos) {
        return instrumented(LlenarDatosTask.class, modeloDatos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        Enter.theValue(modeloDatos.getFirstName()).into(CompraUI.FIRST_NAME),
        Enter.theValue(modeloDatos.getLastName()).into(CompraUI.LAST_NAME),
        Enter.theValue(modeloDatos.getPostalCode()).into(CompraUI.POSTAL_CODE)
        );
    }
}
