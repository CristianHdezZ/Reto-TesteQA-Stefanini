package co.com.stefanini.certification.testfront.stepdefinitions;

import co.com.stefanini.certification.testfront.model.builder.UserBuilder;
import co.com.stefanini.certification.testfront.questions.CheckDeletedUser;
import co.com.stefanini.certification.testfront.questions.CheckTheErrorMessage;
import co.com.stefanini.certification.testfront.questions.CheckTheUserRegistered;
import co.com.stefanini.certification.testfront.questions.CheckTheUserRegisteredOrderId;
import co.com.stefanini.certification.testfront.tasks.DeleteUser;
import co.com.stefanini.certification.testfront.tasks.RegisterSuccess;
import co.com.stefanini.certification.testfront.tasks.RegisterWithAnErrorField;
import co.com.stefanini.certification.testfront.tasks.RegisterWithoutData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.stefanini.certification.testfront.util.Constants.URL_SYSTEM;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class UserRegisterStepDefinitions {

    @Before(order = 1)
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("I enter the system")
    public void i_enter_the_system() {
        theActorCalled("TestQA").wasAbleTo(Open.url(URL_SYSTEM));
    }

    @When("I register without filling in the mandatory fields")
    public void i_register_without_filling_in_the_mandatory_fields() {
        theActorInTheSpotlight().wasAbleTo(RegisterWithoutData.theUserAccount());
    }

    @Then("I should see that message {string}")
    public void i_should_see_that_message(String expectedResult) {
        theActorInTheSpotlight().should(seeThat(CheckTheErrorMessage.with(expectedResult)));
    }

    @When("I register with an error field {string}")
    public void i_register_with_an_error_field(String userType) {
        theActorInTheSpotlight().wasAbleTo(RegisterWithAnErrorField.theUserAccount(UserBuilder.getValue(userType)));
    }

    @When("I register a user successfully by {string}")
    public void i_register_a_user_successfully_by(String userType) {
        theActorInTheSpotlight().wasAbleTo(RegisterSuccess.theUserAccount(UserBuilder.getValue(userType)));
    }
    @Then("I should see that {string} registered")
    public void i_should_see_that_registered(String userType) {
        theActorInTheSpotlight().should(seeThat(CheckTheUserRegistered.with(UserBuilder.getValue(userType))));
    }

    @Then("I should see that {string} registered with order id {string}")
    public void i_should_see_that_registered_with_order_id(String userType, String orderId) {
        theActorInTheSpotlight().should(seeThat(CheckTheUserRegisteredOrderId.with(UserBuilder.getValue(userType),orderId)));
    }

    @When("I delete the user {string}")
    public void i_delete_the_user(String userType) {
        theActorInTheSpotlight().wasAbleTo(DeleteUser.with(UserBuilder.getValue(userType)));

    }
    @Then("I should see that {string} deleted")
    public void i_should_see_that_deleted(String userType) {
        theActorInTheSpotlight().should(seeThat(CheckDeletedUser.with(UserBuilder.getValue(userType))));
    }

    @After
    public void AfterSteps() {
        getDriver().quit();
    }
}
