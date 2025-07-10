package web_auto_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;
import java.util.List;

public class javascript_alert implements Urls{
    private final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private final static By jsConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private final static By jsPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    private final static By result = By.cssSelector("#result");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.baseUrl.concat(Urls.javaScriptSlug));

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert;

            WebElement resultElem;

            WebElement jsAlertSelElem = driver.findElement(jsAlertSel);
            jsAlertSelElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());
            alert.accept();
            resultElem = driver.findElement(result);
            System.out.println(resultElem.getText());

            WebElement jsConfirmSelElem = driver.findElement(jsConfirmSel);
            jsConfirmSelElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());
            alert.dismiss();
            resultElem = driver.findElement(result);
            System.out.println(resultElem.getText());

            WebElement jsPromptSelElem = driver.findElement(jsPromptSel);
            jsPromptSelElem.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.sendKeys("Hello alert!");
            System.out.println(alert.getText());
            alert.accept();
            resultElem = driver.findElement(result);
            System.out.println(resultElem.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
