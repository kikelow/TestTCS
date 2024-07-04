package org.testtcs.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target INPUT_USUARIO = Target.the("").located(By.name("username"));
    public static final Target INPUT_CLAVE = Target.the("").located(By.name("password"));
    public static final Target BOTON_ENVIAR = Target.the("").located(By.xpath("//button[contains(text(),'Enviar')]"));

}
