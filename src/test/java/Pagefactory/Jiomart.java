package Pagefactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jiomart {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		File file =new File("C:\\Users\\Dinesh K\\eclipse-workspace\\Maret\\Excel\\Jiomart1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh =wb.createSheet("Jio");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver =new ChromeDriver();
		driver.get("https://seller.jiomart.com/cat/catalog#!/manage_manufacturers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Username & password
		WebElement userName = driver.findElement(By.xpath("//input[@id='user_user_id']"));
		userName.sendKeys("sakthifruits");
		WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
		password.sendKeys("Jio@1234");
		Thread.sleep(20000);
		WebElement submit = driver.findElement(By.xpath("// body/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/input[1]"));
		submit.click();
		// Product table
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement product= driver.findElement(By.xpath("//a[text()='Products']"));
		product.click();
		WebElement manufacture = driver.findElement(By.xpath("//a[contains(text(),'Manufacturers')]"));
		manufacture.click();
		//All data
	 while (true) {
		 WebElement next = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
		    Thread.sleep(5000);
		    if (next.isEnabled()) {
		    	next.click();
		    	 WebElement datas = driver.findElement(By.xpath("//table[@class='table manufacturers-list table-default responsive']"));
	             List<WebElement> totalRow = datas.findElements(By.xpath("tr"));
	 for (int row = 0; row < totalRow.size(); row++) {
		 XSSFRow rowValue =sh.createRow(row);
		 Thread.sleep(5000);
		 List<WebElement> totalColumn = totalRow.get(row).findElements(By.xpath("td"));
		 for (int col = 0; col < totalColumn.size(); col++) {
			String cellValue = totalColumn.get(col).getText();
			System.out.println(cellValue +"\t");   
			rowValue.createCell(col).setCellValue(cellValue);
		}
			    	System.out.println();
		}
		FileOutputStream fos =new FileOutputStream(file);
		wb.write(fos);
     }
	 }
	 }
	 }