package testing.task;

import io.cucumber.java.bs.I;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.model.LoginModel;
import testing.userinterface.LoginInterface;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static testing.userinterface.LoginInterface.TXT_USER;

public class Login implements Task {

  LoginModel loginModel;

  public Login(LoginModel loginModel) {
    this.loginModel = loginModel;
  }

  @Override
    public <T extends Actor> void performAs(T actor) {
      actor.attemptsTo(
              WaitUntil.the(TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
              Enter.theValue(loginModel.getUser()).into(TXT_USER),
              Enter.theValue(loginModel.getPass()).into(LoginInterface.TXT_PASS),
              JavaScriptClick.on(LoginInterface.BTN_SUBMIT),
              JavaScriptClick.on(LoginInterface.BTN_CLIENTES),
             // JavaScriptClick.on(LoginInterface.COUNTRY_DROPDOWN),
              //SelectFromOptions.byVisibleText("Austria").from(LoginInterface.COUNTRY_DROPDOWN),
              SelectFromOptions.byVisibleText("Andrew Fuller").from(LoginInterface.REPRESENT));
//
//              WaitUntil.the(LoginInterface.TXT_PAIS, isVisible()).forNoMoreThan(5).seconds(),
//              Enter.theValue(loginModel.getPais()).into(LoginInterface.TXT_PAIS),
//              JavaScriptClick.on(LoginInterface.PAIS));
    actor.attemptsTo(
            Scroll.to(TXT_USER)
    );

    actor.attemptsTo(
            Scroll.to(LoginInterface.TXT_PASS),
            Enter.theValue(loginModel.getPass())
                    .into(LoginInterface.TXT_PASS)
    );
    actor.attemptsTo(
            Evaluate.javascript("window.scrollTo(0,0)"),
            Enter.theValue(loginModel.getUser())
                    .into(LoginInterface.TXT_USER)
    );















    }

    public static Performable onTheSite(LoginModel loginModel) {
      return Instrumented.instanceOf(Login.class).withProperties(loginModel);
    }



}
