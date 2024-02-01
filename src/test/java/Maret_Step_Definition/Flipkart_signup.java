package Maret_Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_signup {
	
	public static WebDriver driver;
	@Given("Enter flipkart the Url")
	public void enter_flipkart_the_url() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	@Then("close Flipkart url")
	public void close_flipkart_url() {
		driver.close();
		
	}

}
