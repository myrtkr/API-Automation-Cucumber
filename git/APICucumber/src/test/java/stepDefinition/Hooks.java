package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void before_Scenario() throws IOException {
		
		
		StepDefinition requiredMethods= new StepDefinition();
		if(StepDefinition.placeID==null) { //calling the static object by class is recommended
			
		requiredMethods.Add_Place_API("Water", "Natural", "Sea");
		requiredMethods.post_http_request("addPlaceAPI", "Post");
		requiredMethods.verifyPlaceID("Water", "getPlaceAPI");
		}
	}

}
