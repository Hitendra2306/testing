package restassured_handson;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
public class A {
	@Test

	public void A_post()

	{

		baseURI="http://restapi.adequateshop.com/api/authaccount/registration";


		String path="data.json";

		File jsonfile=new File(path);

		given().relaxedHTTPSValidation().

		contentType("application/json; charset=utf-8").

		body(jsonfile).when().post().then().log().all().assertThat().statusCode(200);


	}
}
