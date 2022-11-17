package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.io.SessionOutputBuffer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ReqresAPITest {
    @Test
    public void
    simpleStepByStepAPITest() {
        //Setup RestAssured
        RestAssured.baseURI = "https://reqres.in";

        //Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        //Setup request object
        RequestSpecification httpRequest = given();

        //Setup response object
        Response response = httpRequest.request(Method.GET, endpoint);

        // Get Response Status Code

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        //Get response body
        String responseBody = response.getBody().asPrettyString();
        System.out.println(responseBody);
    }

    @Test
    public void simpleShortAPITest(){
        //Setup RestAssured
        RestAssured.baseURI = "https://reqres.in";

        //Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
