package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;
import web.pages.KitchenAppliancesPage;

import java.util.List;

public class KitchenAppliancesPageSteps {
    private static final Logger logger = LogManager.getLogger(KitchenAppliancesPageSteps.class);
    private KitchenAppliancesPage kitchenAppliancesPage;

    @Тогда("Проверка: Отображаются ссылки на странице Техника для кухни")
    public void textDisplayed(List<String> args) {
        WebDriver driver = WebDriverFactory.getCurrentDriver();
        for (String element : args) {
            WebElement el = driver.findElement(By.xpath("//div[@class='subcategory']" +
                    "//*[text()=\"" + element + "\"]"));
            Assertions.assertTrue(el.isDisplayed(), "Текст " + el.getText() + " не отображается!");
        }
        logger.info("Текст \"Техника для кухни\" и \"Собери свою кухню\" отображаются");
    }

    @Когда("Открыта страница \"Техника для кухни\"")
    public void openKitchenAppliances() {
        kitchenAppliancesPage = new KitchenAppliancesPage(WebDriverFactory.getCurrentDriver());
        logger.info("\"Страница [Техника для кухни]: Открыта страница \"Техника для кухни\"");
    }

    @Когда("Выведены названия всех категорий")
    public void displayAllCategories() {
        kitchenAppliancesPage.allCategories();
    }
}
