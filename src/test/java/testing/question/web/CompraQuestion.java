package testing.question.web;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.userinterface.web.CompraUI;
import testing.userinterface.web.LoginUI;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.userinterface.web.CompraUI.VALIDACION_MENSAJE;
import static testing.userinterface.web.CompraUI.VALIDACION_PRECIO;

public class CompraQuestion {
    public static Question<String> mostrado() {
        WaitUntil.the(VALIDACION_PRECIO, isVisible()).forNoMoreThan(10).seconds();
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(VALIDACION_PRECIO)
        );

        return actor -> VALIDACION_PRECIO
                .resolveFor(actor)
                .getText();
    }

    public static Question<String> GetMensajeExitoso(){

        return Question.about("Texto de validación")
                .answeredBy(actor -> {

                    actor.attemptsTo(
                            WaitUntil.the(VALIDACION_MENSAJE, isVisible())
                                    .forNoMoreThan(10).seconds()
                    );

                    return VALIDACION_MENSAJE
                            .resolveFor(actor)
                            .getText();
                });
    }
}
