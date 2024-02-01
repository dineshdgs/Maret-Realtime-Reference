package Maret_Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Youtube {
	public static WebDriver driver;
	
	@Given("I want to enter the Url")
	public void i_want_to_enter_the_url() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		
	}
	@Then("close url")
	public void close_url() {
		driver.quit();
	}


}
