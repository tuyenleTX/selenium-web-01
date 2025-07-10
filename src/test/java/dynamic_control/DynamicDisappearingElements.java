package dynamic_control;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class DynamicDisappearingElements {
    public static void main(String[] args) {
        String prjLocation = System.getProperty("user.dir");
        String chromeLocation = "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", prjLocation.concat(chromeLocation));
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");

        boolean isGalary = false;
        for(int temp = 0; temp < 10; temp ++) {
            List<WebElement> linkElem = driver.findElements(By.xpath("//div[@class='example']//ul/li/a"));

            for (int i = 0; i < linkElem.size(); i++) {
                if (linkElem.get(i).getText().equalsIgnoreCase("Gallery")) {
                    isGalary = true;
                    System.out.println("Gallery is displaying at try: " + (temp + 1));
                    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                    File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
                    File desFile = new File("Menu with Gallery");
                    try {
                        Files.copy(srcFile.toPath(), desFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    linkElem.get(i).click();
                    System.out.println("Gallery is displaying");
                    break;
                }
            }
            if (isGalary)
                break;
            else
                driver.navigate().refresh();
        }
        if(!isGalary) System.out.println("Unable to find menu Gallery after 10 times retry");
        driver.quit();
    }
}
