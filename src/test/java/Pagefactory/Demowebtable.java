package Pagefactory;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demowebtable { 
	public static WebDriver driver;
 
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://webservices.sos.state.tx.us/filing-status/status.aspx");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement input = driver.findElement(By.xpath("//input[@id='txtEntityName']"));
		input.sendKeys("Medical");
		WebElement search = driver.findElement(By.xpath("//input[@id='btnEntityName']"));
		search.click();

		WebElement table = driver.findElement(By.xpath("//table[@id='grdAll']"));

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("TestingData");

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		int rowNum = 0;
		for (WebElement row : rows) {
			Row excelRow = sheet.createRow(rowNum++);
			List<WebElement> columns = row.findElements(By.tagName("td"));
			int colNum = 0;
			for (WebElement column : columns) {
				excelRow.createCell(colNum++).setCellValue(column.getText());
			}
		}

		try (FileOutputStream outputStream = new FileOutputStream(
				"C:\\Users\\Dinesh K\\eclipse-workspace\\Maret\\Excel\\Testingsecretory.xlsx")) {
			workbook.write(outputStream);
		}

		driver.quit();
	}
}