package stepdef;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import endpoints.userEndpoints;
import helpers.usepayload;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
public class userstepdef extends userEndpoints {
	usepayload userload = new usepayload();
	private RequestSpecification request;
	private Response response;
	JSONObject ob;
	@Given("I have a valid user payload for Create list of users")
	public void i_have_a_valid_user_payload_for_create_list_of_users() {
		RestAssured.baseURI = BASE_URL;
		ob = new JSONObject(userload.createUserPayload("jojoj", "123333"));
		List<Object> li = new ArrayList<Object>();
		li.add(ob);
		System.out.println(ob);
		request = RestAssured.given().log().all().header("api-key", "special-key")
				.header("Content-Type", "application/json").body(li.toString());
	}
	@When("I send a POST request to the \\/user\\/createwithlist endpoint")
	public void i_send_a_post_request_to_the_user_createwithlist_endpoint() {
		response = request.post(Create_User_withlist);
	}
	@Then("the response status code should be {int} for the list of users creation contains the created list of user details")
	public void the_response_status_code_should_be_for_the_list_of_users_creation_contains_the_created_list_of_user_details(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// ---------------------------------------------------------------------------step1over----------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------step2----------------------------------------------------------------------------//
	@Given("I have an existing user")
	public void i_have_an_existing_user() {
		RestAssured.baseURI = BASE_URL;
	}
	@When("I send a GET request to the \\/user\\/\\{username} endpoint with username {string}")
	public void i_send_a_get_request_to_the_user_endpoint_with_username(String string) {
		request = RestAssured.given().log().all().header("api-key", "special-key").header("Content-Type",
				"application/json");
		response = request.get(getUserEndpoint(string));
	}
	@Then("the response status code should be {int} and the response should contain the user by the username details")
	public void the_response_status_code_should_be_and_the_response_should_contain_the_user_by_the_username_details(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// ---------------------------------------------------------------------------step2over----------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------step3----------------------------------------------------------------------------//
	@And("I have an updated user payload for the updation")
	public void i_have_an_updated_user_payload_for_the_updation() {
		ob = new JSONObject(userload.createUserPayload("jojoj", "123333"));
		System.out.println(ob);
		request = RestAssured.given().log().all().header("api-key", "special-key")
				.header("Content-Type", "application/json").body(ob.toString());
	}
	@When("I send a PUT request to the \\/user\\/\\{username} endpoint with username {string}")
	public void i_send_a_put_request_to_the_user_endpoint_with_username(String string) {
		response = request.put(getUpdateUserEndpoint(string));
	}
	@Then("the response status code should be {int} and the response should contain the updated user details")
	public void the_response_status_code_should_be_and_the_response_should_contain_the_updated_user_details(int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// ---------------------------------------------------------------------------step3over----------------------------------------------------------------------------//
	// -------------------------------------------------------------------------------step4----------------------------------------------------------------------------//
	@When("I send a DELETE request to the \\/user\\/\\{username} endpoint with username {string}")
	public void i_send_a_delete_request_to_the_user_endpoint_with_username(String string) {
		request = RestAssured.given().log().all().header("api-key", "special-key").header("Content-Type",
				"application/json");
		response = request.get(getDeleteUserEndpoint(string));
	}
	@Then("the response status code should be {int} for the deletion and the response should confirm the user has been deleted")
	public void the_response_status_code_should_be_for_the_deletion_and_the_response_should_confirm_the_user_has_been_deleted(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// -------------------------------------------------------------------------------step5----------------------------------------------------------------------------//
	@Given("I have valid login credentials")
	public void i_have_valid_login_credentials() {
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given().log().all().header("api-key", "special-key").header("Content-Type",
				"application/json");
	}
	@When("I send a GET request to the \\/user\\/login endpoint with \\(username: {string}, password: {string})")
	public void i_send_a_get_request_to_the_user_login_endpoint_with_username_password(String string, String string2) {
		request.queryParam("username", string);
		request.queryParam("password", string2);
		response = request.get(LOGIN_USER);
	}
	@Then("the response status code should be {int} for the login and the response should contain the users session information@")
	public void the_response_status_code_should_be_for_the_login_and_the_response_should_contain_the_users_session_information(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// -------------------------------------------------------------------------------step6----------------------------------------------------------------------------//
	@Given("I am a logged-in user")
	public void i_am_a_logged_in_user() {
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given().log().all().header("api-key", "special-key").header("Content-Type",
				"application/json");
	}
	@When("I send a GET request to the \\/user\\/logout endpoint")
	public void i_send_a_get_request_to_the_user_logout_endpoint() {
		response = request.get(LOGOUT_USER);
	}
	@Then("the response status code should be {int} for the logout and the response should confirm the user has been logged out")
	public void the_response_status_code_should_be_for_the_logout_and_the_response_should_confirm_the_user_has_been_logged_out(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
	// -------------------------------------------------------------------------------step7---------------------------------------------------------------------------//
	@Given("I have a valid user payload")
	public void i_have_a_valid_user_payload() {
		RestAssured.baseURI = BASE_URL;
		ob = new JSONObject(userload.createUserPayload("jojoj", "123333"));

		System.out.println(ob);
		request = RestAssured.given().log().all().header("api-key", "special-key")
				.header("Content-Type", "application/json").body(ob.toString());
	}
	@When("I send a POST request to the \\/user endpoint")
	public void i_send_a_post_request_to_the_user_endpoint() {
		response = request.post(Create_USER);

	}
	@Then("the response status code should be {int} for the new user creation and the response should contain the created user details")
	public void the_response_status_code_should_be_for_the_new_user_creation_and_the_response_should_contain_the_created_user_details(
			int int1) {
		System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(int1, response.getStatusCode());
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}

	// -------------------------------------------------------------------------------step8---------------------------------------------------------------------------//

	@When("I send a POST request to the \\/user\\/createwitharray endpoint")
	public void i_send_a_post_request_to_the_user_createwitharray_endpoint() {
		response = request.post(Create_User_witharray);

	}
}
