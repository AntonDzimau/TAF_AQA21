package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {
//возвращает объект Проекта
    public Project addProject(Project newProject) {
        return given()
                .body(newProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .extract().as(Project.class, ObjectMapperType.GSON);
    }
//возвращает не объект Проекта, а респонс, то есть ДО десериализации
    public Response addProjectAndGetResponse(Project newProject) {
        return given()
                .body(newProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT);
    }

    public Project[] getAllProjects() {
        Response response = given()
                .get(Endpoints.GET_ALL_PROJECTS);

        return gson.fromJson(response.getBody().asString(), Project[].class);
    }

    public void getProject() {

    }

}
