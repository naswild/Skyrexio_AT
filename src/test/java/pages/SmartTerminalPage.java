package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class SmartTerminalPage {

    private static final String INPUT_FIELDS = "input.tw-flex-1";
    private static final String SUBMIT_BTN = "//*[@type='submit']";
    private static final String CONFIRM_BTN = "//*[text()='Подтвердить']";
    private static final String ACTIVE_STATUS = "//*[text()='активен']";

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
        $x(SUBMIT_BTN).should(Condition.exist).shouldBe(Condition.visible).scrollTo().click();
        return this;
    }

    @Step("Confirm order")
    public SmartTerminalPage confirmOrder() {
        $x(CONFIRM_BTN).should(Condition.exist).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Check if the order is displayed")
    public boolean isOrderActive() {
        return $x(ACTIVE_STATUS).shouldBe(Condition.visible).isDisplayed();
    }
}
