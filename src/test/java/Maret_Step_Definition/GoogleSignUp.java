package Maret_Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class GoogleSignUp {
	public static WebDriver driver;
	
	@Given("I am able to enter the Url")
	public void i_am_able_to_enter_the_url() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
	}
	@Then("close the url")
	public void close_the_url() {
		driver.quit();
		
	}


}
