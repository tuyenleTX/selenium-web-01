package web_auto_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectEx;
import url.Urls;

public class IFrame implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.baseUrl.concat(Urls.iframeSlug));
        try {
            WebElement closeButtonElem = driver.findElement(By.cssSelector("[class$='tox-notification--warning'] > button"));
            closeButtonElem.click();

            WebElement iframeBodyElem = driver.findElement(By.cssSelector("[id$='ifr']"));
            driver.switchTo().frame(iframeBodyElem);

            WebElement editorInputElem = driver.findElement(By.cssSelector("[id='tinymce'] >p"));
            System.out.println(editorInputElem.getText());

            //Thread.sleep(2000); //debug purpose only
        } catch (Exception e) {
            e.printStackTrace();
        }
       driver.quit();
    }
}
