package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification requestSpecifications;
	
	
	
	
	public RequestSpecification requestSpecification() throws IOException {
	
	if(requestSpecifications==null)	{
		
		//PrintStream log= new PrintStream( new FileOutputStream("logging.txt"));
		
		requestSpecifications = new RequestSpecBuilder()
				.setBaseUri(getGlobalValues("baseUrl"))
				.addQueryParam("key", "qaclick123")
				//.addFilter(RequestLoggingFilter.logRequestTo(log))
				//.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return requestSpecifications;
	}
	return requestSpecifications;
	}
	
	public static String getGlobalValues(String key) throws IOException {
		
		Properties values=new Properties();
		FileInputStream fileInput = new FileInputStream("/Users/ruchi/eclipse-workspace/APICucumber/src/test/java/resources/global.properties");
		values.load(fileInput);
		values.getProperty(key);
		return values.getProperty(key);
		
	}
	
	public String getJson(Response response, String key) {
		
		String responseJson=response.asString();
		JsonPath js = new JsonPath(responseJson);
		return js.get(key).toString();
	}

}
