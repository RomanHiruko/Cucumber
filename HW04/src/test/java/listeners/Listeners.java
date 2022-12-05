package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listeners implements WebDriverListener {
    private final Logger logger = LogManager.getLogger(Listeners.class);

    @Override
    public void afterClick(WebElement element) {
        logger.info("Нажата кнопка");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("Найден элемент");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        logger.info("Получен текст");
    }
}