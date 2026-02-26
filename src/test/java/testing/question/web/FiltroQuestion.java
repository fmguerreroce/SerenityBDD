package testing.question.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import testing.userinterface.web.CompraUI;
import testing.userinterface.web.LoginUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroQuestion implements Question<Boolean> {

    public static FiltroQuestion enLaPagina() {
        return new FiltroQuestion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        List<Double> preciosUI = Text.ofEach(LoginUI.LISTA_PRECIOS)
                .answeredBy(actor)
                .stream()
                .map(precio -> Double.parseDouble(precio.replace("$", "").trim()))
                .collect(Collectors.toList());

        List<Double> preciosOrdenados = new ArrayList<>(preciosUI);
        Collections.sort(preciosOrdenados);

        return preciosUI.equals(preciosOrdenados);
    }

}
