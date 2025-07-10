package support.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectEx extends Select {

    private final String Option1 = "Option 1";
    public SelectEx(WebElement element) {
        super(element);
    }
    public void selectByTextOption1(){
        selectByVisibleText(Option1);
    }
}
