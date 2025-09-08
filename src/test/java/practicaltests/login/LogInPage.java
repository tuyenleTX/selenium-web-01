package practicaltests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    private WebDriver driver;
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.id("password");
    private final static By loginSel = By.xpath("//button[@type='submit']");

    WebElement usernameElem;
    WebElement passwordElem;
    WebElement loginElem;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.usernameElem = driver.findElement(usernameSel);
        this.passwordElem = driver.findElement(passwordSel);
        this.loginElem = driver.findElement(loginSel);
    }

    public void clickingOnLogin(String username, String password) {
        usernameElem.sendKeys(username);
        passwordElem.sendKeys(password);
        loginElem.click();
    }
}
