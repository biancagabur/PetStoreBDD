package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import support.domain.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class UserStepDefinitions {
    private User user;
    private static final String CREATE_USER_ENDPOINT = "/v3/user";
    private static final String USER_ENDPOINT = "/v3/user/{name}";

    @When("I create a user")
    public void iCreateAUser() {
        user = User.builder().build();
        given().
                body(user).
                when().
                post(CREATE_USER_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK);

    }

    @Then("the created user was stored")
    public void theCreatedUserWasStored() {
        given().pathParam("name", user.getUsername()).
                when().
                get(USER_ENDPOINT).
                then()
                .statusCode(HttpStatus.SC_OK)
                .body("username", is(user.getUsername()));
    }
}
