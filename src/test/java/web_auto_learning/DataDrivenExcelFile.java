package web_auto_learning;

import driver.DriverFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverAction;

public class DataDrivenExcelFile {
    public static void main(String[] args) throws IOException {
        String excelFile = "src/test/resources/files/data.xlsx";

        FileInputStream fileInputStream = new FileInputStream(excelFile);

        Workbook excelWorkbook = new XSSFWorkbook(fileInputStream);
        Sheet excelSheet = excelWorkbook.getSheetAt(0);

//        String prjLocation = System.getProperty("user.dir");
//        System.setProperty("webdriver.chrome.driver", prjLocation + "/src/test/resources/drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = DriverFactory.getChromeDriver();

        for (int i = 1; i <= excelSheet.getLastRowNum(); i++) {
            Row row = excelSheet.getRow(i);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            try {
                driver.get("https://the-internet.herokuapp.com/login");
                WebElement usernameElem = driver.findElement(By.id("username"));
                WebElement passwordElem = driver.findElement(By.id("password"));
                WebElement loginBtnElem = driver.findElement(By.cssSelector("[type='submit']"));
                usernameElem.sendKeys(username);
                passwordElem.sendKeys(password);
                loginBtnElem.click();
                Thread.sleep(3000);
                driver.navigate().back();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}