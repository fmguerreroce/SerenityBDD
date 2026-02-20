package testing.task.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import testing.model.web.Modelo;
import testing.userinterface.web.LoginUI;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUser implements Task {
Modelo modelo;

public LoginUser(Modelo modelo) {
    this.modelo=modelo;

}
    public static LoginUser onTheSite(Modelo modelo) {
        return instrumented(LoginUser.class, modelo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
         Enter.theValue(modelo.getUsername()).into(LoginUI.USER),
                Enter.theValue(modelo.getPassword()).into(LoginUI.PASS),
                Click.on(LoginUI.BTN_LOGIN)

        );


    }
}
