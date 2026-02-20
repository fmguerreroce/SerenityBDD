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
        String NombreActual = Text.of(CompraUI.PRODUCTO1)
                .answeredBy(actor);
        String NombreActual2 = Text.of(CompraUI.PRODUCTO2)
                .answeredBy(actor);
        String NombreActual3 = Text.of(CompraUI.PRODUCTO3)
                .answeredBy(actor);

        if (NombreActual.equals(modeloCompra.getProducto1())){

                actor.attemptsTo(
                        WaitUntil.the(ADD_CAR1, isVisible()).forNoMoreThan(5).seconds(),
                        Click.on(ADD_CAR1)


                );
            }if (NombreActual2.equals(modeloCompra.getProducto2())) {
                actor.attemptsTo(
                        WaitUntil.the(ADDCAR2, isVisible()).forNoMoreThan(5).seconds(),
                        Click.on(ADDCAR2)
                );
            }if (NombreActual3.equals(modeloCompra.getProducto3())) {
            actor.attemptsTo(
                    WaitUntil.the(ADDCAR3, isVisible()).forNoMoreThan(5).seconds(),
                    Click.on(ADDCAR3)
            );


        } else {
            System.out.println("El producto no coincide. No se agrega al carrito.");
        }


    }
}

