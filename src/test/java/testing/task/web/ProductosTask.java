package testing.task.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.model.web.ModeloProductos;
import testing.userinterface.web.CompraUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.userinterface.web.CompraUI.*;

public class ProductosTask implements Task {
    ModeloProductos modeloCompra;

    public ProductosTask(ModeloProductos modeloCompra) {
        this.modeloCompra = modeloCompra;
    }

    public static ProductosTask onTheSite(ModeloProductos modeloCompra) {
        return instrumented(ProductosTask.class, modeloCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String NombreActual1 = Text.of(CompraUI.PRODUCTO1)
                .answeredBy(actor);
        String NombreActual2 = Text.of(CompraUI.PRODUCTO2)
                .answeredBy(actor);
        String NombreActual3 = Text.of(CompraUI.PRODUCTO3)
                .answeredBy(actor);

        // PRODUCTO 1
        if (NombreActual1.equals(modeloCompra.getProducto1())) {
            actor.attemptsTo(
                    WaitUntil.the(ADD_CAR1, isVisible()).forNoMoreThan(5).seconds(),
                    Click.on(ADD_CAR1)
            );
        } else {
            System.out.println("Producto 1 no coincide, no se agrega.");
        }

        // PRODUCTO 2
        if (NombreActual2.equals(modeloCompra.getProducto2())) {
            actor.attemptsTo(
                    WaitUntil.the(ADDCAR2, isVisible()).forNoMoreThan(5).seconds(),
                    Click.on(ADDCAR2)
            );
        } else {
            System.out.println("Producto 2 no coincide, no se agrega.");
        }

        // PRODUCTO 3
        if (NombreActual3.equals(modeloCompra.getProducto3())) {
            actor.attemptsTo(
                    WaitUntil.the(ADDCAR3, isVisible()).forNoMoreThan(5).seconds(),
                    Click.on(ADDCAR3)
            );
        } else {
            System.out.println("Producto 3 no coincide, no se agrega.");
        }
    }
}

