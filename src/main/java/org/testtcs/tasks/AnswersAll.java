package org.testtcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.testtcs.userinterfaces.CyclesPage;

import static org.testtcs.userinterfaces.CyclesPage.BUTTON_SEND;

public class AnswersAll implements Task {
    @Override
    public <T extends Actor> void performAs(T t) {
        String labelCycles = CyclesPage.LABEL_CICLOS_REALIZADOS.resolveFor(t).getText();
        int totalCycles = Integer.parseInt(labelCycles.substring(labelCycles.length()-2));
        for (int i = 0; i < totalCycles; i++) {
            t.attemptsTo(
                    WriteOnTextarea.theLetter(),
                    DoMathOperation.fromString(),
                    Click.on(BUTTON_SEND)
            );
        }
    }

    public static AnswersAll cycles(){
        return Tasks.instrumented(AnswersAll.class);
    }
}
