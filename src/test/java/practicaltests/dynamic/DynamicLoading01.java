package practicaltests.dynamic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoading01 {
    public static void main(String[] args) {
        String projLocation = System.getProperty("user.dir");
        String chromeLocation = "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", projLocation.concat(chromeLocation));
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        try {
            //Thread.sleep(5000);
            WebElement example01LinkElem = driver.findElement(By.xpath("//*[@id='content']//a[contains(@href,'1')]"));
            example01LinkElem.click();

            WebElement startBtnElem = driver.findElement(By.xpath("//div[@id='start']//button"));
            startBtnElem.click();

            //before using WebDriverWait - No error but unable to get text
           /* WebElement helloTextElem = driver.findElement(By.xpath("//div[@id='finish']/h4"));
            System.out.println(helloTextElem.getText());*/

            //Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement helloTextElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
            System.out.println(helloTextElem.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
