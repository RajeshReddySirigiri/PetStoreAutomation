package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	
	public static ResourceBundle getUrl() {
		
		ResourceBundle routes= ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		Response response=given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
						  .when()
						  	.post(getUrl().getString("post_Url"));
		
		return response;
		
		
	}

	public static Response readUser(String userName) {

		Response response = given()
								.pathParam("username", userName)
							.when()
								.get(getUrl().getString("get_Url"));

		return response;

	}

	public static Response updateUser(User payload,String userName) {

		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", userName)
								.body(payload)
							.when()
								.put(getUrl().getString("update_Url"));

		return response;

	}
	public static Response deleteUser(String userName) {

		Response response = given()
								.pathParam("username", userName)
							.when()
								.delete(getUrl().getString("delete_Url"));

		return response;

	}
	

}
