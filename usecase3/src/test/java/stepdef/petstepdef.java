package stepdef;
import java.io.File;
import org.json.simple.JSONObject;
import org.testng.Assert;
import endpoints.petEndpoints;
import helpers.petPayload;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class petstepdef extends petEndpoints {
	petPayload pet = new petPayload();
	private RequestSpecification request;
	private Response response;
	JSONObject ob;
	// -------------------------------------------------------------------------------newpet-----------------------------------------------------------------------------------------------------//
	@Given("I have a valid pet payload")
	public void i_have_a_valid_pet_payload() {
		RestAssured.baseURI = BASE_URL;
		ob = new JSONObject(pet.createPetPayload("Labrador", "available"));
		request = RestAssured.given().log().all().header("api-key", "special-key")
				.header("Content-Type", "application/json").body(ob.toString());
	}
	@When("I send a POST request to the \\/pet endpoint")
	public void i_send_a_post_request_to_the_pet_endpoint() {
		response = request.post(CREATE_PET);
	}
	@Then("the response status code should b be {int} and contains the created pet details")
	public void the_response_status_code_should_b_be_and_contains_the_created_pet_details(int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// -------------------------------------------------------------------------------upadte-----------------------------------------------------------------------------------------------------//
	@Given("I have an existing pet with ID {string} for updation")
	public void i_have_an_existing_pet_with_id_for_updation(String string) {
		RestAssured.baseURI = BASE_URL;
		ob = new JSONObject(pet.updatePetPayload("Labrador", "pending"));
	}
	@And("I have an updated pet payload")
	public void i_have_an_updated_pet_payload() {
		request = RestAssured.given().log().all().header("api-key", "special-key")
				.header("Content-Type", "application/json").body(ob.toString());
	}
	@When("I send a PUT request to the \\/pet endpoint")
	public void i_send_a_put_request_to_the_pet_endpoint() {
		response = request.put(UPDATE_PET);
	}
	@Then("the response status code should ould be {int} for the update and contains the updated pet details")
	public void the_response_status_code_should_ould_be_for_the_update_and_contains_the_updated_pet_details(int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertTrue(response.getBody().jsonPath().get("status").equals("pending"));
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// -------------------------------------------------------------------------------deelte-----------------------------------------------------------------------------------------------------//
	@Given("I have an existing pet with ID {string} for deletion")
	public void i_have_an_existing_pet_with_id_for_deletion(String string) {
		RestAssured.baseURI = BASE_URL;
	}
	@When("I send a DELETE request to the \\/pet\\/\\{petId} endpoint")
	public void i_send_a_delete_request_to_the_pet_endpoint() {
		request = RestAssured.given().log().all().header("api-key", "special-key").header("Content-Type",
				"application/json");
		response = request.delete(getDeletePetEndpoint("20"));
	}
	@Then("the response status code should be {int} for the deleted pet")
	public void the_response_status_code_should_be_for_the_deleted_pet(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// -----------------------------------------------------------------------------------------upload-----------------------------------------------------------------------------------------------------//
	@Given("I have an existing pet with ID {string} for uploading image")
	public void i_have_an_existing_pet_with_id_for_uploading_image(String string) {
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given().log().all().header("api-key", "special-key").contentType("multipart/form-data")
				.multiPart("id", 20);
	}
	@And("I have a valid image file")
	public void i_have_a_valid_image_file() {
		request.multiPart("file",
				new File("C:\\Users\\Windows\\Pictures\\Screenshots\\Screenshot 2024-01-05 211023.png"), "text/html");
	}
	@When("I send a POST request to the \\/pet\\/\\{petId}\\/uploadImage endpoint")
	public void i_send_a_post_request_to_the_pet_upload_image_endpoint() {
		response = request.post(getUploadPetImageEndpoint("20"));
	}
	@Then("the response status code should be {int} and the response should contain the uploaded image details")
	public void the_response_status_code_should_be_and_the_response_should_contain_the_uploaded_image_details(
			int int1) {

		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");

	}

	// -----------------------------------------------------------------------------------------get-----------------------------------------------------------------------------------------------------//

	@Given("I have an existing pet with ID for get")
	public void i_have_an_existing_pet_with_id_for_get() {
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given().log().all().header("api-key", "special-key");


	}
	@When("I send a get request to the \\/pet\\/\\{petId} endpoint")
	public void i_send_a_get_request_to_the_pet_endpoint() {


		response =request.get(getPetEndpoint("20"));
	}
	@Then("the response status code should be {int} for the pet request and the response should confirm the pet request is succesfull")
	public void the_response_status_code_should_be_for_the_pet_request_and_the_response_should_confirm_the_pet_request_is_succesfull(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}

	// -----------------------------------------------------------------------------------------get-----------------------------------------------------------------------------------------------------//


	@When("I send a request to the \\/pet\\/findbystatus endpoint")
	public void i_send_a_request_to_the_pet_findbystatus_endpoint() {
		request.queryParam("status", "available");
		response =request.get(FIND_PET);

	}
	@Then("the response status code should be {int} for the pet request and the response should list all the information")
	public void the_response_status_code_should_be_for_the_pet_request_and_the_response_should_list_all_the_information(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
}
