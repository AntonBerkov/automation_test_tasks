package seleniumWebDriver.hurtMePlenty.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumWebDriver.hurtMePlenty.page.CalculatorPage;
import seleniumWebDriver.hurtMePlenty.page.CloudSearchResultPage;
import seleniumWebDriver.hurtMePlenty.page.CloudHomePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebDriverCloudTest {
    private WebDriver driver;
    private CalculatorPage calculatorPage;

    @BeforeMethod
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        createPage();
    }

    private void createPage() {
        new CloudHomePage(driver)
                .openPage()
                .searchCalculator("Google Cloud Platform Pricing Calculator");
        new CloudSearchResultPage(driver)
                .enterCalculatorPage();
        calculatorPage = new CalculatorPage(driver)
                .fillForm("4");
    }

    @Test
    public void checkForContentEquality() {
        List<String> expectedContentInFields = new ArrayList<>(Arrays.asList(
                "regular",
                "n1-standard-8",
                "Frankfurt",
                "2x375 GB",
                "1 Year"
        ));
        List<String> actualContentInFields = calculatorPage.searchContentInFields();
        Assert.assertEquals(actualContentInFields, expectedContentInFields);
    }

    @Test
    public void checkForTotalCostEquality() {
        String automaticTotalCost = calculatorPage.searchTotalCost();
        Assert.assertEquals(automaticTotalCost, "USD 1,082.77 per 1 month");
    }

    @AfterMethod
    public void browserShutdown() {
        driver.quit();
        driver = null;
    }
}
