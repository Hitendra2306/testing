package restassured_handson;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import io.restassured.http.Header;

public class E {

	@Test
	public void E_Put() throws IOException {
		String data = "";
		data = new String(
				Files.readAllBytes(Paths.get("tokenfile.txt")));


		Header authead= new Header("Authorization","Bearer " + data);
		baseURI="http://restapi.adequateshop.com/api/users/11142";
		String reqbody = "{\n"
				+ "             \"id\": 229943,\n"
				+ "             \"name\": \"Developer\",\n"
				+ "             \"email\": \"geetha@gmail.com\",\n"
				+ "}";
		given().relaxedHTTPSValidation()
		.header(authead)
		.contentType("application/json; charset=utf-8")
		.body(reqbody)
		.when()
		.put()
		.then().log().all().assertThat().statusCode(405);
	}

}
