package ui.parent;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import ui.pages.SmartTerminalPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static enums.PropertyEnum.BASE_URL;
import static enums.PropertyEnum.TESTS_LANGUAGE;
import static utils.PropertyReader.getProperty;

public class BaseTest {

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SmartTerminalPage smartTerminalPage;

    @BeforeClass
    public void chooseLanguage() {
        PropertyReader.initProperties(getProperty(TESTS_LANGUAGE));
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = getProperty(BASE_URL);
        Configuration.browserSize = "1920x1080";

        loginPage = new LoginPage();
        homePage = new HomePage();
        smartTerminalPage = new SmartTerminalPage();
    }

    @AfterMethod
    public void close() {
        clearBrowserCache();
        closeWebDriver();
    }
}
