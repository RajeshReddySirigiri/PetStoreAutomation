package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;

import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	@BeforeTest
	public void setUpData() {
		
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger=LogManager.getLogger(this.getClass());
		
		
		
		
		
	}
	
	@Test(priority=1)
	public void testPostUser() {
		logger.info("******* Creating users**********");
		Response response= UserEndPoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*******users Created**********");

		
	}
	
	@Test(priority=2)
	public void testGetUser() {
		
		logger.info("******* Reading user info **********");

		
		Response response= UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("******* User Info Displayed**********");

		
	}
	

	@Test(priority=3)
	public void testUpdateUser() {
		
		logger.info("******* Update user info**********");

		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response= UserEndPoints.updateUser(userpayload,this.userpayload.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		//check the data after update
		Response responseAfterUpdate= UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*******User Info Updated**********");

		
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		
		logger.info("******* Deleting user**********");

		Response response= UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******* User get deleted**********");

		
	}


}
