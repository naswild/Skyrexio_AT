package api.tests;

import api.parent.BaseTest;
import enums.PropertyEnum;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class SmartTradeEndpointTest extends BaseTest {

    @Test(description = "Create limit buy order")
    public void createLimitBuyOrder() {
        smartTradeEndpoint.createSmartTrade(
                        PropertyReader.getProperty(PropertyEnum.EMAIL),
                        PropertyReader.getProperty(PropertyEnum.PASSWORD))
                .statusCode(201)
                .body("success", equalTo(true))
                .body("status", equalTo(200))
                .body("data.successCode", equalTo("SMART_TRADE_CREATE_001"))
                .body("data.message", equalTo("SmartTrade created"))
                .body("data", hasKey("smartTradeUuid"))
                .body("data", hasKey("skyrexUserUuid"));
    }

    @Test(description = "Cancel order")
    public void cancelOrder() {
        String smartTradeUuid = smartTradeEndpoint.createSmartTrade(
                        PropertyReader.getProperty(PropertyEnum.EMAIL),
                        PropertyReader.getProperty(PropertyEnum.PASSWORD)
                )
                .extract()
                .path("data.smartTradeUuid");

        smartTradeEndpoint.cancelSmartTrade(
                        PropertyReader.getProperty(PropertyEnum.EMAIL),
                        PropertyReader.getProperty(PropertyEnum.PASSWORD),
                        smartTradeUuid)
                .statusCode(201)
                .body("success", equalTo(true))
                .body("status", equalTo(200))
                .body("data.message", equalTo("Processed 1 smart trade(s)"))
                .body("data.results[0].smartTradeUuid", equalTo(smartTradeUuid))
                .body("data.results[0].success", equalTo(true));
    }
}
