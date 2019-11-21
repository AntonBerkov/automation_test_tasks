package framework.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeCloudPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchContent;

    public HomeCloudPage(WebDriver driver) {
        super(driver);
    }

    public HomeCloudPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public HomeCloudPage searchCalculator(String searchForCalculatorString) {
        toBeClickableWaiter(searchContent).click();
        toBeClickableWaiter(searchContent).sendKeys(searchForCalculatorString);
        toBeClickableWaiter(searchContent).sendKeys(Keys.ENTER);
        return this;
    }
}
