package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.pages.KettlesPage;

public class ElectricKettlesSteps {
    private static Logger logger = LogManager.getLogger(ElectricKettlesSteps.class);

    // Ссылка на объект класса StartPage
    // Страница "Стартовая страница сайта DNS"
    private KettlesPage kettlesPage;

    @Когда("Открыта страница \"Электрочайники\"")
    public void openKettlesPage() {
        kettlesPage = new KettlesPage(WebDriverFactory.getCurrentDriver());
        logger.info("\"Страница [Электрочайники]: Открыта страница \"Электрочайники\"");
    }

    @Тогда("Проверка: Количество продуктов по ссылке \"Электрочайники\" больше 1000")
    public void productCount() {
        String countProduct = kettlesPage.textProductCount().getText();
        int count = Integer.parseInt(countProduct.split(" ")[0]);
        Assertions.assertTrue(count > 1000,
                "в тексте Электрические чайники [количество] товаров количество товаров меньше или равно 1000");
    }
}
