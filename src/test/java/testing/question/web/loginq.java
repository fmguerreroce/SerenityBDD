package testing.question.web;

import net.serenitybdd.core.pages.WithLocator;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import testing.userinterface.web.LoginUI;


public class loginq {
    public static Question<String> GetDescription(){
        return Question.about("Texto de validación")
                .answeredBy(actor ->
                        LoginUI.VALIDACION
                                .resolveFor(actor)
                                .getText()
                );
    }
    public static Question<String> GetValidationCredencial(){
        return Question.about("Texto de validación")
                .answeredBy(actor ->
                        LoginUI.VALIDACION_CREDENCIALES
                                .resolveFor(actor)
                                .getText()
                );
    }
}
