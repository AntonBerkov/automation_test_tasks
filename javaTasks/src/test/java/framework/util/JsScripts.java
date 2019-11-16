package framework.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsScripts {
    public static JavascriptExecutor click;

    public static void executeJs(WebDriver driver, WebElement webElement, String jsAction) {
        click = (JavascriptExecutor) driver;
        click.executeScript(jsAction, webElement);
    }

    public static void executeJs(WebDriver driver, String jsAction) {
        click = (JavascriptExecutor) driver;
        click.executeScript(jsAction);
    }

}
