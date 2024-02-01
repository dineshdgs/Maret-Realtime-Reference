package Maret_Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Mynthra_Signup {
	public static WebDriver driver;
	@Given("Enter Mynthra the Url")
	public void enter_mynthra_the_url() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		driver.get("https://www.Mynthra.com/");
		driver.manage().window().maximize();
	}
	@Then("close Mynthra url")
	public void close_mynthra_url() {
		driver.quit();
		
	}

}
