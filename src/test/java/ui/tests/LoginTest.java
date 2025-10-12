package ui.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.parent.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @Test(description = "Login with correct credentials")
    public void loginWithCorrectCredentials() {
        loginPage.openPage()
                .chooseLanguage()
                .loginSuccess();

        homePage.waitPageLoaded();
        assertEquals(url(), baseUrl + "home");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"anastasiia.ev.education@gmail.com", "sfjswfg345728"},
                {"lelik@yandex.ru", "lolikbolik"}
        };
    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @Test(description = "Login with incorrect credentials", dataProvider = "loginData")
    public void loginWithIncorrectCredentials(String email, String password) {
        loginPage.openPage()
                .chooseLanguage()
                .login(email, password)
                .waitErrorMessage();
    }
}
