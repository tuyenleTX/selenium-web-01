package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) {
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
        driver.get("https://google.com");
        try {
            Thread.sleep(3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }

       // driver.close(); --only close window but not close session
        driver.quit(); //close session and close browser
    }
}
