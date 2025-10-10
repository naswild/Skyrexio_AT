package parent;

import com.codeborne.selenide.Configuration;
import enums.PropertyEnum;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartTerminalPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SmartTerminalPage smartTerminalPage;

    @BeforeClass
    public void chooseLanguage() {
        PropertyReader.initProperties(PropertyReader.getProperty(PropertyEnum.TESTS_LANGUAGE));
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = PropertyReader.getProperty(PropertyEnum.BASE_URL);
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
