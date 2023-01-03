package main;

import org.json.JSONArray;
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
	
	public void createAlert() {
		System.out.println("Event: AlertCreated at: " + System.currentTimeMillis());
		sleep();
	}
	
	public void deleteAlerts() {
		System.out.println("Event: AlertsDeleted at: " + System.currentTimeMillis());
		sleep();
	}

    public JSONObject parseJsonObject(String jsonString){
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
			switch(eventId){
				case 0: createAlert(); break;
				case 1: deleteAlerts(); break;
			}
		}
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
