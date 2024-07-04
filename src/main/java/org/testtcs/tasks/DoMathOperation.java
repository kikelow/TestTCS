package org.testtcs.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.WebElement;
import org.testtcs.util.MathUtil;

import java.util.List;
import java.util.Optional;

import static org.testtcs.userinterfaces.CyclesPage.LABEL_MATH_OPERATION;
import static org.testtcs.userinterfaces.CyclesPage.LIST_LABELS_MATH_OPERATION_POSIBLE_ANSWERS;

public class DoMathOperation implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        String result = MathUtil.doMathOperations(LABEL_MATH_OPERATION.resolveFor(t).getText());
        Optional<WebElementFacade> elementFacade = LIST_LABELS_MATH_OPERATION_POSIBLE_ANSWERS.resolveAllFor(t)
                .stream()
                .filter(webElementFacade -> webElementFacade.getText().trim().equals(result))
                .findFirst();
        elementFacade.orElseThrow().click();
    }

    public static DoMathOperation fromString(){
        return Tasks.instrumented(DoMathOperation.class);
    }
}
