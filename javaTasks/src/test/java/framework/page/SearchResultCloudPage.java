package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SearchResultCloudPage extends AbstractPage {
    private static final String CAlCULATOR_XPATH = "//*[@data-ctorig='https://cloud.google.com/products/calculator/']";
    @FindBy(xpath = CAlCULATOR_XPATH)
    private List<WebElement> resultContent;

    public SearchResultCloudPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultCloudPage enterCalculatorPage() {
        presenceOfElementsWaiter(CAlCULATOR_XPATH);
        resultContent.get(0).click();
        return this;
    }
}
