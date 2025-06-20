package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        String currentPrjLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";
        if(OS.isFamilyMac()) {
            chromeDriverLocation = currentPrjLocation + "/src/test/resources/drivers/chromedriver";
        } else if (OS.isFamilyWindows()){
            chromeDriverLocation = currentPrjLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        }
        if (chromeDriverLocation.isEmpty()) {
            throw new IllegalArgumentException("Cannot find Chrome Driver");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        // chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



        return driver;
    }
}
