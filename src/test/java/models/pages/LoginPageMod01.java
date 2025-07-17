package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageMod01 {
    private final WebDriver driver;
    private final static By usernameTxt = By.id("username");
    private final static By passwordTxt = By.cssSelector("#password");
    private final static By loginBtn = By.cssSelector("[type='submit']");

    public LoginPageMod01(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement username(){
        return driver.findElement(usernameTxt);
    }
    public WebElement password() {
        return driver.findElement(passwordTxt);
    }
    public WebElement loginBtn() {
        return driver.findElement(loginBtn);
    }
}
