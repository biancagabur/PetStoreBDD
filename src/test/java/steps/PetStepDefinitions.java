package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
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
    private Response actualPetResponse;

    public PetStepDefinitions(){
        petApi = new PetApi();
    }
    @Given("that I have {word} pets")
    public void thatIHaveAvailablePets(String status) {
//        Pet pet = Pet.builder().build();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(pet);
//        System.out.println(json);
    }

    @When("I search for all {word} pets")
    public void iSearchForAllAvailablePets(String status) {
        actualPetResponse = petApi.getPetResponseByStatus(status);
        actualPets = actualPetResponse.body().jsonPath().getList("", Pet.class);
    }

    @Then("I receive a list of {word} pets")
    public void iReceiveAListOfAvailablePets(String status) {
        actualPetResponse
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "size()",is(actualPets.size()),
                        "findAll { it.status == '"+ status +"'}.size()", is(actualPets.size())
                );
        assertThat(actualPets,is(not(empty())));
    }

    @Given("that I do not have any {word} pets")
    public void thatIDoNotHaveAnySoldPets(String status) {
        petApi.deleteAllPetsByStatus(status);
    }

    @Then("I receive a list of pets of size {} pets")
    public void iReceiveAListOfPetsWithSize(int quantity) {
        assertThat(actualPets.size(),is(quantity));
    }

    @Then("I receive a list of pets of size {int} pets {word}")
    public void iReceiveAListOfPetsOfSizePetsAvailable(int quantity, String status) {
        actualPetResponse
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "size()", is(quantity),
                        "findAll {it.status == '" + status + "'}.size()", is(quantity)
                );
    }

    @And("{int} pets have the name {word}")
    public void petsHaveTheNameLion(int quantity, String name) {
        actualPetResponse.then()
                .body("findAll {it.name.contains('"+name+"')}.size()", is(quantity));

    }
}
