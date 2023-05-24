package co.com.stefanini.certification.testfront.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignUpFormPage {
    public static final Target BUTTON_REGISTER = Target.the("Button register").located(By.id("register"));
    public static final Target LABEL_ERROR_EMPTY = Target.the("Label error name").locatedBy("//p[contains(text(),'{0}')]");
    public static final Target INPUT_NAME = Target.the("Input name").located(By.id("name"));
    public static final Target INPUT_EMAIL = Target.the("Input email").located(By.id("email"));
    public static final Target INPUT_PASSWORD = Target.the("Input password").located(By.id("password"));
    public static final Target TABLE_COLUMN_NAME = Target.the("Table column name").locatedBy("//td[contains(text(),'{0}')]");
    public static final Target TABLE_COLUMN_ID = Target.the("Table column name").locatedBy("(//td[contains(text(),'{0}')]/..//td)[1]");
    public static final Target BUTTON_DELETE = Target.the("Button delete").locatedBy("(//td[contains(text(),'{0}')]/..//td)[4]/a");






}
