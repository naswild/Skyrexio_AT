package tests;

import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertThrows;

public class SmartTerminalTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @Test(description = "Limit buy order")
    public void limitBuyOrder() {
        loginPage.openPage()
                .chooseLanguage()
                .loginSuccess();

        homePage.waitPageLoaded()
                .chooseLanguage();

        smartTerminalPage.openPage()
                .setOrderPrice(smartTerminalPage.getOrderPriceInput().getValue())
                .setUnits(smartTerminalPage.getUnitsInput().getValue())
                .submitOrder()
                .confirmOrder()
                .isOrderActive();

        assertThrows(ElementNotFound.class, () -> smartTerminalPage.isErrorMsgVisible());
    }
}
