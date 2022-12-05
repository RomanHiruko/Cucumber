package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.elements.Link;
import web.helpers.JavaScriptHelper;
import web.pages.NotebookPage;

public class NotebookProductPageSteps {
    private static Logger logger = LogManager.getLogger(NotebookProductPageSteps.class);
    private NotebookPage notebookPage;

    @Дано("Открыта страница \"Продукт. Ноутбук\"")
    public void openSmartphoneProductPage() {
        notebookPage = new NotebookPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Продукт. Ноутбук]: Открыта страница \"Продукт. Ноутбук\"");
    }

    @Тогда("Проверка: Заголовок страницы \"Продукт. Ноутбук\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(notebookPage.getPageTitle().contains(text),
                "Ошибка! Заголовок страницы не соответствует заголовку первого продукта из списка!");
        logger.info("Страница [Продукт. Ноутбук]: Заголовок страницы соответствует заголовку первого продукта из списка!");
    }

    @Тогда("Проверка: Характеристики содержат значения {string} и {string}")
    public void linkContainsValue(String text, String ram) {
        Link[] links = {notebookPage.textDescription(), notebookPage.textRam()};
        String[] values = {text, ram};
        for (int i = 0; i < links.length; i++) {
            Assertions.assertTrue(links[i].getText().contains(values[i]), "Текст " + links[i].getText() + " не содержит значение " + values[i]);
        }
    }

    @Когда("Развернуто описание")
    public void buttonExpand() {
        JavaScriptHelper.scrollBy(0, 800);
        notebookPage.buttonExpand().click();
        JavaScriptHelper.scrollBy(0, -2000);
    }
}
