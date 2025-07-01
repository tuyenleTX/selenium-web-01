package web_auto_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginWrongPassword {
    public static void main(String[] args) {
        String prjLocation = System.getProperty("user.dir");
        String chromeLocation = prjLocation + "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        //WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']")); //css Selector
        WebElement loginBtn = driver.findElement(By.xpath("//*[@type='submit']")); //xpath
        username.sendKeys("tomsmith");
        password.sendKeys("test");
        loginBtn.click();
        WebElement errorMessageElem = driver.findElement(By.id("flash-messages"));
        String errorMessage = errorMessageElem.getText().trim();
        boolean isContainingErrorMessage = errorMessage.contains("Your password is invalid!");
        Assert.assertEquals(isContainingErrorMessage,true);
        driver.quit();
    }
}
