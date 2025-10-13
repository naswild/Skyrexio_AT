package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import parent.BasePage;

import static com.codeborne.selenide.Selenide.*;
import static enums.PropertyEnum.*;
import static utils.PropertyReader.getProperty;

public class SmartTerminalPage extends BasePage {

    private static final String INPUT_FIELDS = "input.tw-flex-1";
    private static final String SUBMIT_BTN = "//*[@type='submit']";
    private static final String TRADE_MANAGEMENT_MENU
            = "//*[name()='svg' and contains(@class, 'lucide-ellipsis-vertical')]/ancestor::button";
    private static final String DEFAULT_EMPTY_VALUE = "0";
    final String terminalActive = TEXT_LOCATOR_PATTERN.formatted(getProperty(TERMINAL_ACTIVE));
    final String confirmOrderBtn = TEXT_LOCATOR_PATTERN.formatted(getProperty(TERMINAL_CONFIRM));
    final String terminalErrorMsg = TEXT_LOCATOR_PATTERN.formatted(getProperty(TERMINAL_ERROR_MSG));
    final String cancelBtn = TEXT_LOCATOR_PATTERN.formatted(getProperty(TERMINAL_CANCEL_TRADE));
    final String confirmCancellationBtn = TEXT_LOCATOR_PATTERN.formatted(getProperty(TERMINAL_CONFIRM));
    final String cancellationTitle = TEXT_LOCATOR_PATTERN.formatted(getProperty(TERMINAL_CANCELLATION_TITLE));
    final String cancellationText = TEXT_LOCATOR_PATTERN.formatted(getProperty(TERMINAL_CANCELLATION_TEXT));

    @Step("Open smart trade page")
    public SmartTerminalPage openPage() {
        open("manual-trading/trading-terminal");

        return this;
    }

    @Step("Choose {tradeType} trade type")
    public SmartTerminalPage chooseTradeType(String tradeType) {
        $x(TEXT_LOCATOR_PATTERN.formatted(tradeType)).shouldBe(Condition.visible).scrollTo().click();

        return this;
    }

    public SelenideElement getOrderPriceInput() {
        ElementsCollection inputFields = $$(INPUT_FIELDS);

        return inputFields.get(0).shouldNotHave(Condition.exactValue(DEFAULT_EMPTY_VALUE));
    }

    public SelenideElement getUnitsInput() {
        ElementsCollection inputFields = $$(INPUT_FIELDS);

        return inputFields.get(1).shouldNotHave(Condition.exactValue(DEFAULT_EMPTY_VALUE));
    }

    public SelenideElement getTotalInput() {
        ElementsCollection inputFields = $$(INPUT_FIELDS);

        return inputFields.get(2).shouldNotHave(Condition.exactValue(DEFAULT_EMPTY_VALUE));
    }

    @Step("Set order price")
    public SmartTerminalPage setOrderPrice(String orderPrice) {
        getOrderPriceInput().setValue(orderPrice);

        return this;
    }

    @Step("Set units")
    public SmartTerminalPage setUnits(String units) {
        getUnitsInput().setValue(units);

        return this;
    }

    @Step("Set Total")
    public SmartTerminalPage setTotal(String total) {
        getTotalInput().setValue(total);

        return this;
    }

    @Step("Submit order")
    public SmartTerminalPage submitOrder() {
        $x(SUBMIT_BTN).shouldBe(Condition.visible).scrollTo().click();

        return this;
    }

    @Step("Confirm order")
    public SmartTerminalPage confirmOrder() {
        $x(confirmOrderBtn).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Check if the order is displayed")
    public SmartTerminalPage isOrderActive() {
        $x(terminalActive).shouldBe(Condition.visible);

        return this;
    }

    @Step("Check if error message is visible")
    public SelenideElement isErrorMsgVisible() {
        return $x(terminalErrorMsg).shouldBe(Condition.visible);
    }

    @Step("Open trade management menu")
    public SmartTerminalPage openTradeManagementMenu() {
        $x(TRADE_MANAGEMENT_MENU).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Cancel order")
    public SmartTerminalPage cancelOrder() {
        $x(cancelBtn).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Confirm cancellation")
    public SmartTerminalPage confirmCancellation() {
        $x(confirmCancellationBtn).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Check if cancellation message is visible")
    public SmartTerminalPage isCancellationMsgVisible() {
        $x(cancellationTitle).shouldBe(Condition.visible);
        $x(cancellationText).shouldBe(Condition.visible);

        return this;
    }
}
