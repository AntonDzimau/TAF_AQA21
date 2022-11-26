package tests.api;

import baseEntities.BaseAPITest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRailAPITest1 extends BaseAPITest {
    private int projectID;

    @Test
    public void addProject1Test() {
        String endpoint = "index.php?/api/v2/add_project";
        ProjectBuilder expectedProjectBuilder = ProjectBuilder.builder()
                .name("Project XXXX")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();
        given()
                .body(String.format("{\n" +
                                "  \"name\": \"%s\",\n" +
                                "  \"announcement\": \"%s\",\n" +
                                "  \"show_announcement\": %b,\n" +
                                "  \"suite_mode\" : %d\n" +
                                "}",
                        expectedProjectBuilder.getName(),
                        expectedProjectBuilder.getAnnouncement(),
                        expectedProjectBuilder.isShowAnnouncement(),
                        expectedProjectBuilder.getTypOfProject()
                ))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject2Test() {
        String endpoint = "index.php?/api/v2/add_project";
        ProjectBuilder expectedProjectBuilder = ProjectBuilder.builder()
                .name("Project LLL")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", expectedProjectBuilder.getName());
        jsonMap.put("suite_mode", expectedProjectBuilder.getTypOfProject());

        given()
                .body(jsonMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3Test() {
        String endpoint = "index.php?/api/v2/add_project";
        ProjectBuilder expectedProjectBuilder = ProjectBuilder.builder()
                .name("Project AAA")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();

        given()
                .body(expectedProjectBuilder, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject4Test() {

        String endpoint = "index.php?/api/v2/add_project";
        ProjectBuilder expectedProjectBuilder = ProjectBuilder.builder()
                .name("Project BBB")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();

        projectID = given()
                .body(expectedProjectBuilder, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println(projectID);
    }

    @Test
    public void addProject5Test() {
        String endpoint = "index.php?/api/v2/add_project";
        ProjectBuilder expectedProjectBuilder = ProjectBuilder.builder()
                .name("Project CCC")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();

        Response response = given()
                .body(expectedProjectBuilder, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Assert.assertEquals(
                response.getBody().jsonPath().get("name")
                , expectedProjectBuilder.getName());
    }

    @Test(dependsOnMethods = "addProject4Test")
    public void updateProject1Test() {
        String endpoint = "index.php?/api/v2/update_project/{project_id}";
        ProjectBuilder updateProjectBuilder = ProjectBuilder.builder()
                .name("New Project BBB")
                .build();


        given()
                .body(updateProjectBuilder, ObjectMapperType.GSON)
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
