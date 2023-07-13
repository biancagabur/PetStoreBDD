package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.api.PetApi;
import support.domain.Pet;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

public class PetStepDefinitions {
    private PetApi petApi;
    private List<Pet> actualPets;
    public PetStepDefinitions(){
        petApi = new PetApi();
    }
    @Given("that I have available pets")
    public void thatIHaveAvailablePets() {
//        Pet pet = Pet.builder().build();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(pet);
//        System.out.println(json);
    }

    @When("I search for all {word} pets")
    public void iSearchForAllAvailablePets(String status) {
        actualPets = petApi.getPetByStatus(status);
        System.out.println("anything");
    }

    @Then("I receive a list of available pets")
    public void iReceiveAListOfAvailablePets() {
        assertThat(actualPets,is(not(empty())));
    }
}
