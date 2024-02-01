package Pagefactory;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pagination {
   public static WebDriver driver;
	    public static void main(String[] args) throws InterruptedException {
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
			WebElement submit = driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/input[1]"));
			submit.click();
			// Product table
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement product= driver.findElement(By.xpath("//a[text()='Products']"));
			product.click();
			WebElement manufacture = driver.findElement(By.xpath("//a[contains(text(),'Manufacturers')]"));
			manufacture.click();
	        // File path of the Excel workbook
	        String filePath = "C:\\Users\\Dinesh K\\OneDrive - Round Rock ABA school LLC\\Desktop\\12345.xlsx";

	        // Page size, i.e., the number of rows to read per page
	        int pageSize = 10;

	        // Page number, i.e., the page you want to read
	        int pageNumber = 1;

	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = WorkbookFactory.create(fis)) {

	            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet

	            // Calculate the starting and ending rows for the current page
	            int startRow = (pageNumber - 1) * pageSize;
	            int endRow = Math.min(startRow + pageSize, sheet.getLastRowNum() + 1);

	            for (int rowNum = startRow; rowNum < endRow; rowNum++) {
	                Row row = sheet.getRow(rowNum);
	                if (row != null) {
	                    // Process the data in the row
	                    for (Cell cell : row) {
	                        // Access cell data as needed
	                        switch (cell.getCellType()) {
	                            case STRING:
	                                System.out.print(cell.getStringCellValue() + "\t");
	                                break;
	                            case NUMERIC:
	                                System.out.print(cell.getNumericCellValue() + "\t");
	                                break;
	                            // Add more cases for other cell types if needed
	                            default:
	                                System.out.print("\t");
	                        }
	                    }
	                    System.out.println(); // Move to the next line after processing each row
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



