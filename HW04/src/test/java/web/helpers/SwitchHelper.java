package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class SwitchHelper {
    private static Logger logger = LogManager.getLogger(SwitchHelper.class);
    private static WebDriver switcher;

    public static void init(WebDriver driver) {
        switcher = driver;
    }

    public static void switchToExistWindow(String window) {
        switcher.switchTo().window(window);
    }

    public static void switchToNewWindow() {
        switcher.switchTo().newWindow(WindowType.WINDOW);
    }

    public static void switchToNewTab() {
        switcher.switchTo().newWindow(WindowType.TAB);
    }

    public static void switchAlert() {
        switcher.switchTo().alert();
    }

    public static void switchToFrameByIndex(int index) {
        switcher.switchTo().frame(index);
    }

    public static void switchToFrameByNameOrId(String nameOrId) {
        switcher.switchTo().frame(nameOrId);
    }

    public static void switchToFrameByFrameWebElement(WebElement element) {
        switcher.switchTo().frame(element);
    }

    public static void switchToDefaultContent() {
        switcher.switchTo().defaultContent();
    }

    public static void switchToParentFrame() {
        switcher.switchTo().parentFrame();
    }

    public static void switchToActiveWebElement() {
        switcher.switchTo().activeElement();
    }
}
