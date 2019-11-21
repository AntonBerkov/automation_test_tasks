package seleniumWebDriver.hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPage extends AbstractPage {
    private int TIME_TO_WAIT = 30;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage fillForm(String numberOfInstances) {
        final String iconXpath = "//*[@class='md-select-icon']";
        final String computeEngineButton = "//*[@class='hexagon-in2']";
        final String numberofInstancesField = "//*[@name='quantity']";
        final String softwareOption = "//*[@value='free']";
        final String machineClassOption = "//*[@value='regular']";
        final String machineTypeOption = "select_option_217";
        final String numberOfGpusOption = "select_option_353";
        final String gpuTypeOption = "select_option_360";
        final String localSsdOption = "select_option_171";
        final String datacenterLocationOption = "select_option_185";
        final String commitedUsageOption = "select_option_83";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().frame("myFrame");
        driver.findElements(By.xpath(computeEngineButton)).get(0).click();
        driver.findElements(By.xpath(numberofInstancesField)).get(0).sendKeys(numberOfInstances);
        List<WebElement> selectIcon = driver.findElements(By.xpath(iconXpath));
        selectIcon.get(0).click();
        driver.findElement(By.xpath(softwareOption)).click();
        selectIcon.get(1).click();
        driver.findElements(By.xpath(machineClassOption)).get(1).click();
        selectIcon.get(4).click();
        componentWaiter(By.id(machineTypeOption)).click();
        List<WebElement> checkButtonGpu = driver.findElements(By.xpath("//*[@class='md-container md-ink-ripple']"));
        new WebDriverWait(driver, TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(checkButtonGpu.get(0)));
        checkButtonGpu.get(0).click();
        List<WebElement> selectGpu = driver.findElements(By.xpath(iconXpath));
        selectGpu.get(5).click();
        componentWaiter(By.id(numberOfGpusOption)).click();
        selectGpu.get(6).click();
        componentWaiter(By.id(gpuTypeOption)).click();

        jse.executeScript("arguments[0].clickOnElementJs();", selectGpu.get(7));
        new WebDriverWait(driver, TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(selectGpu.get(7)));
        jse.executeScript("arguments[0].clickOnElementJs();", selectGpu.get(7));

        componentWaiter(By.id(localSsdOption)).click();
        selectGpu.get(8).click();
        componentWaiter(By.id(datacenterLocationOption)).click();
        selectGpu.get(9).click();
        componentWaiter(By.id(commitedUsageOption)).click();
        List<WebElement> addToEstimateButton = driver.findElements(By.xpath("//*[@aria-label='Add to Estimate']"));
        new WebDriverWait(driver, TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(addToEstimateButton.get(0)));
        addToEstimateButton.get(0).click();
        String emailAdress = createEmail();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame("myFrame");
        driver.findElement(By.id("email_quote")).click();
        componentWaiter(By.xpath("//*[@ng-model='emailQuote.user.email']")).sendKeys(emailAdress);
        componentWaiter(By.xpath("//*[@aria-label='Send Email']")).click();
        return this;
    }

    private WebElement componentWaiter(By xpath) {
        return new WebDriverWait(driver, TIME_TO_WAIT)
                .until(ExpectedConditions.elementToBeClickable(xpath));
    }

    private String createEmail() {
        EmailPage emailPage = new EmailPage(driver).openPage();
        return emailPage.searchEmailAdress();

    }

    public String searchTotalCost() {
        return splitContentValue(driver.findElements(By.xpath("//*[@class='md-title']")).get(5).getText());
    }

    private String splitContentValue(String value) {
        String ssdSpace = "Total available local SSD space ";
        String perMonthInfo = " per 1 month";
        for (int i = 0; i < value.length(); i++) {
            if (value.contains(ssdSpace)) {
                value = value.replaceAll(ssdSpace, "");
            }
            if (value.charAt(i) == ':') {
                value = value.substring(i + 2);
            }
            if (value.contains(perMonthInfo)) {
                value = value.replaceAll(perMonthInfo, "");
            }
        }
        return value;
    }

}
