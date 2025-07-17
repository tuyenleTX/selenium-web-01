package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitForMoreThanOneTabs implements ExpectedCondition<Boolean> {
    private final By selector;

    public WaitForMoreThanOneTabs(By selector) {
        this.selector = selector;
    }
    @Override
    public Boolean apply(WebDriver driver) {
        return driver.getWindowHandles().size() > 1;
    }

    @Override
    public String toString() {
        return "WaitForMoreThanOneTabs{" +
                "selector=" + selector +
                '}';
    }
}
