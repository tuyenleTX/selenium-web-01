package web_auto_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class DynamicControl implements Urls {
    private final static By checkbox_example = By.id("checkbox-example");
    private final static By input_example = By.id("input-example");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.baseUrl.concat(dynamicControlSlug));

        try {
            WebElement checkboxFormElem = driver.findElement(checkbox_example);
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));
            if(!checkboxElem.isSelected()) checkboxElem.click();
            Thread.sleep(5000);

            WebElement inputFormElem = driver.findElement(input_example);
            WebElement inputTextElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputButtonElem = inputFormElem.findElement(By.tagName("button"));
            inputButtonElem.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-example p")));
            inputTextElem.sendKeys("Hello! you are so expertise in automation");
            Thread.sleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
