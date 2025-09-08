package test_flows.global;

import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.FooterComponent;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import url.Urls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        BasePage basePage = new BasePage(driver);
        FooterComponent footerComponent = basePage.footerComponent();

        verifyInformationColumn(footerComponent.informationColumnComponent());
        verifyCustomerService(footerComponent.customerServiceColumnComponent());
        verifyAccountColumn(footerComponent.myAccountColumnComponent());
        verifyFollowUsColumn(footerComponent.followUsColumnComponent());
    }

    private void verifyInformationColumn(FooterColumnComponent footerColumnComponent) {
        String baseUrl = Urls.demoBaseUrl;
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use",
                "About us", "Contact us");
        List<String> expectedHrefs = Arrays.asList(
                baseUrl + "/sitemap", baseUrl + "/shipping-returns", baseUrl + "/privacy-policy", baseUrl + "/conditions-of-use",
                baseUrl + "/about-us", baseUrl + "/contactus");
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyCustomerService(FooterColumnComponent footerColumnComponent) {
        String baseUrl = Urls.demoBaseUrl;
        List<String> expectedLinkTexts = Arrays.asList(
                "Search", "News", "Blog", "Recently viewed products",
                "Compare products list", "New products");
        List<String> expectedHrefs = Arrays.asList(
                baseUrl + "/search", baseUrl + "/news", baseUrl + "/blog", baseUrl + "/recentlyviewedproducts",
                baseUrl + "/compareproducts", baseUrl + "/newproducts");
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyAccountColumn(FooterColumnComponent footerColumnComponent) {
    }

    private void verifyFollowUsColumn(FooterColumnComponent footerColumnComponent) {
    }

    private void verifyFooterColumn(FooterColumnComponent footerColumnComponent,
                                    List<String> expectedLinkTests, List<String> expectedHrefs) {
        List<String> actualLinkTests = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();
        for (WebElement link : footerColumnComponent.linksElem()) {
            actualLinkTests.add(link.getText().trim());
            actualHrefs.add(link.getAttribute("href"));
        }
        if(actualHrefs.isEmpty() || actualHrefs.isEmpty()) {
            Assert.fail("Text || Href is empty");
        }

        //verify link text
        Assert.assertEquals(actualLinkTests, expectedLinkTests, "[ERR] Actual and Expected Link Texts are different");

        //verify hrefs
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Actual and Expected Href are different");
    }
}
