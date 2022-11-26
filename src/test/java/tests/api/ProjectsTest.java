package tests.api;

import baseEntities.BaseAPITest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectsTest extends BaseAPITest {

    @Test
    public void addProjectTest() {
        Response response = given()
                .body(projectsEntities.projectBuilderType1)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Assert.assertEquals(
                response.getBody().jsonPath().get("name")
                , projectsEntities.projectBuilderType1.getName());
    }

}
