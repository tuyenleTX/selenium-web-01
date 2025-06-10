package web_auto_learning;

import Driver.DriverFactory;
import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
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
