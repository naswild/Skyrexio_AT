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
    public void openPage() {
        open("manual-trading/trading-terminal");
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
    public void setOrderPrice(String orderPrice) {
        getOrderPriceInput().setValue(orderPrice);
    }

    @Step("Set units")
    public void setUnits(String units) {
        getUnitsInput().setValue(units);
    }

    @Step("Submit order")
    public void submitOrder() {
        $x(SUBMIT_BTN).should(Condition.exist).shouldBe(Condition.visible).scrollTo().click();
    }

    @Step("Confirm order")
    public void confirmOrder() {
        $x(CONFIRM_BTN).should(Condition.exist).shouldBe(Condition.visible).click();
    }

    @Step("Check if the order is displayed")
    public boolean isOrderActive() {
        return $x(ACTIVE_STATUS).shouldBe(Condition.visible).isDisplayed();
    }
}
