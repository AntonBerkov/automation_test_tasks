package framework.page;

import framework.util.JsScripts;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class MailPage extends AbstractPage {

    @FindBy(id = "email_quote")
    private WebElement emailQuote;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement userMailQuote;

    @FindBy(id = "mailAddress")
    private WebElement mailAdress;

    @FindBy(xpath = "//*[@aria-label='Send Email']")
    private WebElement sendMail;

    @FindBy(id = "ui-id-1")
    private WebElement emailBar;

    @FindBy(xpath = "//*[contains(text(),'Estimated Monthly Cost:')]")
    private WebElement monthlyCost;

    private static final String EMAIL_URL = "https://10minutemail.com";
    private static final String MAIN_FRAME = "myFrame";
    private static final String VALUE = "value";
    private static final String ESTIMATED_MONTHLY_COST = "Estimated Monthly Cost: ";

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void sendMail() {
        openPage();
        String emailAdress = searchEmailAdress();
        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        if (System.getProperty("browser").equals("chrome")) {
            driver.switchTo().frame(MAIN_FRAME);
        }
        emailQuote.click();
        userMailQuote.sendKeys(emailAdress);
        toBeClickableWaiter(sendMail);
        JsScripts.clickOnElementJs(driver, sendMail);
    }

    public MailPage openPage() {
        JsScripts.openWindowJs(driver);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get(EMAIL_URL);
        return this;
    }

    public String searchEmailAdress() {
        return mailAdress.getAttribute(VALUE);
    }

    public String searchEmailTotalCost() {
        JsScripts.scrollDownJs(driver);
        emailWaiter(emailBar).click();

        String emailTotalCost = emailWaiter(monthlyCost).getText();
        return emailTotalCostSplit(emailTotalCost);
    }

    private String emailTotalCostSplit(String emailTotalCost) {
        return emailTotalCost.replaceAll(ESTIMATED_MONTHLY_COST, "");
    }
}
