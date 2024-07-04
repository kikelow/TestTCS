package org.testtcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.testtcs.userinterfaces.CyclesPage;
import org.testtcs.userinterfaces.LoginPage;

import static org.testtcs.util.EnviromentVariables.CLAVE;
import static org.testtcs.util.EnviromentVariables.USUARIO;

public class Login implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(USUARIO).into(LoginPage.INPUT_USUARIO),
                Enter.keyValues(CLAVE).into(LoginPage.INPUT_CLAVE),
                Click.on(LoginPage.BOTON_ENVIAR).afterWaitingUntilEnabled()
        );
        actor.attemptsTo(
                WaitUntil.the(CyclesPage.LABEL_HOME, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static Login toAccess() {
        return Tasks.instrumented(Login.class);
    }
}
