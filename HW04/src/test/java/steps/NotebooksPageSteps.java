package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.pages.NotebooksPage;

public class NotebooksPageSteps {
    private static final Logger logger = LogManager.getLogger(NotebooksPageSteps.class);
    private NotebooksPage notebooksPage;

    @Дано("Открыта страница \"Ноутбуки\"")
    public void openNotebooksPage() {
        notebooksPage = new NotebooksPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Смартфоны]: Открыта страница \"Ноутбуки\"");
    }

    @Когда("Установлена сортировка {string}")
    public void orderBy(String type) {
        // Отображение сортировки
        notebooksPage.accordeonSort().show();
        // Установка сортировки
        notebooksPage.radioButtonSort(type).setSelected(true);
        logger.info("Страница [Смартфоны]: Установлена сортировка \"" + type + "\"");
    }

    @Когда("В фильтре \"Производитель\" выбрано значение {string}")
    public void filterByCompany(String company) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 800);
        // Установка фильтра "Производитель"
        notebooksPage.checkBoxCompany(company).setChecked(true);
        logger.info("Страница [Ноутбуки]: В фильтре \"Производитель\" выбрано значение \"" + company + "\"");
    }

    @Когда("В фильтре \"Объем оперативной памяти\" выбрано значение \"{int} Гб\"")
    public void filterByRAM(int ram) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0, 400);
        // Установка фильтра "Объем оперативной памяти"
        notebooksPage.checkboxRAM(ram + " ГБ").setChecked(true);
        logger.info("Страница [Смартфоны]: В фильтре \"Объем оперативной памяти\" выбрано значение \"" + ram + " Гб\"");
    }

    @Когда("Применены фильтры")
    public void applyFilters() {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Нажатие на кнопку "Применить"
        notebooksPage.buttonApply().click();
        logger.info("Страница [Смартфоны]: Применены фильтры");
    }

    @Когда("Выполнен переход на страницу первого продукта в списке")
    public void goToFirstProduct() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        notebooksPage.linkFirstProduct().openInNewWindow();
        logger.info("Страница [Смартфоны]: Выполнен переход на страницу первого продукта в списке");
    }

    @Тогда("Проверка: Заголовок страницы \"Ноутбуки\" содержит текст \"Ноутбуки\"")
    public void assertPageTitle() {
        Assertions.assertTrue(notebooksPage.getPageTitle().contains("Ноутбуки"),
                "Страница [Смартфоны]: Ошибка! Заголовок страницы \"Ноутбуки\" не содержит текст \"Ноутбуки\"!");
        logger.info("Страница [Смартфоны]: Заголовок страницы \"Ноутбуки\" содержит текст \"Ноутбуки\"");
    }
}
