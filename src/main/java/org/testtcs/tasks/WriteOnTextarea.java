package org.testtcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.testtcs.util.NumberUtil;

import static org.testtcs.userinterfaces.CyclesPage.INPUT_TEXTAREA;
import static org.testtcs.userinterfaces.CyclesPage.LABEL_TEXTAREA;

public class WriteOnTextarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String textLabel = LABEL_TEXTAREA.resolveFor(actor).getText();
        int cantIterations = NumberUtil.getNumberFromString(textLabel);
        StringBuilder stringofSeven = new StringBuilder();
        stringofSeven.append(String.valueOf(textLabel.split("\"")[1]).repeat(Math.max(0, cantIterations)));
        actor.attemptsTo(Enter.keyValues(stringofSeven.toString()).into(INPUT_TEXTAREA));
    }

    public static WriteOnTextarea theLetter(){
        return Tasks.instrumented(WriteOnTextarea.class);
    }
}
