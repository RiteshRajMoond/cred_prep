/*
 * This source file was generated by the Gradle 'init' task
 */
package reqres_api_testing;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

class AppTest {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.requestSpecification = RestAssured.given().header("x-api-key", "reqres-free-v1");
    }

    @Test
    void getUser_shouldReturnUserData() {
        RestAssured
                .given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(2))
                .body("data.email", Matchers.containsString("reqres.in"));
    }

    @Test
    void createUser_shouldReturnCreatedUser() {
        RestAssured.given().contentType("application/json").body("{\"name\": \"ritesh\", \"job\" : \"sdet\"}")
                .when().post("/api/users")
                .then().statusCode(201).body("name", Matchers.equalTo("ritesh")).body("job", Matchers.equalTo("sdet"));
    }

    @Test
    void updateUser_shouldReturnUpdatedUser() {
        RestAssured.given().contentType("application/json").body("{\"name\": \"ritesh\", \"job\": \"sdet-2\"}")
                .when().put("/api/users/2")
                .then().statusCode(200).body("name", Matchers.equalTo("ritesh"))
                .body("job", Matchers.equalTo("sdet-2"));
    }

    @Test
    void deleteUser_shouldReturnNoContent() {
        RestAssured.given()
                .when().delete("/api/users/2")
                .then().statusCode(204);
    }

    @Test
    void registerUserSuccessful_shouldReturnIdAndToken() {
        RestAssured.given().contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"qwertyu\"}")
                .when().post("/api/register")
                .then().statusCode(200).body("id", Matchers.notNullValue()).body("token", Matchers.notNullValue());
    }

    @Test
    void registerUserUnSuccessful_shouldReturnError() {
        RestAssured.given().contentType("application/json").body("{\"email\": \"eve.holt@reqres.in\"}")
                .when().post("/api/register")
                .then().statusCode(400);
    }

    @Test
    void loginUserSuccessful_shouldReturnToken() {
        RestAssured.given().contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
                .when().post("/api/login")
                .then().statusCode(200).body("token", Matchers.notNullValue());
    }

    @Test
    void loginUserUnsuccessful_shouldReturnError() {
        RestAssured.given().contentType("application/json").body("{\"email\": \"eve.holt@reqres.in\"}")
                .when().post("/api/login")
                .then().statusCode(400);
    }

    @Test
    void getUsersWithDelay_shouldReturnUserData() {
        RestAssured.given()
                .when().get("/api/users?delay=3")
                .then().statusCode(200).body("data.size()", Matchers.greaterThan(0))
                .body("data[0].id", Matchers.notNullValue());
    }
}
