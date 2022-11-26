package baseEntities;

import adapters.ProjectAdapter;
import configuration.ReadProperties;
import dbEntities.ProjectsTable;
import entities.MilestonesEntities;
import entities.ProjectsEntities;
import entities.TestCasesEntities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

import static io.restassured.RestAssured.given;

public class BaseAPITest {
   protected DataBaseService dataBaseService;

    public ProjectsEntities projectsEntities;
    public MilestonesEntities milestonesEntities;
    public TestCasesEntities testCasesEntities;

    public ProjectAdapter projectAdapter;

    public ProjectsTable projectsTable;

    @BeforeTest
    public void setupAPI() {
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        dataBaseService = new DataBaseService();

        projectsEntities = new ProjectsEntities();
        milestonesEntities = new MilestonesEntities();
        testCasesEntities = new TestCasesEntities();

        projectAdapter = new ProjectAdapter();

        projectsTable = new ProjectsTable(dataBaseService);
    }

    @AfterTest
    public void tearDown(){
        dataBaseService.closeConnection();
    }
}
