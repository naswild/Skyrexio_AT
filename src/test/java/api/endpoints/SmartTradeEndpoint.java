package api.endpoints;

import api.dto.smart_trade.SmartTradeBaseOrderDto;
import api.dto.smart_trade.SmartTradeCancelDto;
import api.dto.smart_trade.SmartTradeCreateDto;
import api.dto.smart_trade.SmartTradeFormDto;
import enums.PropertyEnum;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import utils.PropertyReader;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SmartTradeEndpoint {

    private final LoginEndpoint loginEndpoint = new LoginEndpoint();

    public ValidatableResponse createSmartTrade(String email, String password) {
        String accessToken = loginEndpoint.extractToken(email, password);
        SmartTradeCreateDto smartTrade = new SmartTradeCreateDto(
                new SmartTradeFormDto(
                        "BTC",
                        "USDT",
                        PropertyReader.getProperty(PropertyEnum.EXCHANGE_ACCOUNT_SPOT),
                        new SmartTradeBaseOrderDto(
                                "BUY",
                                "LIMIT",
                                80000,
                                0.0003f
                        )));


        return given().header("Authorization", "Bearer " + accessToken)
                .body(smartTrade).contentType(ContentType.JSON)
                .log().all()
                .when()
                .post("/smartTrade/create")
                .then()
                .log().all();
    }

    public ValidatableResponse cancelSmartTrade(String email, String password, String smartTradeUuid) {
        String accessToken = loginEndpoint.extractToken(email, password);
        SmartTradeCancelDto cancelDto = new SmartTradeCancelDto(List.of(smartTradeUuid));

        return given().header("Authorization", "Bearer " + accessToken)
                .body(cancelDto).contentType(ContentType.JSON)
                .log().all()
                .when()
                .post("/smartTrade/cancel")
                .then()
                .log().all();
    }
}
