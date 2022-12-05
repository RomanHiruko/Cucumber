package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.pages.AppliancesPage;

public class AppliancesPageSteps {
    private static final Logger logger = LogManager.getLogger(AppliancesPageSteps.class);
    private AppliancesPage appliancesPage;

    @Когда("Открыта страница \"Бытовая техника\"")
    public void openAppliancesPage() {
        appliancesPage = new AppliancesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Бытовая техника]: Открыта страница \"Бытовая техника\"");
    }

    @Тогда("Проверка: Отображается текст \"Бытовая техника\"")
    public void textAppliancesDisplayed() {
        Assertions.assertTrue(appliancesPage.textAppliances().isDisplayed(),
                "Текст \"Бытовая техника\" не отображается!");
        logger.info("Текст \"Бытовая техника\" отображается");
    }

    @Когда("Выполнен переход на страницу \"Техника для кухни\"")
    public void goToKitchenAppliances() {
        appliancesPage.linkKitchenAppliances().click();
        logger.info("Выполнен переход на страницу Техника для кухни");
    }
}
