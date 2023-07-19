package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import support.api.PetApi;
import support.api.StoreApi;
import support.domain.Order;
import support.domain.Pet;
import support.domain.builders.OrderBuilder;

import static org.hamcrest.CoreMatchers.is;

public class OrderStepDefinitions {

    PetApi petApi;
    Pet expectedPet;
    StoreApi storeApi;
    Order expectedOrder;

    public OrderStepDefinitions(){
        petApi=new PetApi();
        storeApi = new StoreApi();
    }
    @Given("I have a pet {word}")
    public void iHaveAPetAvailable(String status) {
        Pet pet = Pet.builder()
                .id(333)
                .status(status)
                .build();
        expectedPet = petApi.createPet(pet);
    }

    @When("I order that pet")
    public void iOrderThatPet() {
        Order order = new OrderBuilder().withId(888).withPetId(expectedPet.getId()).build();
        expectedOrder = storeApi.createOrder(order);
    }

    @Then("the order is approved")
    public void theOrderIsApproved() {
        Response actualOrderResponse = storeApi.getOrder(expectedOrder.getId());
        actualOrderResponse.then().body(
                "id" ,is(expectedOrder.getId()),
                "petId", is(expectedPet.getId()),
                "quantity", is(expectedOrder.getQuantity()),
                "status", is(expectedOrder.getStatus())
        );
    }
}
