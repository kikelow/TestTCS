package org.testtcs.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CyclesPage extends PageObject {

    public static final Target EMOJI_INDICADOR = Target.the("").located(By.xpath("//p[contains(text(),'cuantos')]"));

    public static final Target LABEL_HOME = Target.the("").located(By.xpath("//h2[contains(text(),'formulario')]"));

    public static final Target INPUT_TEXTAREA = Target.the("").located(By.name("text"));

    public static final Target LABEL_TEXTAREA = Target.the("").located(By.xpath("//p[contains(text(),'Escriba')]"));

    public static final Target LABEL_MATH_OPERATION = Target.the("").located(By.xpath("//p[contains(text(),'operación matemática')]/following-sibling::p"));

    public static final Target LIST_LABELS_MATH_OPERATION_POSIBLE_ANSWERS = Target.the("").located(By.xpath("//input[@name='radio']/parent::label"));

    public static final Target LIST_INPUTS_MATH_OPERATION_POSIBLE_ANSWERS = Target.the("").located(By.xpath("//input[@name='radio']"));


    public static final Target BUTTON_SEND = Target.the("").located(By.xpath("//button[@type='submit']"));

    public static final Target LABEL_CICLOS_REALIZADOS = Target.the("").located(By.xpath("//p[contains(text(),'ciclo')]"));

}
