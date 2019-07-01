package StepDefinition;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class links {
	
	public WebDriver driver;
	String hmpg="https://developer.here.com/documentation";
	String url="";
    HttpURLConnection connection;
    int httpcode;
	
	@Given("^launch the URL$")
	public void launch_the_URL() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver_win32/chromedriver.exe");
		driver =new ChromeDriver();
	driver.manage().window().maximize();
		
		driver.get(hmpg);
		System.out.println("Navigated to Home page");
		}

	
	@When("^links are verified with the status code$")
	public void links_are_verified_with_the_status_code() throws IOException {
		List<WebElement> links = driver.findElements(By.tagName("a"));
        
		for(WebElement ele:links) {
			url=ele.getAttribute("href");
			System.out.println(url);
			
			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				                continue;
				            }
			if(!url.startsWith(hmpg)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
			
			connection = (HttpURLConnection)(new URL(url).openConnection());
            
            connection.setRequestMethod("HEAD");
            
            connection.connect();
            
            httpcode = connection.getResponseCode();
            
            if(httpcode >= 400){
                System.out.println(url+" is a broken link");
            }
            else{
                System.out.println(url+" is a valid link");
            }
		}
        
		
		
	}
	
	@Then("^links are validated with their respective status codes$")
	public void links_are_validated_with_their_respective_status_codes() {
		
	    System.out.println("Links are verified with their respective http codes");
	    driver.quit();
	}
}
