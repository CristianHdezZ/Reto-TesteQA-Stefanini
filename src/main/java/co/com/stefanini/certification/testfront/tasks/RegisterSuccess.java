package co.com.stefanini.certification.testfront.tasks;

import co.com.stefanini.certification.testfront.model.builder.UserBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.*;
import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.BUTTON_REGISTER;

public class RegisterSuccess implements Task {
    private final UserBuilder userType;

    public RegisterSuccess(UserBuilder userType) {
        this.userType = userType;
    }

    public static RegisterSuccess theUserAccount(UserBuilder userType) {
        return Tasks.instrumented(RegisterSuccess.class,userType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userType.getObject().getName()).into(INPUT_NAME),
                Enter.theValue(userType.getObject().getEmail()).into(INPUT_EMAIL),
                Enter.theValue(userType.getObject().getPassword()).into(INPUT_PASSWORD),
                Click.on(BUTTON_REGISTER),
                Scroll.to(TABLE_COLUMN_NAME.of(userType.getObject().getName()))
        );
    }
}
