package web_auto_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionMultiple {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        List<WebElement> elementList = driver.findElements(By.tagName("input1"));
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        int USERNAME_INDEX = 0;
        int PASSWORD_INDEX = 1;
        try{
            elementList.get(USERNAME_INDEX).sendKeys("tomsmith");
            elementList.get(PASSWORD_INDEX).sendKeys("SuperSecretPassword!");
            loginBtn.click();
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
