package pom_tests;

import driver.DriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPageTest01 {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        try{
            models.pages.LoginPageMod01 loginPage = new models.pages.LoginPageMod01(driver);
            loginPage.username().sendKeys("tomsmith");
            loginPage.password().sendKeys("SuperSecretPassword!");
            loginPage.loginBtn().click();
            driver.navigate().back();//go back to previous page
            driver.navigate().refresh();//refresh page
        } catch (
                NoSuchElementException e) {
            e.printStackTrace();
        }
        //DEBUG PURPOSE ONLY

        driver.quit();
    }

}
