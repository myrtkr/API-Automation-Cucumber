Feature: Validating Add Place API's

@AddPlace
Scenario Outline: Verify Place has been successfully added by post Place API's
Given: Add Place API payload with "<name>","<language>","<Address>"
When: User call "addPlaceAPI" with "Post" http request
Then: The API call got success with status code 200 
And: "status" in response body is "OK"
And: "scope" in response body is "App"
#And: Verify place-Id created maps to <"name"> using "getPlaceAPI"

Examples:
|name|language|Address|
|Frontline|French|29, side layout, tx 102|
#|Back House|Englisg|87 gaylord dr, Mo 76546|


@DeletePlace
Scenario Outline: Verify Place has been deleted place functionality is working  
Given: Delete Place API payload with "<place_Id>"
When: User call "deletePlaceAPI" with "Post" http request
Then: The API call got success with status code 200 
And: "status" in response body is "OK"