package practicaltests.dynamic;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoading02 {
    public static void main(String[] args) {
        String projLocation = System.getProperty("user.dir");
        String chromeLocation = "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", projLocation + chromeLocation);
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        try {
            WebElement startBtnElem = driver.findElement(By.xpath("//div[@id='start']//button"));
            startBtnElem.click();

            //if not using the WebDriverWait - Error: NoSuchElementException
//            WebElement helloTextElem = driver.findElement(By.xpath("//*[@id='finish']//h4"));
//            System.out.println(helloTextElem.getText());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement helloTextElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
            System.out.println(helloTextElem.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
