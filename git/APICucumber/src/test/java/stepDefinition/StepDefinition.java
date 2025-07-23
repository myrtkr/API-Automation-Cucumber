package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{
	RequestSpecification request;
	ResponseSpecification responseSpecifications;
	Response response;
	static String placeID;
	TestDataBuild data = new TestDataBuild();
	
	
	TestDataBuild addplacePayload =new TestDataBuild();
	
	@Given("Add Place API payload with {string} {string} {string}")
	public void Add_Place_API(String name, String language,String Address ) throws IOException {
	

		request = given().log().all().spec(requestSpecification()).body(addplacePayload.addPlacePayload(name, language, Address));
		
	}
	@When("User call {string} with {string} http request")
	public void post_http_request(String resource, String httpMethod) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		responseSpecifications=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(httpMethod.equalsIgnoreCase("Post"))
		response = request.when().log().all().post(resourceAPI.getResource());
		else if(httpMethod.equalsIgnoreCase("Get"))
				responseSpecifications=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = request.when().log().all().get(resourceAPI.getResource());
	}
	@Then("The API call got success with status code {int}")
	public void Api_call_received_success(Integer status) {
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@And("{string} in response body is {string}")
	public void status_OK_in_response_body(String key, String expectedValue) {
		
		Assert.assertEquals(getJson(response, key), expectedValue);
	}
	@And("Verify place-Id created maps to {string} using {string}")
	public void verifyPlaceID(String expectedname, String resourse) throws IOException {	
		placeID=getJson(response, "place_id");
		request=given().spec(requestSpecification()).queryParam("place_id",placeID );
		post_http_request(resourse, "Get");
		String actualname=getJson(response, "name");
		Assert.assertEquals(actualname,expectedname);
		
	}
	
	@Given("Delete Place API payload with {string}")
	public void deletePlace() {
		
		request=given().log().all().spec(request).body(data.deletePlacePayload(placeID));
		
	}
	

	
}
