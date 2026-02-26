package testing.userinterface.web;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    public static Target USER = Target.the("Username")
            .located(By.id("user-name"));
    public static Target PASS = Target.the("Password")
            .located(By.id("password"));
    public static Target BTN_LOGIN = Target.the("Boton_login")
            .located(By.id("login-button"));
    public static Target VALIDACION = Target.the("Validacion")
            .located(By.xpath("//span[@class='title']"));
    public static Target VALIDACION_CREDENCIALES = Target.the("Validacion")
            .located(By.xpath("//h3[contains(text(),'Epic sadface')]"));




}
