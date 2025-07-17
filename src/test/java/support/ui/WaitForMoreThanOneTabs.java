package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitForElementEnabled implements ExpectedCondition<Boolean> {
    private By selector;

    public WaitForElementEnabled(By selector) {
        this.selector = selector;
    }
    @Override
    public Boolean apply(WebDriver driver) {
        return driver.findElement(selector).isEnabled();
    }

    @Override
    public String toString() {
        return "WaitForElementEnabled{" +
                "selector=" + selector +
                '}';
    }
}
