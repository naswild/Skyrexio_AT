package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final String EMAIL = "//*[@placeholder='Email']";
    private static final String PASSWORD = "//*[@type='password']";
    private static final String SUBMIT_BTN = "//*[@type='submit']";
    private static final String ERROR_MSG = "//*[text()='Неверный email или пароль']";

    @Step("Open login page")
    public void openPage() {
        open("login");
    }

    @Step("Login")
    public void login(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        $x(SUBMIT_BTN).submit();
    }

    @Step("Input email")
    public void inputEmail(String email){
       $x(EMAIL).setValue(email);
    }

    @Step("Input password")
    public void inputPassword(String password){
        $x(PASSWORD).setValue(password);
    }

    public boolean waitErrorMessage() {
        return $x(ERROR_MSG).shouldBe(Condition.visible).isDisplayed();
    }
}
