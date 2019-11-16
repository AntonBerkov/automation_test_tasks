package seleniumWebDriver.hardcore.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudHomePage extends AbstractPage {
    private String HOMEPAGE_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchContent;

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CloudHomePage searchCalculator(String searchForCalculatorString) {
        searchContent.click();
        searchContent.sendKeys(searchForCalculatorString);
        searchContent.sendKeys(Keys.ENTER);
        return this;
    }
}
