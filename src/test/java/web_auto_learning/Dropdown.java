package web_auto_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import url.Urls;

public class Dropdown implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.baseUrl.concat(Urls.dropdownSlug));
        try {
            WebElement dropdownListElem = driver.findElement(By.id("dropdown"));
            Select select = new Select(dropdownListElem);
            select.selectByVisibleText("Option 1");

            select.selectByIndex(2);


            select.selectByValue("1");
            Thread.sleep(2000); //debug purpose only
        } catch (Exception e) {
            e.printStackTrace();
        }
       driver.quit();
    }
}
