package api.test;

import org.testng.Assert;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;


public class DataDrivenTests {
	
	
	@Test(priority=0,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostusers(String UserID,String username,String fName,String lName,String userEmail,String Password,String phone) {
		
		User userpayload=new User();
		
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(username);
		userpayload.setFirstName(fName);
		userpayload.setLastName(lName);
		userpayload.setEmail(userEmail);
		userpayload.setPassword(Password);
		userpayload.setPhone(phone);
		
		Response response= UserEndPoints.createUser(userpayload);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=1,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteusers(String username) {
		
		
		Response response= UserEndPoints.deleteUser(username);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
