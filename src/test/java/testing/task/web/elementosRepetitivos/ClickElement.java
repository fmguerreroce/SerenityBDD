package testing.task.web.elementosRepetitivos;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickElement implements Task {
    private Target elemento;

    public ClickElement(Target elemento){
        this.elemento = elemento;
    }

    public static ClickElement sobre(Target elemento){
        return instrumented(ClickElement.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(elemento)
        );
    }
}
