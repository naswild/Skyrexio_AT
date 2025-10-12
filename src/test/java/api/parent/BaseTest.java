package api.parent;

import api.endpoints.LoginEndpoint;
import api.endpoints.SmartTradeEndpoint;
import enums.PropertyEnum;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

public class BaseTest {

    protected LoginEndpoint loginEndpoint;
    protected SmartTradeEndpoint smartTradeEndpoint;

    @BeforeClass
    public void initProperty() {
        PropertyReader.initProperties();
    }

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = PropertyReader.getProperty(PropertyEnum.BASE_URI);

        loginEndpoint = new LoginEndpoint();
        smartTradeEndpoint = new SmartTradeEndpoint();
    }
}
