package main;

import org.json.JSONArray;
//import org.json.JSONException;
import org.json.JSONObject;

public class Runner {

	public void sleep(){
		//helps program keep up
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void UserValidLogin() {
		System.out.println("Event: UserValidLogin at: " + System.currentTimeMillis());
		sleep();
	}

	public void UserLoggedOut() {
		System.out.println("Event: UserLoggedOut at: " + System.currentTimeMillis());
		sleep();
	}
	
	public void UserViewingAlerts() {
		System.out.println("Event: UserViewingAlerts at: " + System.currentTimeMillis());
		sleep();
	}

    public JSONObject parseJsonObject(String jsonString) throws Exception{
    	return new JSONObject(jsonString);
    	//get required value by adding .getJSONObject("parentKey").getString("wantedKey"); //https://devqa.io/how-to-parse-json-in-java/#:~:text=First%2C%20we%20need%20to%20convert,to%20use%20the%20getJSONArray%20method.
    }
    
	public void runner(){
		RequestMaker requestMaker= new RequestMaker();
		try{
			
		String eventLogString = requestMaker.getRequestAllEvents();
		
		JSONArray eventLogArray = new JSONArray(eventLogString);
		int eventLogArrayLength = eventLogArray.length();
		int[] eventLogTypeArray = new int[eventLogArrayLength];
		
		for(int i = 0; i<eventLogArrayLength; i++){
			JSONObject objects = eventLogArray.getJSONObject(i);
//			System.out.println("Alerts: "+objects.getJSONObject("systemState").getJSONArray("alerts"));
//			System.out.println("EventLogType: "+objects.get("eventLogType"));
//			System.out.println();
			eventLogTypeArray[i] = (int) objects.get("eventLogType");
		}
		for(int eventId : eventLogTypeArray){
			System.out.println(eventId);
			switch(eventId){
				case 5: UserValidLogin(); break;
				case 6: UserLoggedOut(); break;
				case 7: UserViewingAlerts(); break;
			}
		}
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
