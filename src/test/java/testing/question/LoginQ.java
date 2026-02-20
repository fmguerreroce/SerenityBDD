package testing.question;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class LoginQ implements Question<String> {
    Target elemnt;
    public LoginQ(Target elemnt) {
        this.elemnt = elemnt;
    }

    @Override
    public String answeredBy(Actor actor) {
        return elemnt.resolveFor(actor).getText();
    }

    public static LoginQ of(Target elemnt) {
        return Instrumented.instanceOf((LoginQ.class)).withProperties(elemnt);
    }

}
