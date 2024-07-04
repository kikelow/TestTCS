package org.testtcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.testtcs.userinterfaces.TokenPage;
import org.testtcs.util.PropertiesUtil;

public class SaveToken implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
         String token = TokenPage.LABEL_TOKEN.resolveFor(actor).getText();
         PropertiesUtil.salvarToken(token);
    }

    public static SaveToken ofTest(){
        return Tasks.instrumented(SaveToken.class);
    }
}
