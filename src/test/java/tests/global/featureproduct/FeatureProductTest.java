package tests.global.featureproduct;

import driver.DriverFactory;
import models.components.Product.ProductItemComponent;
import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class FeatureProductTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testFeaturedProductHomePage(driver);
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

    }

    private static void testFeaturedProductHomePage(WebDriver driver) {
        driver.get("https://demowebshop.tricentis.com/");
        HomePage homePage = new HomePage(driver);
        List<ProductItemComponent> productItemComponentList = homePage.productGridComponent().productItemComponentList();
        productItemComponentList.forEach(productItemComponent -> {
            System.out.println(productItemComponent.productTitleElem().getText());
        });

    }


}
