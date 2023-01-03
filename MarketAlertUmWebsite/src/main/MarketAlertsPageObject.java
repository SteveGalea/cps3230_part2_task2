package main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.net.URL;
import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;

public class MarketAlertsPageObject extends PageObject {

	WebDriverWait wait;
    public MarketAlertsPageObject(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void goToLoginPage() {
        driver.manage().window().maximize();
        driver.get("https://www.marketalertum.com/Alerts/Login");
   }

    public WebElement getUserIdInputFieldElement() {
    	goToLoginPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserId")));
        return driver.findElement(By.id("UserId"));
    }

    public WebElement getSubmitButton() {
    	By btnXpath = By.xpath("//input[@type='submit']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnXpath));
        return driver.findElement(btnXpath); //retrieving only button
    }

    public void inputCredentials(String userValidDetails) {
        getUserIdInputFieldElement().sendKeys(userValidDetails);
    }

    public void goToWantedUrl(String wantedUrl){
    	driver.get(wantedUrl);
        wait.until(ExpectedConditions.urlToBe(wantedUrl));
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void logIn(){
        String userValidUserId = "baf95487-17f6-40df-b758-3c938a0ec72a";
        inputCredentials(userValidUserId);
        getSubmitButton().submit();
    }
    
    public void logOut() {
    	String wantedUrl = ("https://www.marketalertum.com/Home/Logout"); 
    	driver.get(wantedUrl);
//        wait.until(ExpectedConditions.urlToBe("https://www.marketalertum.com"));       
    }
    
	public void viewAlerts() {
		String wantedUrl = "https://www.marketalertum.com/Alerts/List";
		driver.get(wantedUrl);
	}
}
