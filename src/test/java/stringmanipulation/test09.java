package stringmanipulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class test09 {
    public static void main(String[] args) {
        String prjLocation = System.getProperty("user.dir");
        String chromeLocation = "/src/test/resources/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", prjLocation + chromeLocation);
        WebDriver driver = new ChromeDriver();
        driver.get("https://recruiting2.ultipro.com/MGA1000MGAI/JobBoard/953bfe27-d30f-43cd-bfda-f7e21bb80ed1/?q=&o=postedDateDesc&w=&wc=&we=&wpst=");

        List<WebElement> jobTitleElemList = driver.findElements(By.xpath("(//a[@data-automation='job-title'])"));
        for(int i = 0; i < jobTitleElemList.size(); i ++) {
            WebElement jobTitleElem = jobTitleElemList.get(i);
            System.out.println(jobTitleElem.getText());
        }

        List<WebElement> featuredOpportunityList = driver.findElements(By.xpath("//table[@id='FeaturedOpportunities']//a/div/strong"));
        for(int i = 0; i < featuredOpportunityList.size(); i ++) {
            WebElement jobFeaturedElem = featuredOpportunityList.get(i);
            System.out.println(jobFeaturedElem.getText());
        }
        driver.quit();
    }
}
