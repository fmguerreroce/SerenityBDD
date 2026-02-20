package testing.userinterface.web;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CompraUI {

    public static Target PRODUCTO1 = Target.the("Username")
            .located(By.id("item_4_title_link"));
    public static Target PRODUCTO2 = Target.the("Username")
            .located(By.id("item_0_title_link"));
    public static Target PRODUCTO3 = Target.the("Username")
            .located(By.id("item_2_title_link"));
    public static Target ADD_CAR1 = Target.the("Username")
            .located(By.id("add-to-cart-sauce-labs-backpack"));
    public static Target ADDCAR2 = Target.the("Username")
            .located(By.id("add-to-cart-sauce-labs-bike-light"));
    public static Target ADDCAR3 = Target.the("Username")
            .located(By.id("add-to-cart-sauce-labs-onesie"));
    public static Target BTN_CAR = Target.the("Username")
            .located(By.id("shopping_cart_container"));
    public static Target BTN_CHECKOUT = Target.the("Username")
            .located(By.id("checkout"));
    public static Target FIRST_NAME = Target.the("Username")
            .located(By.id("first-name"));
    public static Target LAST_NAME = Target.the("Username")
            .located(By.id("last-name"));
    public static Target POSTAL_CODE = Target.the("Username")
            .located(By.id("postal-code"));
    public static Target BTN_CONTINUE = Target.the("Username")
            .located(By.id("continue"));
    public static Target VALIDACION_PRECIO = Target.the("Username")
            .located(By.xpath("//div[contains(text(), 'Price Total')]"));
    public static Target BTN_FINALIZAR= Target.the("Username")
            .located(By.id("finish"));
    public static Target VALIDACION_MENSAJE = Target.the("Username")
            .located(By.xpath("//h2[contains(@class,'complete-header')]"));
}
