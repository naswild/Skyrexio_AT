package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.PropertyEnum;
import io.qameta.allure.Step;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;

public class SmartTerminalPage {

    private static final String INPUT_FIELDS = "input.tw-flex-1";
    private static final String SUBMIT_BTN = "//*[@type='submit']";

    @Step("Open smart trade page")
    public SmartTerminalPage openPage() {
        open("manual-trading/trading-terminal");

        return this;
    }

    public SelenideElement getOrderPriceInput() {
        ElementsCollection inputFields = $$(INPUT_FIELDS);

        return inputFields.get(0);
    }

    public SelenideElement getUnitsInput() {
        ElementsCollection inputFields = $$(INPUT_FIELDS);

        return inputFields.get(1);
    }

    public SelenideElement getTotalInput() {
        ElementsCollection inputFields = $$(INPUT_FIELDS);

        return inputFields.get(2);
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

    @Step("Submit order")
    public SmartTerminalPage submitOrder() {
        $x(SUBMIT_BTN).shouldBe(Condition.visible).scrollTo().click();

        return this;
    }

    @Step("Confirm order")
    public SmartTerminalPage confirmOrder() {
        String confirmBtn = "//*[text()='%s']".formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_CONFIRM));
        $x(confirmBtn).shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Check if the order is displayed")
    public SelenideElement isOrderActive() {
        String terminalActive = "//*[text()='%s']".formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_ACTIVE));

        return $x(terminalActive).shouldBe(Condition.visible);
    }

    @Step("Check if error message is visible")
    public SelenideElement isErrorMsgVisible() {
        String terminalErrorMsg = "//*[text()='%s']".formatted(PropertyReader.getProperty(PropertyEnum.TERMINAL_ERROR_MSG));

        return $x(terminalErrorMsg).shouldBe(Condition.visible);
    }
}
