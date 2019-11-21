package framework.page;

import framework.model.CalculatorInstances;
import framework.util.JsScripts;
import framework.util.XpathConverter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalculatePage extends AbstractPage {

    @FindBy(id = "select_value_label_46")
    private WebElement software;

    @FindBy(id = "select_value_label_47")
    private WebElement machineClass;

    @FindBy(id = "select_value_label_49")
    private WebElement machineType;

    @FindBy(xpath = "//*[@placeholder='Number of GPUs']")
    private WebElement numberOfGpu;

    @FindBy(xpath = "//*[@placeholder='GPU type']")
    private WebElement gpuType;

    @FindBy(id = "select_value_label_50")
    private WebElement localSsd;

    @FindBy(id = "select_value_label_51")
    private WebElement datacenterLocation;

    @FindBy(id = "select_value_label_52")
    private WebElement commitedUsage;


    @FindBy(xpath = "//*[@class='tab-holder compute']")
    private List<WebElement> computeEngineButton;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement checkGpu;

    @FindBy(id = "select_option_353")
    private WebElement numberOfGpusOption;

    @FindBy(id = "select_option_360")
    private WebElement gpuTypeOption;

    @FindBy(id = "select_option_171")
    private WebElement localSsdOption;

    @FindBy(id = "select_option_83")
    private WebElement commitedUsageOption;

    @FindBy(xpath = "//*[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    @FindBy(xpath = "//*[@class='md-title']")
    private List<WebElement> TOTALCOST;

    private static final String MAIN_FRAME = "myFrame";
    private static final String TOTAL_ESTIMATED_COST = "Total Estimated Cost: ";
    private static final String PER_MONTH_INFO = " per 1 month";

    public CalculatePage(WebDriver driver) {
        super(driver);
    }

    public CalculatePage fillForm(CalculatorInstances instances) {
        driver.switchTo().frame(MAIN_FRAME);
        computeEngineButton.get(0).click();
        toBeClickableWaiter(numberOfInstancesField).sendKeys(instances.getNumberOfInstances());
        selectIconOptions(instances);
        toBeClickableWaiter(driver.findElement
                (By.id(XpathConverter.convertMachineType(instances.getMachineType())))).click();
        toBeClickableWaiter(checkGpu).click();
        selectGpuOptions(instances);
        toBeClickableWaiter(commitedUsageOption).click();
        toBeClickableWaiter(addToEstimate).click();
        MailPage mailPage = new MailPage(driver);
        mailPage.sendMail();
        return this;
    }

    public void selectIconOptions(CalculatorInstances instances) {
        software.click();
        toBeClickableWaiter(driver.findElement(By.xpath(XpathConverter.convertSoftware(instances.getSoftware())))).click();
        machineClass.click();
        toBeClickableWaiter(driver.findElements(By.xpath(XpathConverter.convertMachineClass(instances.getMachineClass()))).get(1)).click();
        machineType.click();
    }

    public void selectGpuOptions(CalculatorInstances instances) {

        toBeClickableWaiter(numberOfGpu).click();
        toBeClickableWaiter(numberOfGpusOption).click();
        JsScripts.clickOnElementJs(driver, gpuType);
        toBeClickableWaiter(gpuTypeOption).click();
        JsScripts.scrollIntoViewJs(driver, localSsd);
        toBeClickableWaiter(localSsd);
        JsScripts.clickOnElementJs(driver, localSsd);
        toBeClickableWaiter(localSsdOption).click();
        datacenterLocation.click();
        toBeClickableWaiter(driver.findElement(By.id(XpathConverter.convertLocation(instances.getLocation())))).click();
        commitedUsage.click();
    }

    public String searchTotalCost() {
        return splitContentValue(TOTALCOST.get(5).getText());
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
