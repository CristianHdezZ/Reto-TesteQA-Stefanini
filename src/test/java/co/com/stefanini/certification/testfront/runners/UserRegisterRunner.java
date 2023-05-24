package co.com.stefanini.certification.testfront.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        tags = "@Test",
        features = "src/test/resources/features/userRegister.feature",
        glue = "co.com.stefanini.certification.testfront.stepdefinitions"
)
public class UserRegisterRunner {
}
