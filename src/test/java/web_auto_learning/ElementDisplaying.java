package web_auto_learning;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementDisplaying {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        try{
            By usernameTxt = By.id("username");
            By passwordTxt = By.cssSelector("#password");
            By loginBtn = By.cssSelector("[type='submit']");
            WebElement usernameElem = driver.findElement(usernameTxt);
            WebElement passwordElem = driver.findElement(passwordTxt);
            WebElement loginElem = driver.findElement(loginBtn);

            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginElem.click();

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        //DEBUG PURPOSE ONLY

        driver.quit();
    }
}
