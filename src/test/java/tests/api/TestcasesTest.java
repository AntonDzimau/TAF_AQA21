package tests.api;

import baseEntities.BaseAPITest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.TestCase;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class TestcasesTest extends BaseAPITest {
    @Test
    public void addTestCase6Test() {
        Response response = given()
                .body(testCasesEntities.testCaseType6)
                .log().body()
                .when()
                .pathParam("section_id", 2)
                .post(Endpoints.ADD_TESTCASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Assert.assertEquals(
                response.getBody().jsonPath().get("title")
                , testCasesEntities.testCaseType6.getTitle());
    }

    @Test
    public void addTestCase3Test() {
        Response response = given()
                .body(testCasesEntities.testCaseType3)
                .log().body()
                .when()
                .pathParam("section_id", 2)
                .post(Endpoints.ADD_TESTCASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Assert.assertEquals(
                response.getBody().jsonPath().get("refs")
                , testCasesEntities.testCaseType3.getReferences()
        );
    }

    @Test
    public void getTestCaseTest() {
        Response response = given()
                .when()
                .pathParam("case_id", 5)
                .get(Endpoints.GET_TESTCASE)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        TestCase actualUser = new Gson().fromJson(response.getBody().asString(), TestCase.class);

        Assert.assertEquals(actualUser, testCasesEntities.testCaseType6);
    }

    @Test
    public void updateTestCaseTest() {
        TestCase updateTestCase = TestCase.builder()
                .title(testCasesEntities.testCaseType3.getTitle())
                .title("Add new project")
                .type(6)
                .priority(1)
                .build();

        Response response = given()
                .body(updateTestCase)
                .when()
                .pathParam("case_id", 4)
                .post(Endpoints.UPDATE_TESTCASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Assert.assertEquals((int) response.getBody().jsonPath().get("type_id")
                , updateTestCase.getType());
    }

    @Test
    public void deleteTestCaseTest() {
        given()
                .when()
                .pathParam("case_id", 3)
                .post(Endpoints.DELETE_TESTCASE)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
