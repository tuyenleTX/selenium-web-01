package pom_tests;

import driver.DriverFactory;
import models.components.LoginFormComponent;
import models.pages.LoginPageMod02;
import models.pages.LoginPageMod03;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPageTest03 {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        try{
            LoginPageMod03 loginPage = new LoginPageMod03(driver);
            LoginFormComponent loginFormComponent = loginPage.loginFormComponent();
            loginFormComponent.inputUsername("tomsmith");
            loginFormComponent.inputPassword("SuperSecretPassword!");
            loginFormComponent.clickLoginBtn();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
