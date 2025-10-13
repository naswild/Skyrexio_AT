package ui.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import ui.parent.BaseTest;

public class HomeTest extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @Test(description = "Verify wording's language")
    public void verifyLanguage() {
        loginPage.openPage()
                .chooseLanguage()
                .loginSuccess();

        homePage.waitPageLoaded()
                .chooseLanguage()
                .isTitleVisible();
    }
}
