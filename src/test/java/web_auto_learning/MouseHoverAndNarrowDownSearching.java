package web_auto_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.List;

public class MouseHoverAndNarrowDownSearching {
    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figure h5");
    private final static By profileLinkSel = By.cssSelector(".figure a");
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.baseUrl.concat(Urls.hoverSlug));

        try {
            List<WebElement> figureSelList = driver.findElements(figureSel);
            Actions actions = new Actions(driver);

            for (WebElement e: figureSelList) {
                WebElement profileNameElem = e.findElement(profileNameSel);
                WebElement profileLinkElem = e.findElement(profileLinkSel);
                //before mouse hover
                System.out.println(profileNameElem.getText() + ": "  + profileNameElem.isDisplayed());
                System.out.println(profileLinkElem.getText() + ": " + profileLinkElem.isDisplayed());

                //after mouse hover
                actions.moveToElement(e).perform();
                System.out.println(profileNameElem.getText() + ": "  + profileNameElem.isDisplayed());
                System.out.println(profileLinkElem.getText() + ": " + profileLinkElem.isDisplayed());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
