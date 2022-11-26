package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.MilestoneBuilder;
import models.ProjectBuilder;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class MilestoneAdapter extends BaseAdapter {
    public ProjectBuilder addMilestone(MilestoneBuilder newMilestone) {
        return given()
                .body(newMilestone, ObjectMapperType.GSON)
                .log().body()
                .when()
                //.pathParam("project_id", )
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .extract().as(ProjectBuilder.class, ObjectMapperType.GSON);
    }
//возвращает не объект Проекта, а респонс, то есть ДО десериализации
    public Response addProjectAndGetResponse(ProjectBuilder newProjectBuilder) {
        return given()
                .body(newProjectBuilder, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT);
    }

    public ProjectBuilder[] getAllProjects() {
        Response response = given()
                .get(Endpoints.GET_ALL_PROJECTS);

        return gson.fromJson(response.getBody().asString(), ProjectBuilder[].class);
    }

    public void getProject() {

    }

}
