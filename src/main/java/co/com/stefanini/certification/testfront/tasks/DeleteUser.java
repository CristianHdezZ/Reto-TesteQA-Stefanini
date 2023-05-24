package co.com.stefanini.certification.testfront.tasks;

import co.com.stefanini.certification.testfront.model.builder.UserBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.BUTTON_DELETE;

public class DeleteUser implements Task {
    private final UserBuilder userType;

    public DeleteUser(UserBuilder userType) {
        this.userType = userType;
    }

    public static DeleteUser with(UserBuilder userType) {
        return Tasks.instrumented(DeleteUser.class,userType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_DELETE.of(userType.getObject().getName()))
        );

    }
}
