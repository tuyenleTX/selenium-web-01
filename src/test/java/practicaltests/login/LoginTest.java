package practicaltests.login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(dataProvider = "loginData")
    public void login(String username, String password) {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.clickingOnLogin(username, password);
        try {
            String secureUrl = driver.getCurrentUrl();
            Assert.assertEquals(secureUrl, "https://the-internet.herokuapp.com/secure");
            Thread.sleep(5000);//debug only
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] testData() {
        return  new Object[][] {{"tomsmith","SuperSecretPassword!"},{"tomsmith1","SuperSecretPassword!"},{"tomsmith2","SuperSecretPassword!"}};
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
