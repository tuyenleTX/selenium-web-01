package dynamic_control;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSauceDemo {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://www.saucedemo.com/");
        try {
            WebElement usernameElem = driver.findElement(By.id("user-name"));
            WebElement passwordElem = driver.findElement(By.id("password"));
            WebElement loginElem = driver.findElement(By.id("login-button"));
            usernameElem.sendKeys("standard_user");
            passwordElem.sendKeys("secret_sauce");
            loginElem.click();
            Thread.sleep(5000);
            //verify that current page is inventory
            Assert.assertEquals(driver.getCurrentUrl().contains("inventory.html"),true);

            //click on hamburger menu
            WebElement menuElem = driver.findElement(By.cssSelector(".bm-burger-button"));
            menuElem.click();
            Thread.sleep(5000);
            WebElement logoutElem = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
            logoutElem.click();
            Thread.sleep(5000);//for debug only
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
