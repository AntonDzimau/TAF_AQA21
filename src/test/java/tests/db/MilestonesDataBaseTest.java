package tests.db;

import baseEntities.BaseAPITest;
import dbEntities.ProjectsTable;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class MilestonesDataBaseTest extends BaseAPITest {

    @Test
    public void addNewMilestoneWithDBTest() {
        Response response = given()
                .body(projectsEntities.projectBuilderType1)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .body("name", is(projectsEntities.projectBuilderType1.getName()))
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        projectsEntities.projectBuilderType1.setId(response.getBody().jsonPath().get("id"));

        System.out.println("ID of new project is ..." + projectsEntities.projectBuilderType1.getId());

        ProjectsTable projectsTable = new ProjectsTable(dataBaseService);
        //projectsTable.dropTable();
        projectsTable.createProjectsTable();

        projectsTable.addProject(projectsEntities.projectBuilderType1);
    }


}
