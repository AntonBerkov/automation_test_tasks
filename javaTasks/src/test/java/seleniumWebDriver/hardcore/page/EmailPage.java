package seleniumWebDriver.hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class EmailPage extends AbstractPage {

    private String EMAIL_URL = "https://10minutemail.com";

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage openPage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(EMAIL_URL);
        return this;
    }

    public String searchEmailAdress() {
        return driver.findElement(By.id("mailAddress")).getAttribute("value");
    }

    public String searchEmailTotalCost() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("ui-id-1")));
        WebElement emailBar = driver.findElement(By.id("ui-id-1"));
        emailBar.click();
        String emailTotalCost = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Estimated Monthly Cost:')]"))).getText();
        return emailTotalCostSplit(emailTotalCost);
    }

    private String emailTotalCostSplit(String emailTotalCost) {
        return emailTotalCost.replaceAll("Estimated Monthly Cost: ", "");
    }
}
