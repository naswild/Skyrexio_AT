package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.PropertyEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class HomePage {

    private static final String ACCOUNT_BTN = "//button[@aria-haspopup='menu']";
    private static final String LANGUAGE_BTN = "(//button[@aria-haspopup='menu'])[2]";

    public HomePage waitPageLoaded() {
        webdriver().shouldHave(urlContaining("home"));
        return this;
    }

    @Step("Choose language")
    public HomePage chooseLanguage() {
        String language = "//div/span[text()='%s']".formatted(PropertyReader.getProperty(PropertyEnum.PAGES_LANGUAGE));

        $x(ACCOUNT_BTN).shouldBe(Condition.visible).click();
        $x(LANGUAGE_BTN).shouldBe(Condition.visible).click();
        $x(language).shouldBe(Condition.visible).click();
        actions().sendKeys(Keys.ESCAPE).perform();
        $x(language).shouldNotBe(Condition.visible);

        return this;
    }

    @Step("Check if title visible")
    public SelenideElement isTitleVisible() {
        String title = "//h2[text()='%s']".formatted(PropertyReader.getProperty(PropertyEnum.HOME_STATISTICS));
        return $x(title).shouldBe(Condition.visible);
    }
}
