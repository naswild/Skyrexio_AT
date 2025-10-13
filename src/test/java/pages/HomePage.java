package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import parent.BasePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static enums.PropertyEnum.*;
import static utils.PropertyReader.getProperty;

public class HomePage extends BasePage {

    private static final String ACCOUNT_BTN = "//button[@aria-haspopup='menu']";
    private static final String LANGUAGE_BTN = "(//button[@aria-haspopup='menu'])[2]";
    final String language = TEXT_LOCATOR_PATTERN.formatted(getProperty(PAGES_LANGUAGE));
    final String tabBtnTemplate = "//*[@role='tab' and text()='%s']";

    public HomePage waitPageLoaded() {
        webdriver().shouldHave(urlContaining("home"));
        return this;
    }

    @Step("Choose language")
    public HomePage chooseLanguage() {
        $x(ACCOUNT_BTN).shouldBe(Condition.visible).click();
        $x(LANGUAGE_BTN).shouldBe(Condition.visible).click();
        $x(language).shouldBe(Condition.visible).click();
        actions().sendKeys(Keys.ESCAPE).perform();
        $x(language).shouldNotBe(Condition.visible);

        return this;
    }

    @Step("Check if localization is correct")
    public HomePage isLocalizationCorrect() {
        List<String> elementList = List.of(
                "//h2[text()='%s']".formatted(getProperty(HOME_STATISTICS)),
                tabBtnTemplate.formatted(getProperty(HOME_SPOT_TAB)),
                tabBtnTemplate.formatted(getProperty(HOME_FUTURES_TAB)),
                tabBtnTemplate.formatted(getProperty(HOME_BUY_TAB)),
                tabBtnTemplate.formatted(getProperty(HOME_SELL_TAB)),
                tabBtnTemplate.formatted(getProperty(HOME_ALL_TAB)),
                tabBtnTemplate.formatted(getProperty(HOME_BOTS_TAB)),
                tabBtnTemplate.formatted(getProperty(HOME_MANUAL_TAB))
        );

        for (String element : elementList) {
            $x(element).shouldBe(Condition.visible);
        }

        return this;
    }
}
