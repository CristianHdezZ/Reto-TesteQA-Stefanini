package co.com.stefanini.certification.testfront.questions;

import co.com.stefanini.certification.testfront.model.builder.UserBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.TABLE_COLUMN_NAME;

public class CheckTheUserRegistered implements Question<Boolean> {
    private final UserBuilder userType;

    public CheckTheUserRegistered(UserBuilder userType) {
        this.userType = userType;
    }

    public static CheckTheUserRegistered with(UserBuilder userType) {
        return new CheckTheUserRegistered(userType);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return TABLE_COLUMN_NAME.of(userType.getObject().getName()).resolveFor(actor).isPresent();
    }
}
