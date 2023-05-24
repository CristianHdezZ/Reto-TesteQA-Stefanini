package co.com.stefanini.certification.testfront.questions;

import co.com.stefanini.certification.testfront.model.builder.UserBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.TABLE_COLUMN_ID;
import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.TABLE_COLUMN_NAME;

public class CheckTheUserRegisteredOrderId implements Question<Boolean> {

    private final UserBuilder userType;
    private final String orderId;

    public CheckTheUserRegisteredOrderId(UserBuilder userType, String orderId) {
        this.userType = userType;
        this.orderId = orderId;
    }

    public static CheckTheUserRegisteredOrderId with(UserBuilder userType, String orderId) {
        return new CheckTheUserRegisteredOrderId(userType,orderId);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return TABLE_COLUMN_NAME.of(userType.getObject().getName()).resolveFor(actor).isPresent()
                && Text.of(TABLE_COLUMN_ID.of(userType.getObject().getName())).answeredBy(actor).equalsIgnoreCase(orderId);
    }
}
