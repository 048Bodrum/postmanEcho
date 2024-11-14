package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


class PostmanechoTest {
    @Test
    void shouldReturnSendData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("netology") // отправляемые данные (заголовки и query можно выставлять аналогично)

                .when().log().all()
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("work"));
    }
}
