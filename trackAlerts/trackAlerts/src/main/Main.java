package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//import org.json.JSONArray;
//import org.json.JSONObject;

public class Main {
	boolean areEventsGenerated = false;
	
	ArrayList<Product> productAlerts = new ArrayList<Product>();
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	RequestMaker requestMaker = new RequestMaker();

	public static int read()
	{
		try{
			return Integer.parseInt(br.readLine());
		}
		catch(Exception ex)
			{ex.printStackTrace();}
		return -1;
	}

	public void resetSystem(){
		System.out.println("Resetting System");
		productAlerts = new ArrayList<Product>(); 
		deleteAlerts();
		requestMaker = new RequestMaker();
		try{
			requestMaker.getRequestAllEvents();
			System.out.println("Cleared EventLog System");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public int getRandomNumber(int max, int min){
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
//	public void addAlert(){
//		System.out.print("Dummy Alert: ...");
//		RequestMaker requestMaker = new RequestMaker();
//		Product p = new Product();
//		switch(getRandomNumber(1,0)){
//			case 0: 
//				System.out.println("adding a good alert"); 
//				p = new Product(getRandomNumber(5,1),"Product "+productAlerts.size()+" is a Good Alert", "Good Description for Product", "https://www.google.com", "https://www.google.com", 23212);
//				break;
//			case 1: 
//				System.out.println("adding a bad alert"); 
//				p = new Product(-1,"Product "+productAlerts.size()+" is a Bad Alert", "", "", "", -1000);
//				break;
//		}
//		productAlerts.add(p);
//		requestMaker.setJSONObject(p);
//		try{
//			requestMaker.postRequestAddAlert();
//		}catch(Exception e){
//    		System.out.println(e.getMessage());
//    	}
//	}
	public void addAlert(){
		System.out.print("addAlert Method: ");
		requestMaker = new RequestMaker();
		Product p = new Product(getRandomNumber(5,1),"Product "+productAlerts.size()+" is an Alert", "Description for Product", "https://www.google.com", "https://www.google.com", 23212);
				
		productAlerts.add(p);
		requestMaker.setJSONObject(p);
		try{
			requestMaker.postRequestAddAlert();
			System.out.println("Alert Added at "+ System.currentTimeMillis());
		}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
	}


	public void deleteAlerts(){
		System.out.print("deleteAlert Method: ");
		requestMaker = new RequestMaker();
    	try{
	    	requestMaker.deleteRequestDeleteAlerts();
			System.out.println("Alerts Deleted at "+ System.currentTimeMillis());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
    	productAlerts = new ArrayList<Product>();
	}

	public String show()
	{
		String s = "";
		int i = 0;
		for (Product p:productAlerts){
			s += i + "("+p.heading+"), ";
			i++;
		}
		return s;
	}

//	public void menu()
//	{
//		resetSystem();
//		boolean run = true;
//		while (run)
//		{
//			System.out.println("****MAIN MENU****");
//			System.out.println("Alerts: "+show());
//			System.out.println("1. add alert");
//			System.out.println("2. delete alerts");
//			System.out.println("3. exit");
//			switch(read())
//			{
//				case 1:addAlert();break;
//				case 2:deleteAlerts();break;
//				case 3:run=false;break;
//			}
//		}
//	}

	public void menu()
	{
		resetSystem();
		boolean run = true;
		while (run)
		{
			System.out.println("\n****MAIN MENU****");
			System.out.println("1. Generate alerts");
			System.out.println("2. Run-time Verification");
			System.out.println("3. Reset");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			switch(read())
			{
				case 1:
					System.out.println("How many Alerts would you like generated?");
					generateProductAlerts(read());
					break;

				case 2:
					System.out.println("Verification:");
					new Runner().runner();
					break;
					
				case 3:
					System.out.println("Resetting:");
					resetSystem();
					break;
					
				case 4:
					System.out.println("Bye!");
					run=false;
					break;
			}
		}
	}
	
	public void generateProductAlerts(int wantedAmount){
		for(int i = 0; i < wantedAmount; i++){
			switch(getRandomNumber(1,0)){
			case 0:addAlert(); break;
			case 1:deleteAlerts(); break;
			}
		}
	}

	public static void main(String args[]){
		new Main().menu();
//		RequestMaker requestMaker = new RequestMaker();
//		Product p = new Product(1,"Test", "Desc", "https://www.google.com", "https://www.google.com", 23212);
//		requestMaker.setJSONObject(p);
//		try{
//    		System.out.println(requestMaker.postRequestAddAlert());
//    		System.out.println(requestMaker.postRequestAddAlert());
//    		System.out.println(requestMaker.postRequestAddAlert());
//    		System.out.println(requestMaker.postRequestAddAlert());
//    	}catch(Exception e){
//    		System.out.println(e.getMessage());
//    	}
//    	try{
//	    	System.out.println(requestMaker.deleteRequestDeleteAlerts());
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
//		try{
////    		System.out.println(requestMaker.getRequestAllEvents());
//    	}catch(Exception e){
//    		System.out.println(e.getMessage());
//    	}
//		try{
////    		System.out.println(requestMaker.getRequestCurrentLoginStatus());
//    	}catch(Exception e){
//    		System.out.println(e.getMessage());
//    	}
		
	}
}
