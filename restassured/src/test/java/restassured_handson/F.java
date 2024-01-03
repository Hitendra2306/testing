package restassured_handson;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class F {

	@Test
	public void F_delete() {
		baseURI="http://restapi.adequateshop.com/api/users/11143";
		given().relaxedHTTPSValidation()
		.contentType("application/json; charset=utf-8")
		.when()
		.delete()
		.then().log().all().assertThat().statusCode(405);

	}

}
