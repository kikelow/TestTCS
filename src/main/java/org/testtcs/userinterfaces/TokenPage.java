package org.testtcs.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TokenPage extends PageObject {

    public static final Target LABEL_TOKEN = Target.the("Label token").located(By.xpath("//h1[contains(text(),'Felicidades')]/following-sibling::div/child::p"));
}
