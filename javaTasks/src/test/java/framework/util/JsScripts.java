package framework.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsScripts {
    private static JavascriptExecutor executor;
    private static final String SCROLL_INTO_VIEW = "arguments[0].scrollIntoView();";
    private static final String ClICK_ON_ELEMENT = "arguments[0].click();";
    private static final String SCROLL_DOWN = "window.scrollTo(0, document.body.scrollHeight)";
    private static final String JS_OPEN_WINDOW = "window.open();";

    public static void clickOnElementJs(WebDriver driver, WebElement webElement) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript(ClICK_ON_ELEMENT, webElement);
    }

    public static void scrollIntoViewJs(WebDriver driver, WebElement webElement) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript(SCROLL_INTO_VIEW, webElement);
    }

    public static void scrollDownJs(WebDriver driver) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript(SCROLL_DOWN);
    }

    public static void openWindowJs(WebDriver driver) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript(JS_OPEN_WINDOW);
    }

}
