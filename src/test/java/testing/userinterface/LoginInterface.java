package testing.userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
;

public class LoginInterface {

    public final static Target TXT_USER = Target.the("txt").located(By.id("LoginPanel0_Username"));
    public final static Target TXT_PASS = Target.the("txtPass").located(By.id("LoginPanel0_Password"));
    public final static Target BTN_SUBMIT = Target.the("btnSubmit").located(By.id("LoginPanel0_LoginButton"));
    public final static Target TXT_VALIDATION = Target.the("txtValidation").located(By.xpath("//*[@id=\"s-DashboardPage\"]/main/section/section/h1"));
    public final static Target BTN_CLIENTES = Target.the("btnClientes").located(By.xpath("//*[@id=\"nav_menu1_2_1\"]/li[1]/a/span"));
    public final static Target COUNTRY_DROPDOWN = Target.the("btnDropdown").located(By.xpath("//a[@class=\"select2-choice select2-default\"][1]"));
    public final static Target REPRESENT = Target.the("R").located(By.xpath("//*[@id=\"s2id_autogen3\"]"));
    public final static Target TXT_PAIS = Target.the("txtPais").located(By.id("s2id_autogen1_search"));
    public final static Target  PAIS=Target.the("pais").located(By.xpath("//*[@id=\"select2-results-1\"]"));

    }


