package co.com.stefanini.certification.testfront.tasks;

import co.com.stefanini.certification.testfront.model.builder.UserBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.*;

public class RegisterWithAnErrorField implements Task {
    private final UserBuilder user;

    public RegisterWithAnErrorField(UserBuilder user) {
        this.user = user;
    }

    public static RegisterWithAnErrorField theUserAccount(UserBuilder user) {
        return Tasks.instrumented(RegisterWithAnErrorField.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getObject().getName()).into(INPUT_NAME),
                Enter.theValue(user.getObject().getEmail()).into(INPUT_EMAIL),
                Enter.theValue(user.getObject().getPassword()).into(INPUT_PASSWORD),
                Click.on(BUTTON_REGISTER)
        );
    }
}
