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
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TexasSecretary {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		File file =new File("C:\\Users\\Dinesh K\\eclipse-workspace\\Maret\\Excel\\Texassecretory.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh =wb.createSheet("Texas");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://webservices.sos.state.tx.us/filing-status/status.aspx");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement input = driver.findElement(By.xpath("//input[@id='txtEntityName']"));
		input.click();
		input.sendKeys("medical");
		WebElement search = driver.findElement(By.xpath("//input[@id='btnEntityName']"));
		search.click();
		WebElement datas = driver.findElement(By.xpath("//table[@id='grdAll']"));
		List<WebElement> totalRow = datas.findElements(By.xpath("tr"));
		 for (int row = 1; row < totalRow.size(); row++) {
			 XSSFRow rowValue =sh.createRow(row);
			 List<WebElement> totalColumn = totalRow.get(row).findElements(By.xpath("td"));
			 for (int col = 1; col < totalColumn.size(); col++) {
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
