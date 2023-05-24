package co.com.stefanini.certification.testfront.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.BUTTON_REGISTER;

public class RegisterWithoutData implements Task {
    public static RegisterWithoutData theUserAccount() {
        return Tasks.instrumented(RegisterWithoutData.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_REGISTER)
        );
    }
}
