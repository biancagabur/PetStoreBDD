package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.api.UserApi;
import support.domain.User;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStepDefinitions {
    private User expectedUser;
    private UserApi userApi;

    public UserStepDefinitions(){
        userApi = new UserApi();
    }

    @When("I create a user")
    public void iCreateAUser() {
        expectedUser = User.builder().build();
        userApi.createUser(expectedUser);

    }

    @Then("the created user was stored")
    public void theCreatedUserWasStored() {
        String actualUsername = userApi.getUsername(expectedUser);
        assertThat(actualUsername,is(expectedUser.getUsername()));
    }


}
