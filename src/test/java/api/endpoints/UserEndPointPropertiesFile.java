package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//This class is having only CRUD operations
public class UserEndPointPropertiesFile {

	//This method is to URL from properties file
	static ResourceBundle getURL(){
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");// properties file name === routes
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		String create_user =  getURL().getString("create_user");
		
		Response response = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(create_user);
		
		return response;
	}
	
	
	public static Response getUser(String userName) {
		
		String get_user =getURL().getString("get_user");
		
		Response response=given()
				.pathParam("username", userName)
				.when()
					.get(get_user);
		return response;
		
	}
	
	public static Response updateUser(String userName,User playload) {
		
		String update_user = getURL().getString("update_user");
		
		Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", userName)
					.body(playload)
					.when()
						.put(update_user);
		return response;
	}
	
	
	public static Response deleteUser(String userName) {
		
		String delete_user = getURL().getString("delete_user");
		Response response=given()
							.pathParam("username", userName)
						  .when()
						  	.delete(delete_user);
		return response;
		
	}
	
}
