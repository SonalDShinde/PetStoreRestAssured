package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPointPropertiesFile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTestProperties {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		userPayload = new  User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	@Test(priority = 1)
	public void testCreateUser() {
		
		
		Response response = UserEndPointPropertiesFile.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 2)
	public void testGetUserByName() {
		
		Response response = UserEndPointPropertiesFile.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUserByName() {
		
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		Response response = UserEndPointPropertiesFile.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		
		//Checking data after update 
		
		Response response2 = UserEndPointPropertiesFile.getUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 4)
	public void deleteUserByName() {
		
		Response response = UserEndPointPropertiesFile.deleteUser(this.userPayload.getUsername());
		//response.then().log().all();
		response.then().log().body().statusCode(200);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
