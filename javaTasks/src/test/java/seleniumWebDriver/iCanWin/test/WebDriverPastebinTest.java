package seleniumWebDriver.iCanWin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumWebDriver.iCanWin.page.PastebinHomePage;

public class WebDriverPastebinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Send info to pastebin")
    public void createNewPaste() {
        new PastebinHomePage(driver)
                .openPage()
                .sendContent("Hello from WebDriver", "helloweb");
    }

    @AfterMethod(alwaysRun = true)
    public void browserShutdown() {
        driver.quit();
        driver = null;
    }
}
