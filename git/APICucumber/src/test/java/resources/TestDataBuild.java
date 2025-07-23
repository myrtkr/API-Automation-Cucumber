package resources;

import java.util.ArrayList;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language,String address) {
		
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		addPlace.setLanguage(language);
		addPlace.setAddress(address);
		addPlace.setName(name);
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setWebsite("http://google.com");
		
		Location localList= new Location();
		localList.setLatitude(-38.383494);
		localList.setLongitude(33.427362);
		
		
		addPlace.setLocation(localList);
		
		ArrayList<String> typesList=new ArrayList<String>();
		typesList.add("shoe park");
		typesList.add("shop");
		addPlace.setTypes(typesList);
		
		return addPlace;
	}
	
	public String deletePlacePayload(String placeID) {
		
		return "{\r\n  \"place_id\":\""+placeID+"\"\r\n}";
		
	}

}
