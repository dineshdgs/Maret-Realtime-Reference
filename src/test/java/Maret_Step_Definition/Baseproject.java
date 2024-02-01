package Maret_Step_Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Baseproject{
	
	public static WebElement q;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		PageFactory.initElements(driver, Baseproject.class);
		Baseproject.q.click();
		Baseproject.q.sendKeys("shoe");

	
	}
	}