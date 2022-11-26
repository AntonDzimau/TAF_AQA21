package tests.api;

import baseEntities.BaseAPITest;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MilestonesTest extends BaseAPITest {
    @Test
    public void addMilestoneTest() {
        given()
                .body(milestonesEntities.milestone1)
                .log().body()
                .when()
                .pathParam("project_id", 3)
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .body("name", is(milestonesEntities.milestone1.getName()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getMilestonesTest() {
        given()
                .when()
                .pathParam("project_id", 3)
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().status()
                .log().body()
                .body("milestones.get(0).name", is(milestonesEntities.milestone1.getName()))
                .body("milestones.get(0).description", equalTo(milestonesEntities.milestone1.getDescription()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void updateMilestoneTest() {
        Milestone updateMilestone = Milestone.builder()
                .name(milestonesEntities.milestone1.getName())
                .description("This is a new description of milestone")
                .build();

        given()
                .body(updateMilestone)
                .pathParam("milestone_id", 3)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .body("description", equalTo(updateMilestone.getDescription()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deleteMilestoneTest() {
        given()
                .when()
                .pathParam("milestone_id", 3)
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
