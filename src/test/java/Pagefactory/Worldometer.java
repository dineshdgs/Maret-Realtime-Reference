package Pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Worldometer {
	public static WebDriver driver;
	public static void main(String[] args) {
	System.setProperty("webdriver.http.factory", "jdk-http-client");
	driver =new ChromeDriver();
	driver.get("https://www.worldometers.info/coronavirus/");
	driver.manage().window().maximize();
	
	List<WebElement> datas = driver.findElements(By.xpath("//table/tbody/tr/td"));
	for (WebElement jio : datas) {
		System.out.println(jio.getText());

}
}}