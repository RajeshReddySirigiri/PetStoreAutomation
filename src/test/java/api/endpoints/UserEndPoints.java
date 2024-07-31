package api.endpoints;
import api.payloads.User;
import static io.restassured.RestAssured.*;


import io.restassured.http.ContentType;
import io.restassured.response.Response;


//Created to perform Create, get, update, delete request for user API
public class UserEndPoints {
	
	public static Response createUser(User payload) {
		
		Response response=given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
						  .when()
						  	.post(Routes.post_Url);
		
		return response;
		
		
	}

	public static Response readUser(String userName) {

		Response response = given()
								.pathParam("username", userName)
							.when()
								.get(Routes.get_Url);

		return response;

	}

	public static Response updateUser(User payload,String userName) {

		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", userName)
								.body(payload)
							.when()
								.put(Routes.update_Url);

		return response;

	}
	public static Response deleteUser(String userName) {

		Response response = given()
								.pathParam("username", userName)
							.when()
								.delete(Routes.delete_Url);

		return response;

	}
	

}
