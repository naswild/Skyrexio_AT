package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.PropertyEnum;
import io.qameta.allure.Step;
import parent.BasePage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;

public class SmartTerminalPage extends BasePage {

    private static final String INPUT_FIELDS = "input.tw-flex-1";
    private static final String SUBMIT_BTN = "//*[@type='submit']";
    private static final String TRADE_MANAGEMENT_MENU
            = "//*[name()='svg' and contains(@class, 'lucide-ellipsis-vertical')]/ancestor::button";
    private static final String DEFAULT_EMPTY_VALUE = "0";

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
        String confirmBtn = TEXT_LOCATOR_PATTERN.formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_CONFIRM));
        $x(confirmBtn).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Check if the order is displayed")
    public SmartTerminalPage isOrderActive() {
        String terminalActive = TEXT_LOCATOR_PATTERN.formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_ACTIVE));
        $x(terminalActive).shouldBe(Condition.visible);

        return this;
    }

    @Step("Check if error message is visible")
    public SelenideElement isErrorMsgVisible() {
        String terminalErrorMsg = TEXT_LOCATOR_PATTERN.formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_ERROR_MSG));

        return $x(terminalErrorMsg).shouldBe(Condition.visible);
    }

    @Step("Open trade management menu")
    public SmartTerminalPage openTradeManagementMenu() {
        $x(TRADE_MANAGEMENT_MENU).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Cancel order")
    public SmartTerminalPage cancelOrder() {
        String cancelBtn = TEXT_LOCATOR_PATTERN.formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_CANCEL_TRADE));
        $x(cancelBtn).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Confirm cancellation")
    public SmartTerminalPage confirmCancellation() {
        String confirmBtn = TEXT_LOCATOR_PATTERN.formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_CONFIRM));
        $x(confirmBtn).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Check if cancellation message is visible")
    public SmartTerminalPage isCancellationMsgVisible() {
        String cancellationTitle = TEXT_LOCATOR_PATTERN.formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_CANCELLATION_TITLE));
        String cancellationText = TEXT_LOCATOR_PATTERN.formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_CANCELLATION_TEXT));
        $x(cancellationTitle).shouldBe(Condition.visible);
        $x(cancellationText).shouldBe(Condition.visible);

        return this;
    }
}
