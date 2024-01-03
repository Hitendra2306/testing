package restassured_handson;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.testng.annotations.Test;
public class B {
	String token="";

	//File file=new File("tokenfile.txt");



	@Test

	public void B_post() throws IOException

	{

		baseURI="http://restapi.adequateshop.com/api/authaccount/login";


		String path="data.json";

		File jsonfile=new File(path);

		token=given().relaxedHTTPSValidation()

				.contentType("application/json; charset=utf-8")

				.body(jsonfile)

				.when()

				.post().then().log().all().assertThat()

				.statusCode(200).extract().response().jsonPath()

				.get("data.Token");



		FileWriter write=new FileWriter("tokenfile.txt");

		PrintWriter type=new PrintWriter(write);

		type.println(token);

		type.close();


		System.out.println(token);



	}
}
