package tests;

import com.codeborne.selenide.ex.ElementNotFound;
import enums.PropertyEnum;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import parent.BaseTest;
import utils.PropertyReader;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

public class SmartTerminalTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @Test(description = "Limit buy order")
    public void limitBuyOrder() {
        loginPage.openPage()
                .chooseLanguage()
                .login(

                        PropertyReader.getProperty(PropertyEnum.EMAIL),
                        PropertyReader.getProperty(PropertyEnum.PASSWORD)
                );

        homePage.waitPageLoaded()
                .chooseLanguage();

        smartTerminalPage.openPage()
                .setOrderPrice(smartTerminalPage.getOrderPriceInput().getValue())
                .setUnits(smartTerminalPage.getUnitsInput().getValue())
                .submitOrder()
                .confirmOrder();

        assertTrue(smartTerminalPage.isOrderActive());
        assertThrows(ElementNotFound.class, () -> smartTerminalPage.isErrorMsgDisplayed());
    }
}
