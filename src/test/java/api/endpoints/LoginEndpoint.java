package api.endpoints;

import api.dto.UserDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class LoginEndpoint {

    public ValidatableResponse login(String email, String password) {
        UserDto user = new UserDto(email, password);

        return given().contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .when()
                .post("/user/login")
                .then().log().all();
    }

    public String extractToken(String email, String password) {
        return login(email, password)
                .extract()
                .path("data.accessToken");
    }
}
