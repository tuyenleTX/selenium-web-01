package web_auto_learning;

import driver.DriverFactory;

import utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class ReadingFile {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        String excelLocation = "src/test/resources/files/data.xlsx";
        try {
            String username = ExcelUtils.getCellData(excelLocation, 1, 0);
            String password = ExcelUtils.getCellData(excelLocation, 1, 1);

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.cssSelector("[type='submit']")).click();
            Thread.sleep(5000);
            Assert.assertEquals(driver.getTitle(), "The Internet");

        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
