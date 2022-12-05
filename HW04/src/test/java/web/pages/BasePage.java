package web.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.elements.Block;
import web.helpers.*;

import java.time.Duration;

public class BasePage {
    @FindBy(xpath = "//header")
    private WebElement blockHeader;

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        WaitHelper.init(driver, Duration.ofSeconds(15), Duration.ofMillis(100));
        JavaScriptHelper.init(driver);
        ActionHelper.init(driver);
        NavigationHelper.init(driver);
        WindowHelper.init(driver);
        SwitchHelper.init(driver);
        ScreenshotHelper.init(driver);
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    public String getURL() {
        String URL = driver.getCurrentUrl();
        return URL;
    }

    public Dimension getSize() {
        Dimension size = driver.manage().window().getSize();
        return size;
    }

    public static int getY() {
        int currY = driver.manage().window().getPosition().getY();
        return currY;
    }

    public Block blockHeader() {
        return new Block(blockHeader);
    }
}
