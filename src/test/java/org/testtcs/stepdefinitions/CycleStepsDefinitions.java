package org.testtcs.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import org.testtcs.tasks.AnswersAll;
import org.testtcs.tasks.Login;
import org.testtcs.tasks.SaveToken;

public class CycleStepsDefinitions {

    @Managed
    WebDriver webDriver;

    private Actor harinson;

    @Given("{string} quiere acceder a el test de ciclos del portal evalart")
    public void quiereAccederAElTestDeCiclosDelPortalEvalart(String actor) {
        harinson = Actor.named(actor).whoCan(BrowseTheWeb.with(webDriver));
        harinson.wasAbleTo(
                Open.browserOn().thePageNamed("pages.automation")
        );
    }

    @And("ingresa su usuario y clave y realiza click sobre el boton enviar para acceder")
    public void ingresaSuUsuarioYClaveYRealizaClickSobreElBotonEnviarParaAcceder() {
        harinson.attemptsTo(
                Login.toAccess()
        );
    }

    @When("responda y envie el cuestionario hasta completar los ciclos")
    public void respondaYEnvieElCuestionarioHastaCompletarLosCiclos() throws InterruptedException {
        harinson.attemptsTo(
                AnswersAll.cycles()
        );
        Thread.sleep(5000L);
    }

    @Then("obtendra el hash para validar el examen")
    public void obtendraElHashParaValidarElExamen() {
        harinson.attemptsTo(
                SaveToken.ofTest()
        );
    }
}
