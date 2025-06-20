package web_auto_learning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

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
