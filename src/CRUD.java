



import org.testng.Assert;

import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class CRUD {


	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		 Response response = given()
				 .log()
				 .all()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/posts") 
	                .then()
	                .extract().response();
		 System.out.println(response);
		 System.out.println(response.statusCode());
		 System.out.println(response.jsonPath().getString("title[1]"));
	       Assert.assertEquals(200, response.statusCode());
	        Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));

	}

	
}
