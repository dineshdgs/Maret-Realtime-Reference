package Maret_Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class empowersiteTest 
{
  public static WebDriver driver;
  
  @Given("Open Empower Url")
  public void open_empower_url() 
  {
	  System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		driver.get("https://www.empowertherapy.com/");
		driver.manage().window().maximize();
  }
  
  @Given("Close Empower Url")
  public void close_empower_url() 
  {
	  driver.quit();
  }



	
	
}
