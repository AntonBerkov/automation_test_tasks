package framework.test;

import framework.driver.DriverSingleton;
import framework.model.CalculatorInstances;
import framework.page.CalculatePage;
import framework.page.HomeCloudPage;
import framework.page.SearchResultCloudPage;
import framework.service.InstanceCreator;
import framework.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected CalculatePage calculatePage;
    private static final String CALCULATOR_WEBSITE = "Google Cloud Platform Pricing Calculator";
    private Logger logger = LogManager.getRootLogger();

    @BeforeMethod
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
        createPage();
    }

    private void createPage() {
        CalculatorInstances calculatorInstances = InstanceCreator.generateInstances();
        new HomeCloudPage(driver)
                .openPage()
                .searchCalculator(CALCULATOR_WEBSITE);
        new SearchResultCloudPage(driver)
                .enterCalculatorPage();
        calculatePage = new CalculatePage(driver)
                .fillForm(calculatorInstances);
        logger.info("Calculating page created");

    }

    @AfterMethod(alwaysRun = true)
    public void browserShutdown() {
        DriverSingleton.closeDriver();
    }
}
