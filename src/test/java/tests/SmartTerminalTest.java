package tests;

import enums.PropertyEnum;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import parent.BaseTest;
import utils.PropertyReader;

import static org.testng.Assert.assertTrue;

public class SmartTerminalTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @Test(description = "Limit buy order")
    public void limitBuyOrder() {
        loginPage.openPage();
        loginPage.login(PropertyReader.getProperty(PropertyEnum.EMAIL.getValue()),
                PropertyReader.getProperty(PropertyEnum.PASSWORD.getValue()));
        homePage.waitPageLoaded();
        smartTerminalPage.openPage()
                    .setOrderPrice("123405")
                    .setUnits("0.0055")
                    .submitOrder()
                    .confirmOrder();
        assertTrue(smartTerminalPage.isOrderActive());
    }
}
