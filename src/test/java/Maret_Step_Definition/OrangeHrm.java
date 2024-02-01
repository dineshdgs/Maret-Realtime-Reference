package Maret_Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OrangeHrm {
 
	public static WebDriver driver;
	
	@Given("I am able to enter the OrangeHrm Url")
	public void i_am_able_to_enter_the_orange_hrm_url() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
	}
	@Then("close the OrangeHrm  url")
	public void close_the_orange_hrm_url() {
		driver.close();
		
	}
}
