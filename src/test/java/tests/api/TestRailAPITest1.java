package tests.api;

import baseEntities.BaseAPITest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
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
        Project expectedProject = Project.builder()
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
                        expectedProject.getName(),
                        expectedProject.getAnnouncement(),
                        expectedProject.isShowAnnouncement(),
                        expectedProject.getTypOfProject()
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
        Project expectedProject = Project.builder()
                .name("Project LLL")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", expectedProject.getName());
        jsonMap.put("suite_mode", expectedProject.getTypOfProject());

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
        Project expectedProject = Project.builder()
                .name("Project AAA")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();

        given()
                .body(expectedProject, ObjectMapperType.GSON)
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
        Project expectedProject = Project.builder()
                .name("Project BBB")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();

        projectID = given()
                .body(expectedProject, ObjectMapperType.GSON)
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
        Project expectedProject = Project.builder()
                .name("Project CCC")
                .announcement("LOREM IPSUM")
                .isShowAnnouncement(true)
                .typOfProject(1)
                .build();

        Response response = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Assert.assertEquals(
                response.getBody().jsonPath().get("name")
                , expectedProject.getName());
    }

    @Test(dependsOnMethods = "addProject4Test")
    public void updateProject1Test() {
        String endpoint = "index.php?/api/v2/update_project/{project_id}";
        Project updateProject = Project.builder()
                .name("New Project BBB")
                .build();


        given()
                .body(updateProject, ObjectMapperType.GSON)
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
