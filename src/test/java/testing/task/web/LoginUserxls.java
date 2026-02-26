package testing.task.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import testing.model.web.ModeloExcel;
import testing.userinterface.web.LoginUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUserxls implements Task {
ModeloExcel modeloExcel;

public LoginUserxls(ModeloExcel modeloExcel) {
    this.modeloExcel =modeloExcel;

}
    public static LoginUserxls onTheSite(ModeloExcel modeloExcel) {
        return instrumented(LoginUserxls.class, modeloExcel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
         Enter.theValue(modeloExcel.getUsuario()).into(LoginUI.USER),
                Enter.theValue(modeloExcel.getPassword()).into(LoginUI.PASS),
                Click.on(LoginUI.BTN_LOGIN)

        );


    }
}
