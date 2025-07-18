package models.components.Product;

import models.components.Component;
import models.components.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(value=".product-item")
public class ProductItemComponent extends Component {
    private static final By productTitleSel = By.cssSelector(".product-title");
    public ProductItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public WebElement productTitleElem() {
        return component.findElement(productTitleSel);
    }
}
