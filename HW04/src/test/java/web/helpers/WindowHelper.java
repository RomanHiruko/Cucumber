package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class WindowHelper {
    private static Logger logger = LogManager.getLogger(WindowHelper.class);
    private static WebDriver window;

    public static void init(WebDriver driver) {
        window = driver;
    }

    public static void maximizeWindow() {
        window.manage().window().maximize();
    }

    public static void minimizeWindow() {
        window.manage().window().minimize();
    }

    public static void fullscreenWindow() {
        window.manage().window().fullscreen();
    }

    public static Point getWindowPosition() {
        return window.manage().window().getPosition();
    }

    public static void setWindowPosition(Point point) {
        window.manage().window().setPosition(point);
    }

    public static Dimension getWindowSize() {
        return window.manage().window().getSize();
    }

    public static String getWindowHandle() {
        return window.getWindowHandle();
    }

    public static void setWindowSize(Dimension dimension) {
        window.manage().window().setSize(dimension);
    }
}
