package co.com.stefanini.certification.testfront.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.stefanini.certification.testfront.userinterface.SignUpFormPage.LABEL_ERROR_EMPTY;

public class CheckTheErrorMessage implements Question<Boolean> {
    private final String expectedResult;

    public CheckTheErrorMessage(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public static CheckTheErrorMessage with(String expectedResult) {
        return new CheckTheErrorMessage(expectedResult);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LABEL_ERROR_EMPTY.of(expectedResult).resolveFor(actor).isPresent();
    }
}
