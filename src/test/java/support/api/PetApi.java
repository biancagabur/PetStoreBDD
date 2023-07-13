package support.api;

import support.domain.Pet;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetApi {
    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "v3/pet/findByStatus?status={status}";

    public List<Pet> getPetByStatus(String status){
       return given()
            .pathParam("status",status)
        .when()
            .get(FIND_PETS_BY_STATUS_ENDPOINT)
        .then()
            .extract()
            .jsonPath().getList("", Pet.class);
    }
}
