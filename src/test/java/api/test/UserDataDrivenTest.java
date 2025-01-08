package api.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserDataDrivenTest {

	public Logger logeer;
	
	@Test(priority = 1,dataProvider = "Data", dataProviderClass = DataProviders.class )
	public void testGetUserExcel(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph) {
		
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setFirstName(fname);
		userPayload.setUsername(userName);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoint.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String userName) {
		
		Response response = UserEndPoint.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}
