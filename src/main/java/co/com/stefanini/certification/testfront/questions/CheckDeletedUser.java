package co.com.stefanini.certification.testfront.questions;

import co.com.stefanini.certification.testfront.model.builder.UserBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.TABLE_COLUMN_NAME;

public class CheckDeletedUser implements Question<Boolean> {
    private final UserBuilder userType;

    public CheckDeletedUser(UserBuilder userType) {
        this.userType = userType;
    }

    public static CheckDeletedUser with(UserBuilder userType) {
        return new CheckDeletedUser(userType);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return !TABLE_COLUMN_NAME.of(userType.getObject().getName()).resolveFor(actor).isPresent();
    }
}
