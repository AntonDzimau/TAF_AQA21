package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {
    public ProjectBuilder addProject(ProjectBuilder newProjectBuilder) {
        return given()
                .body(newProjectBuilder, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .extract().as(ProjectBuilder.class, ObjectMapperType.GSON);
    }

    public Response addProjectAndGetResponse(ProjectBuilder newProjectBuilder) {
        Response response = given()
                .body(newProjectBuilder, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT);
        newProjectBuilder.setId(response.getBody().jsonPath().get("id"));
        System.out.println("ID of new project is ..." + newProjectBuilder.getId());
        return response;
    }

    public ProjectBuilder[] getAllProjects() {
        Response response = given()
                .get(Endpoints.GET_ALL_PROJECTS);

        return gson.fromJson(response.getBody().asString(), ProjectBuilder[].class);
    }

    public void getProject() {

    }

}
