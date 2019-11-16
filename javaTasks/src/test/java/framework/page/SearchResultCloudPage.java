package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultCloudPage extends AbstractPage {
    @FindBy(xpath = "//*[@class='gs-title']")
    List<WebElement> RESULT_CONTENT;

    public SearchResultCloudPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultCloudPage enterCalculatorPage() {
        componentWaiter(RESULT_CONTENT.get(1)).click();
        return this;
    }
}
