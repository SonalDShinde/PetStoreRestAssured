package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//This class is having only CRUD operations
public class UserEndPoint {

	public static Response createUser(User payload) {
		
		Response response = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.create_user);
		
		return response;
	}
	
	
	public static Response getUser(String userName) {
		
		
		Response response=given()
				.pathParam("username", userName)
				.when()
					.get(Routes.get_user);
		return response;
		
	}
	
	public static Response updateUser(String userName,User playload) {
		
		Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", userName)
					.body(playload)
					.when()
						.put(Routes.update_user);
		return response;
	}
	
	
	public static Response deleteUser(String userName) {
		
		Response response=given()
							.pathParam("username", userName)
						  .when()
						  	.delete(Routes.delete_user);
		return response;
		
	}
	
}
