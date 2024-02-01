package Maret_Step_Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Maret_Signup {
	
	public static WebDriver driver;
	
	@Given("I am on the Signup page")
	public void i_am_on_the_signup_page() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh K\\eclipse-workspace\\Java_Testing\\driver\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new ChromeDriver();
		driver.get("https://maret.1clx.in/register");
		driver.manage().window().maximize();
	}
	@When("I enter a FirstName {string}")
	public void i_enter_a_first_name(String string) throws InterruptedException {
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		firstName.sendKeys(string);
		Thread.sleep(3000);
	}
	@When("I enter a Last Name {string}")
	public void i_enter_a_last_name(String string) throws InterruptedException {
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
		lastName.sendKeys(string);
		Thread.sleep(3000);
	}
	@When("I enter the DOB {string}")
	public void i_enter_the_dob(String string) throws InterruptedException {
		WebElement DOB = driver.findElement(By.xpath("//input[@id='dob']"));
		DOB.sendKeys(string);
		Thread.sleep(3000);
	}
	@When("I am able to pick the gender")
	public void i_am_able_to_pick_the_gender() {
		WebElement gender = driver.findElement(By.xpath("(//input[@name='gender'])[2]"));
		gender.click();
	}
	@When("I enter the Citizenship {string}")
	public void i_enter_the_citizenship(String string) throws InterruptedException {
		 Select citizen = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		 citizen.selectByVisibleText(string);
		 Thread.sleep(3000);
	}
	@When("I enter the Current Location {string}")
	public void i_enter_the_current_location(String string) throws InterruptedException {
		WebElement currentLocation = driver.findElement(By.xpath("//input[@id='location']"));
		currentLocation.sendKeys(string);
		Thread.sleep(3000);
	}
	@When("I enter the Mobile Number {string}")
	public void i_enter_the_mobile_number(String string) throws InterruptedException {
		WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='mobile']"));
		mobileNumber.sendKeys(string);
		Thread.sleep(3000);
		 
	}
	@When("I enter the Valid Email {string}")
	public void i_enter_the_valid_email(String string) throws InterruptedException {
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys(string);
		Thread.sleep(3000);
	}
	@When("I am able to enter the create account button")
	public void i_am_able_to_enter_the_create_account_button() {
		WebElement button = driver.findElement(By.xpath(" //*[@id=\"app\"]/main/div[2]/div/div[1]/div/form/div[9]/input"));
		button.click();
	}
	@Then("I should be redirected to the dashboard page")
	public void i_should_be_redirected_to_the_dashboard_page() {
		WebElement OTP = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		OTP.click();
	}
}
