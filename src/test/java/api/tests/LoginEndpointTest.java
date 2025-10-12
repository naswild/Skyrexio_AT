package api.tests;

import api.parent.BaseTest;
import enums.PropertyEnum;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class LoginEndpointTest extends BaseTest {

    @Test(description = "Login with correct credentials")
    public void loginWithCorrectCredentials() {
        loginEndpoint.login(PropertyReader.getProperty(PropertyEnum.EMAIL), PropertyReader.getProperty(PropertyEnum.PASSWORD))
                .statusCode(200)
                .body("success", equalTo(true))
                .body("status", equalTo(200))
                .body("data", hasKey("accessToken"));
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"anastasiia.ev.education@gmail.com", "sfjswfg345728"},
                {"lelik@yandex.ru", "lolikbolik"}
        };
    }

    @Test(description = "Login with incorrect credentials", dataProvider = "loginData")
    public void loginWithIncorrectCredentials(String email, String password) {
        loginEndpoint.login(email, password)
                .statusCode(200)
                .body("success", equalTo(false))
                .body("status", equalTo(400))
                .body("data.errorCode", equalTo("AUTH_CRED_001"));
    }
}
