package StepDefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class angularwait {
	
	public WebDriver driver;
	String hmpg="https://developer.here.com/documentation";
	NgWebDriver ngdriver;
	
	@Given("^launch the URL for angular$")
	public void launch_the_URL_for_angular() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver_win32/chromedriver.exe");
		driver =new ChromeDriver();
		JavascriptExecutor jsdriver= (JavascriptExecutor)driver;
		ngdriver=new NgWebDriver(jsdriver);
	driver.manage().window().maximize();
		
		driver.get(hmpg);
		System.out.println("Navigated to Home page");
	
	   
	}

	@When("^wait for angular elements to load$")
	public void wait_for_angular_elements_to_load()  {
	    // Write code here that turns the phrase above into concrete actions
		ngdriver.waitForAngularRequestsToFinish();
		System.out.println("waited till angular elements are loaded");
	}

	@Then("^verify that angular elemnts are loaded in the webpage$")
	public void verify_that_angular_elemnts_are_loaded_in_the_webpage() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("inspected an element");
	    
	    driver.quit();
	}

}
