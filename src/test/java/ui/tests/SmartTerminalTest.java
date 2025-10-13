package ui.tests;

import com.codeborne.selenide.ex.ElementNotFound;
import enums.PropertyEnum;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.parent.BaseTest;
import utils.PropertyReader;

import static org.testng.Assert.assertThrows;

public class SmartTerminalTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        loginPage.openPage()
                .chooseLanguage()
                .loginSuccess();

        homePage.waitPageLoaded()
                .chooseLanguage();

        smartTerminalPage.openPage();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @Test(description = "Create limit buy order", groups = {"creation"}, priority = 1)
    public void limitBuyOrder() {
        smartTerminalPage.chooseTradeType(PropertyReader.getProperty(PropertyEnum.TERMINAL_LIMIT))
                .setOrderPrice(smartTerminalPage.getOrderPriceInput().getValue())
                .setUnits(smartTerminalPage.getUnitsInput().getValue())
                .setTotal(smartTerminalPage.getTotalInput().getValue())
                .submitOrder()
                .confirmOrder()
                .isOrderActive();

        assertThrows(ElementNotFound.class, () -> smartTerminalPage.isErrorMsgVisible());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @Test(description = "Cancel order", priority = 2)
    public void cancelOrder() {
        smartTerminalPage.setOrderPrice(smartTerminalPage.getOrderPriceInput().getValue())
                .setUnits(smartTerminalPage.getUnitsInput().getValue())
                .setTotal(smartTerminalPage.getTotalInput().getValue())
                .submitOrder()
                .confirmOrder()
                .isOrderActive()
                .openTradeManagementMenu()
                .cancelOrder()
                .confirmCancellation()
                .isCancellationMsgVisible();
    }

    @AfterMethod(onlyForGroups = {"creation"})
    public void cleanUpCreatedTrade() {
        smartTerminalPage.openTradeManagementMenu()
                .cancelOrder()
                .confirmCancellation()
                .isCancellationMsgVisible();
    }
}
