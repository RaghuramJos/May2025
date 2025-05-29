package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.BaseService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	public void TestLogin_old()
	{
		
		/*
		RestAssured.baseURI = "http://64.227.160.186:8080";

		RequestSpecification a= RestAssured.given();
		RequestSpecification b = a.header("content-type", "application/json");
		RequestSpecification c = b.body("{\"username\": \"testerram\", \"password\": \"At@12345\"}");
		Response d = c.post("/api/auth/login");
		*/

/*		Response res= RestAssured.given()
				.baseUri("http://64.227.160.186:8080")
				.header("content-type", "application/json")
				.body("{\"username\": \"testerram\", \"password\": \"At@12345\"}")
				.post("/api/auth/login");
		
		System.out.println(res.asPrettyString());
		Assert.assertEquals(res.getStatusCode(), 200);
*/		
	}
	
	public void loginTest_old2() {
		AuthService authService = new AuthService();
		//Response s = authService.login("{\"username\": \"TesterRam\",\"password\": \"At@12345\"}");
		//System.out.println(s.asPrettyString());
	}
	
	@Test
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("TesterRam", "At@12345");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		
		LoginResponse loginReponse = response.as(LoginResponse.class);
		System.out.println(loginReponse.getEmail());
		System.out.println(loginReponse.getToken());

		
	}

}
