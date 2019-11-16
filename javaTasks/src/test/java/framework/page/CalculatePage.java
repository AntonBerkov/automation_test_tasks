package framework.page;

import framework.model.CalculatorInstances;
import framework.util.JsScripts;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalculatePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='md-select-icon']")
    List<WebElement> ICON_XPATH;

    @FindBy(xpath = "//*[@class='hexagon-in2']")
    List<WebElement> COMPUTE_ENGINE_BUTTON;

    @FindBy(xpath = "//*[@name='quantity']")
    List<WebElement> NUMBER_OF_INSTANCES_FIELD;

    @FindBy(xpath = "//*[@class='md-container md-ink-ripple']")
    List<WebElement> CHECK_GPU;

    @FindBy(id = "select_option_353")
    WebElement NUMBER_OF_GPUS_OPTION;

    @FindBy(id = "select_option_360")
    WebElement GPU_TYPE_OPTION;

    @FindBy(id = "select_option_171")
    WebElement LOCAL_SSD_OPTION;

    @FindBy(id = "select_option_83")
    WebElement COMMITED_USAGE_OPTION;

    @FindBy(xpath = "//*[@aria-label='Add to Estimate']")
    List<WebElement> ADD_TO_ESTIMATE;

    @FindBy(xpath = "//*[@class='md-title']")
    List<WebElement> TOTAL_COST;

    private static final String MAIN_FRAME = "myFrame";
    private static final String SCROLL_INTO_VIEW = "arguments[0].scrollIntoView();";
    private static final String ClICK_ON_ELEMENT = "arguments[0].click();";
    private static final String TOTAL_ESTIMATED_COST = "Total Estimated Cost: ";
    private static final String PER_MONTH_INFO = " per 1 month";

    public CalculatePage(WebDriver driver) {
        super(driver);
    }


    public CalculatePage fillForm(CalculatorInstances instances) {
        driver.switchTo().frame(MAIN_FRAME);
        COMPUTE_ENGINE_BUTTON.get(0).click();
        NUMBER_OF_INSTANCES_FIELD.get(0).sendKeys(instances.getNumberOfInstances());
        selectIconOptions(instances);
        componentWaiter(driver.findElement(By.id(instances.getMachineType()))).click();
        componentWaiter(CHECK_GPU.get(0)).click();
        selectGpuOPtions(instances);
        componentWaiter(COMMITED_USAGE_OPTION).click();
        componentWaiter(ADD_TO_ESTIMATE.get(0)).click();
        MailPage mailPage = new MailPage(driver);
        mailPage.sendMail();
        return this;
    }

    public void selectIconOptions(CalculatorInstances instances) {
        ICON_XPATH.get(0).click();
        componentWaiter(driver.findElement(By.xpath(instances.getSoftware()))).click();
        ICON_XPATH.get(1).click();
        componentWaiter(driver.findElements(By.xpath(instances.getMachineClass())).get(1)).click();
        ICON_XPATH.get(4).click();
    }

    public void selectGpuOPtions(CalculatorInstances instances) {
        ICON_XPATH.get(5).click();
        componentWaiter(NUMBER_OF_GPUS_OPTION).click();
        JsScripts.executeJs(driver, ICON_XPATH.get(6), ClICK_ON_ELEMENT);
        componentWaiter(GPU_TYPE_OPTION).click();
        JsScripts.executeJs(driver, ICON_XPATH.get(7), SCROLL_INTO_VIEW);
        componentWaiter(ICON_XPATH.get(7));
        JsScripts.executeJs(driver, ICON_XPATH.get(7), ClICK_ON_ELEMENT);
        componentWaiter(LOCAL_SSD_OPTION).click();
        ICON_XPATH.get(8).click();
        componentWaiter(driver.findElement(By.id(instances.getLocation()))).click();
        ICON_XPATH.get(9).click();

    }

    public String searchTotalCost() {
        return splitContentValue(TOTAL_COST.get(5).getText());
    }

    public static String splitContentValue(String value) {
        if (value.contains(TOTAL_ESTIMATED_COST)) {
            value = value.replaceAll(TOTAL_ESTIMATED_COST, "");
        }
        if (value.contains(PER_MONTH_INFO)) {
            value = value.replaceAll(PER_MONTH_INFO, "");
        }
        return value;
    }

}
