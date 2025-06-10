package web_auto_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm {
    public static void main(String[] args)  {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameTxt = driver.findElement(By.id("username"));
        WebElement passwordTxt = driver.findElement(By.cssSelector("#password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        usernameTxt.sendKeys("tomsmith");
        passwordTxt.sendKeys("SuperSecretPassword!");
        loginBtn.click();
        try{
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
