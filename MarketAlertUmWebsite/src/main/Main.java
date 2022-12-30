package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//import org.json.JSONArray;
//import org.json.JSONObject;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	RequestMaker requestMaker = new RequestMaker();
	static WebDriver driver;
	static MarketAlertsPageObject marketAlertsPageObject;
	
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
//		productAlerts = new ArrayList<Product>(); 
//		deleteAlerts();
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
					System.out.println("How many Events would you like generated?");
					generateEvents(read());
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
			driver.quit();
		}
	}
	
	public void generateEvents(int wantedAmount){
		System.out.println("Wanted Events: "+wantedAmount);
		for(int i = 0; i < wantedAmount; i++){
			switch(getRandomNumber(2,0)){
			case 0:
				System.out.println(i+": Logging in");
				marketAlertsPageObject.logIn(); 
				break;
			case 1:
				System.out.println(i+": Logging Out");
				marketAlertsPageObject.logOut(); 
				break;
			case 2:
				System.out.println(i+": Viewing Alerts");
				marketAlertsPageObject.viewAlerts(); 
				break;
			}
		}
	}

	public static void main(String args[]){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\steve\\workspace\\luna\\LoginSystem\\src\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		marketAlertsPageObject = new MarketAlertsPageObject(driver);
		new Main().menu();		
	}
}
