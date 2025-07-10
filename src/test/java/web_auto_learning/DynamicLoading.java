package web_auto_learning;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class DynamicLoading {

    private final static By startBtnSel = By.xpath("//div[@id='start']/button");
    private final static By helloSel = By.id("finish");

    public static void main(String[] args) throws IOException {
        String prjLocation = System.getProperty("user.dir");
        String chromeLocation = "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", prjLocation.concat(chromeLocation));
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startElem = driver.findElement(startBtnSel);
        startElem.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloText = wait.until(ExpectedConditions.visibilityOfElementLocated(helloSel));
        //after clicking button
        System.out.println("after: " + helloText.getText());

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File desFile = new File("hellotext.png");
        Files.copy(srcFile.toPath(), desFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        driver.quit();

    }
}
