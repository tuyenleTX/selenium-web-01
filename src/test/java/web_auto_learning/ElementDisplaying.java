package web_auto_learning;

import driver.DriverFactory;
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

            //get attribute
            System.out.println("Login button type: " + loginElem.getAttribute("type"));
            //get color of the button
            System.out.println("Login button css color: " + loginElem.getCssValue("background-color"));
            loginElem.click();

            driver.navigate().back();//go back to previous page
            driver.navigate().refresh();//refresh page




        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        //DEBUG PURPOSE ONLY

        driver.quit();
    }
}
