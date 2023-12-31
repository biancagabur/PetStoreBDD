package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import support.api.PetApi;
import support.api.UserApi;

public class Config {
    private UserApi userApi;
    private PetApi petApi;

    public Config(){
        userApi = new UserApi();
        petApi = new PetApi();
    }
    @Before
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath="/api";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", getToken())
                .setContentType(ContentType.JSON)
                .build();
    }

    private String getToken() {
        return "great access";
    }
    @After("@deleteAllUsers")
    public void deleteAllTheUsers(){
        userApi.deleteAllUsers();
    }
    @After("@DeleteExtraPets")
    public void deleteExtraPets(){
        petApi.deleteExtraPets("available");
    }
}
