package pages;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class HomePage {

    public void waitPageLoaded() {
        webdriver().shouldHave(urlContaining("home"));
    }
}
