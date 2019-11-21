package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    private static final int TIME_TO_WAIT = 30;
    private static final int EMAIL_TIME_TO_WAIT = 120;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement toBeClickableWaiter(WebElement webElement) {
        return new WebDriverWait(driver, TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement emailWaiter(WebElement webElement) {
        return new WebDriverWait(driver, EMAIL_TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void presenceOfElementsWaiter(String xpath) {
        new WebDriverWait(driver, TIME_TO_WAIT)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }
}
