package baseEntities;

import configuration.ReadProperties;
import entities.MilestonesEntities;
import entities.ProjectsEntities;
import entities.TestCasesEntities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseAPITest {
    public ProjectsEntities projectsEntities;
    public MilestonesEntities milestonesEntities;
    public TestCasesEntities testCasesEntities;

    @BeforeTest
    public void setupAPI() {
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        projectsEntities = new ProjectsEntities();
        milestonesEntities = new MilestonesEntities();
        testCasesEntities = new TestCasesEntities();
    }
}
