package framework.page;

import framework.util.JsScripts;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class MailPage extends AbstractPage {

    @FindBy(id = "email_quote")
    WebElement EMAIL_QUOTE;

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    WebElement USER_MAIL_QUOTE;

    @FindBy(id = "mailAddress")
    WebElement MAIL_ADRESS;

    @FindBy(xpath = "//*[@aria-label='Send Email']")
    WebElement SEND_MAIL;

    @FindBy(id = "ui-id-1")
    WebElement EMAIL_BAR;

    @FindBy(xpath = "//*[contains(text(),'Estimated Monthly Cost:')]")
    WebElement MONTHLY_COST;

    private static final String EMAIL_URL = "https://10minutemail.com";
    private static final String JS_OPEN_WINDOW = "window.open();";
    private static final String MAIN_FRAME = "myFrame";
    private static final String SCROLL_DOWN = "window.scrollTo(0, document.body.scrollHeight)";
    private static final String VALUE = "value";
    private static final String ESTIMATED_MONTHLY_COST = "Estimated Monthly Cost: ";

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void sendMail() {
        openPage();
        String emailAdress = searchEmailAdress();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        tabs.remove(tabs.size() - 1);
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.switchTo().frame(MAIN_FRAME);
        EMAIL_QUOTE.click();
        USER_MAIL_QUOTE.sendKeys(emailAdress);
        SEND_MAIL.click();
    }

    public MailPage openPage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(JS_OPEN_WINDOW);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(EMAIL_URL);
        return this;
    }

    public String searchEmailAdress() {
        return MAIL_ADRESS.getAttribute(VALUE);
    }

    public String searchEmailTotalCost() {
        JsScripts.executeJs(driver, SCROLL_DOWN);
        componentWaiter(EMAIL_BAR).click();

        String emailTotalCost = componentWaiter(MONTHLY_COST).getText();
        return emailTotalCostSplit(emailTotalCost);
    }

    private String emailTotalCostSplit(String emailTotalCost) {
        return emailTotalCost.replaceAll(ESTIMATED_MONTHLY_COST, "");
    }
}
