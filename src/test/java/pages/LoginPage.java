package pages;

import com.codeborne.selenide.Condition;
import enums.PropertyEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final String EMAIL = "//*[@placeholder='Email']";
    private static final String PASSWORD = "//*[@type='password']";
    private static final String SUBMIT_BTN = "//*[@type='submit']";
    private static final String LANGUAGE_BTN = "//*[@aria-haspopup='menu']";

    @Step("Open login page")
    public LoginPage openPage() {
        open("login");

        return this;
    }

    @Step("Choose language")
    public LoginPage chooseLanguage() {
        String language = "//div/span[text()='%s']".formatted(PropertyReader.getProperty(PropertyEnum.PAGES_LANGUAGE));

        $x(LANGUAGE_BTN).click();
        $x(language).click();
        actions().sendKeys(Keys.ESCAPE).perform();
        $x(language).shouldNotBe(Condition.visible);

        return this;
    }

    @Step("Login")
    public LoginPage login(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        $x(SUBMIT_BTN).submit();

        return this;
    }

    @Step("Login")
    public LoginPage loginSuccess() {
        login(
                PropertyReader.getProperty(PropertyEnum.EMAIL),
                PropertyReader.getProperty(PropertyEnum.PASSWORD)
        );

        return this;
    }

    @Step("Input email")
    public LoginPage inputEmail(String email) {
        $x(EMAIL).shouldBe(Condition.visible).shouldBe(Condition.enabled).setValue(email);

        return this;
    }

    @Step("Input password")
    public LoginPage inputPassword(String password) {
        $x(PASSWORD).shouldBe(Condition.visible).shouldBe(Condition.enabled).setValue(password);

        return this;
    }

    @Step("Check if error message is displayed")
    public boolean waitErrorMessage() {
        String errorMsg = "//*[text()='%s']".formatted(PropertyReader.getProperty(PropertyEnum.LOGIN_ERROR_MSG));

        return $x(errorMsg).shouldBe(Condition.visible).isDisplayed();
    }
}
