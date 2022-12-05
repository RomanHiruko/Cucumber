package web.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    // Логгер
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);
    // Драйвер
    private static WebDriver driver;

    // Получение экземпляра драйвера по имени
    public static WebDriver getDriver(BrowserName name, String loadStrategy) {
        switch (name) {
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                driver = ChromeBrowser.getDriver(loadStrategy);
                break;
            // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                driver = FirefoxBrowser.getDriver(loadStrategy);
                break;
            // Драйвер браузера Microsoft Edge
            case EDGE:
                logger.info("Драйвер браузера Microsoft Edge");
                driver = EdgeBrowser.getDriver(loadStrategy);
                break;
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
        return driver;
    }

    // Получение уже созданного экземпляра драйвера
    public static WebDriver getCurrentDriver() {
        return driver;
    }
}