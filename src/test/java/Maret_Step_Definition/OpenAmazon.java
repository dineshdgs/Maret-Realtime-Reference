package Maret_Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class OpenAmazon
{
	public static WebDriver driver;
	
	@Given("Open Url")
	public void open_url() 
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@Given("Close Url")
	public void close_url() 
	{
		driver.quit();
	}
}
