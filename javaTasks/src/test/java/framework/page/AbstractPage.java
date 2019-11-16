package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    private static final int TIME_TO_WAIT = 120;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement componentWaiter(WebElement webElement) {
        return new WebDriverWait(driver, TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
