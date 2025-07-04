package stringmanipulation;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class test08 {
    public static void main(String[] args) {
        //regular expression
        String prjLocation = System.getProperty("user.dir");
        String chromeLocation = "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", prjLocation + chromeLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        //WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://recruiting2.ultipro.com/MGA1000MGAI/JobBoard/953bfe27-d30f-43cd-bfda-f7e21bb80ed1/?q=&o=postedDateDesc&w=&wc=&we=&wpst=");
        Assert.assertEquals(driver.getTitle(), "My Job Search");
        try {
            WebElement signInElem = driver.findElement(By.xpath("//*[@id='SignInButton']"));
            signInElem.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            WebElement usernameElem = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
            WebElement passwordElem = driver.findElement(By.id("passphrase"));
            WebElement signInBtnElem = driver.findElement(By.id("button-sign-in"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", usernameElem);
            //usernameElem.clear();
            usernameElem.sendKeys("tuyen.thanh.le.29@gmail.com");

            passwordElem.click();
            //   passwordElem.clear();
            passwordElem.sendKeys("@GreatJob2025");

            signInBtnElem.click();

            WebElement profileElem = driver.findElement(By.xpath("//*[@id='Profilemenu-button']/span"));
            String profileName = profileElem.getText();
            Assert.assertEquals(profileName, "Thanh Tuyen Le");

            WebElement logoutBtnElem = driver.findElement(By.xpath("//*[@id='ukg-menu-LogOutButton']"));
            logoutBtnElem.click();
            //   Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
