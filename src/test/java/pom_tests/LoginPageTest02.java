package pom_tests;

import driver.DriverFactory;
import models.pages.LoginPageMod02;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPageTest02 {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        try{
            LoginPageMod02 loginPage = new LoginPageMod02(driver);
            loginPage.inputUsername("tomsmith");
            loginPage.inputPassword("SuperSecretPassword!");
            loginPage.clickLoginBtn();
            driver.navigate().back();//go back to previous page
            driver.navigate().refresh();//refresh page
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
