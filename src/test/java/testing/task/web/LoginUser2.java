package testing.task.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import testing.model.web.Modelo;
import testing.model.web.Modelo2;
import testing.userinterface.web.LoginUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUser2 implements Task {
Modelo2 modelo2;

public LoginUser2(Modelo2 modelo2) {
    this.modelo2 =modelo2;

}
    public static LoginUser2 onTheSite(Modelo2 modelo2) {
        return instrumented(LoginUser2.class, modelo2);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
         Enter.theValue(modelo2.getUsuario()).into(LoginUI.USER),
                Enter.theValue(modelo2.getPassword()).into(LoginUI.PASS),
                Click.on(LoginUI.BTN_LOGIN)

        );


    }
}
