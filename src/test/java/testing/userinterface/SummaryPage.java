package testing.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SummaryPage {

    public final static Target BTN_CLIENTES = Target.the("btnClientes").located(By.xpath("//*[@id=\"nav_menu1_2_1\"]/li[1]/a/span"));
}
