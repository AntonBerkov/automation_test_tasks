package seleniumWebDriver.hardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumWebDriver.hardcore.page.CalculatorPage;
import seleniumWebDriver.hardcore.page.CloudHomePage;
import seleniumWebDriver.hardcore.page.CloudSearchResultPage;
import seleniumWebDriver.hardcore.page.EmailPage;


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
    public void checkForEmailTotalCost() {
        String calculatorTotalCost = calculatorPage.searchTotalCost();
        EmailPage emailPage = new EmailPage(driver).openPage();
        String emailTotalCost = emailPage.searchEmailTotalCost();
        Assert.assertEquals(calculatorTotalCost, emailTotalCost);
    }

    @AfterMethod
    public void browserShutdown() {
        driver.quit();
        driver = null;
    }
}
