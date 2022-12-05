package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.Keys.END;
import static org.openqa.selenium.Keys.HOME;

public class ScreenshotHelper {
    private static Logger logger = LogManager.getLogger(ScreenshotHelper.class);
    private static WebDriver screen;
    private static int number;

    public static void init(WebDriver driver) {
        screen = driver;
    }

    public static void makeScreenshot() {
        try {
            number += 1;
            Actions actions = new Actions(screen);
            actions
                    .sendKeys(END)
                    .sendKeys(HOME)
                    .perform();
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(screen);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\Screenshot_" + number + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
