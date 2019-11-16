package seleniumWebDriver.bringItOn.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PastebinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";
    @FindBy(xpath = "//*[@id= 'paste_code']")
    private WebElement pasteCode;
    @FindBy(xpath = "//*[@class='select2-selection__arrow']")
    private List<WebElement> fieldChoose;
    @FindBy(xpath = "//*[@class='select2-results__option']")
    private List<WebElement> resultChoose;
    @FindBy(xpath = "//*[@name='paste_name']")
    private WebElement pasteName;
    @FindBy(xpath = "//*[@name='submit']")
    private WebElement submitButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinHomePage sendContent(List<String> code, String titleContent) {
        for (String i : code) {
            pasteCode.sendKeys(i);
        }
        fieldChoose.get(0).click();
        resultChoose.get(1).click();
        fieldChoose.get(1).click();
        resultChoose.get(0).click();
        pasteName.sendKeys(titleContent);
        submitButton.click();
        return this;
    }
}
