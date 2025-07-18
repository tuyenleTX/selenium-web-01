package tests.global.footer;

import driver.DriverFactory;
import models.components.global.footer.*;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class FooterTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testFooterHomePage(driver);
            testFooterCategoryPage(driver);
            testFooterRegisterPage(driver);
            testFooterLoginPage(driver);
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

    }

    private static void testFooterHomePage(WebDriver driver) {
        driver.get("https://demowebshop.tricentis.com/");
        HomePage homePage = new HomePage(driver);
        InformationColumnComponent informationColumnComponent = homePage.footerComponent().informationColumnComponent();
        testFooterColumn(informationColumnComponent);

        CustomerServiceColumnComponent customerServiceColumnComponent = homePage.footerComponent().customerServiceColumnComponent();
        testFooterColumn(customerServiceColumnComponent);

        MyAccountColumnComponent myAccountColumnComponent = homePage.footerComponent().myAccountColumnComponent();
        testFooterColumn(myAccountColumnComponent);

        FollowUsColumnComponent followUsColumnComponent = homePage.footerComponent().followUsColumnComponent();
        testFooterColumn(followUsColumnComponent);
    }

    private static void testFooterCategoryPage(WebDriver driver) {
    }

    private static void testFooterRegisterPage(WebDriver driver) {
    }

    private static void testFooterLoginPage(WebDriver driver) {
    }

    private static void testFooterColumn(FooterColumnComponent footerColumnComponent) {
        System.out.println(footerColumnComponent.headerElem().getText());
        footerColumnComponent.linksElem().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
