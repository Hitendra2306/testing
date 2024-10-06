package stepdef;
import org.json.simple.JSONObject;
import org.testng.Assert;
import endpoints.storeEndpoints;
import helpers.storepayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class storestepdef extends storeEndpoints {
	storepayload order = new storepayload();
	private RequestSpecification request;
	private Response response;
	JSONObject ob;
	// ------------------------------------------------------------------------------------------------------------------placeorder-------------------------------------------------------------------------------//
	@Given("I have a valid order payload")
	public void i_have_a_valid_order_payload() {
		RestAssured.baseURI = uri;
		ob = new JSONObject(order.createOrderPayload(10, 1, 12));
	}
	@When("I send a POST request to the \\/store\\/order endpoint")
	public void i_send_a_post_request_to_the_store_order_endpoint() {
		request = RestAssured.given().log().all().header("api-key", "special-key")
				.header("Content-Type", "application/json").body(ob.toString());
		response = request.post(PLACE_ORDER);
	}
	@Then("the response status code for the store api should be {int} and the response should contain the placed order details")
	public void the_response_status_code_for_the_store_api_should_be_and_the_response_should_contain_the_placed_order_details(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// ------------------------------------------------------------------------------------------------------------------findorder-------------------------------------------------------------------------------//
	@Given("I have an existing order")
	public void i_have_an_existing_order() {
		RestAssured.baseURI = uri;
		request = RestAssured.given().log().all().header("api-key", "special-key")
				.header("Content-Type", "application/json");
	}
	@When("I send a GET request to the \\/store\\/order\\/\\{orderId) endpoint with ID {string}")
	public void i_send_a_get_request_to_the_store_order(String string) {
		response = request.get(getOrderEndpoint(string));
	}
	@Then("the response status code for the store api should be {int} and the response should contain the order details")
	public void the_response_status_code_for_the_store_api_should_be_and_the_response_should_contain_the_order_details(
			int int1) {

		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertTrue(response.getBody().jsonPath().get("id").equals(10));
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}

	// ------------------------------------------------------------------------------------------------------------------delete-------------------------------------------------------------------------------//


	@When("I send a DELETE request to the \\/store\\/order\\/\\{orderId) endpoint with ID {string}")
	public void i_send_a_delete_request_to_the_store_order(String string) {
		response = request.delete(getDeleteOrderEndpoint(string));
	}
	@Then("the response status code for the store api should be {int} and should confirm the order has been deleted")
	public void the_response_status_code_for_the_store_api_should_be_and_should_confirm_the_order_has_been_deleted(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");

	}

	// ------------------------------------------------------------------------------------------------------------------inventory-------------------------------------------------------------------------------//


	@Given("I have the base URI")
	public void i_have_the_base_uri() {
		RestAssured.baseURI = uri;
	}
	@When("I send a GET request to the \\/store\\/inventory endpoint")
	public void i_send_a_get_request_to_the_store_inventory_endpoint() {
		request = RestAssured.given().log().all().header("api-key", "special-key")
				.header("Content-Type", "application/json");
	}
	@Then("the response status code for the store api should be {int} and the response should contain the store inventory details")
	public void the_response_status_code_for_the_store_api_should_be_and_the_response_should_contain_the_store_inventory_details(
			int int1) {

		response = request.get(GET_INVENTORY);
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");

	}
}
