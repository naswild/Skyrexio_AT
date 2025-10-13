package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.PropertyEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import parent.BasePage;

import static com.codeborne.selenide.Selenide.*;
import static enums.PropertyEnum.EMAIL;
import static enums.PropertyEnum.PASSWORD;
import static utils.PropertyReader.getProperty;

public class LoginPage extends BasePage {

    private static final String EMAIL_INPUT = "//*[@placeholder='Email']";
    private static final String PASSWORD_INPUT = "//*[@type='password']";
    private static final String SUBMIT_BTN = "//*[@type='submit']";
    private static final String LANGUAGE_BTN = "//*[@aria-haspopup='menu']";
    final String language = "//div/span[text()='%s']".formatted(getProperty(PropertyEnum.PAGES_LANGUAGE));
    final String loginTitle = TEXT_LOCATOR_PATTERN.formatted(getProperty(PropertyEnum.LOGIN_TITLE));
    final String errorMsg = TEXT_LOCATOR_PATTERN.formatted(getProperty(PropertyEnum.LOGIN_ERROR_MSG));

    @Step("Open login page")
    public LoginPage openPage() {
        open("login");

        return this;
    }

    @Step("Choose language")
    public LoginPage chooseLanguage() {
        $x(LANGUAGE_BTN).click();
        $x(language).click();
        actions().sendKeys(Keys.ESCAPE).perform();
        $x(language).shouldNotBe(Condition.visible);

        return this;
    }

    @Step("Check if title is right")
    public LoginPage checkIfTitleIsRight() {
        $x(loginTitle).shouldBe(Condition.visible);

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
                getProperty(EMAIL),
                getProperty(PASSWORD)
        );

        return this;
    }

    @Step("Input email")
    public LoginPage inputEmail(String email) {
        $x(EMAIL_INPUT).shouldBe(Condition.visible).shouldBe(Condition.enabled).setValue(email);

        return this;
    }

    @Step("Input password")
    public LoginPage inputPassword(String password) {
        $x(PASSWORD_INPUT).shouldBe(Condition.visible).shouldBe(Condition.enabled).setValue(password);

        return this;
    }

    @Step("Check if error message is displayed")
    public SelenideElement waitErrorMessage() {
        return $x(errorMsg).shouldBe(Condition.visible);
    }
}
