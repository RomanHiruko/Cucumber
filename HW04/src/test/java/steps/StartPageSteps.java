package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;
import web.helpers.WaitHelper;
import web.pages.StartPage;

import java.util.List;

// Шаги и проверки на странице "Стартовая"
public class StartPageSteps {
    // Логгер
    private static final Logger logger = LogManager.getLogger(StartPageSteps.class);

    // Ссылка на объект класса StartPage
    // Страница "Стартовая страница сайта DNS"
    private StartPage startPage;

    // Шаг: Открыта страница "Стартовая страница сайта DNS"
    @Дано("Открыта страница \"Стартовая страница сайта DNS\"")
    public void openStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Страница [Стартовая страница DNS]: Открыта \"Стартовая страница сайта DNS\"");
    }

    @Когда("Выполнен переход на страницу \"Ноутбуки\"")
    public void goToNotebooksPage() {
        startPage.linkPcAndPeripheral().focusOnLink();
        startPage.linkNotebooks().click();
        logger.info("Страница [Стартовая страница DNS]: Выполнен переход на страницу \"Ноутбуки\"");
    }

    @Когда("Выполнен переход на страницу \"Бытовая техника\"")
    public void goToAppliances() {
        startPage.linkAppliances().click();
        logger.info("Страница [Стартовая страница DNS]: Выполнен переход на страницу \"Бытовая техника\"");
    }

    @Когда("Выполнено наведение на ссылку \"Бытовая техника\"")
    public void focusAppliancesLink() {
        startPage.linkAppliances().focusOnLink();
    }

    @Когда("Выполнено наведение на ссылку \"Приготовление напитков\"")
    public void focusDrinkPreparationLink() {
        WaitHelper.clickabilityOfElement(startPage.linkDrinksPreparation().getWebElement());
        startPage.linkDrinksPreparation().focusOnLink();
    }

    @Тогда("Проверка: Количество ссылок в подменю Приготовление напитков больше 5")
    public void countLinkDrinkPreparation() {
        int count = startPage.linksSubmenuDrinksPreparation().size();
        Assertions.assertTrue(count > 5, "Количество категорий меньше или равно 5");
        logger.info("Количество категорий больше 5");
    }

    @Тогда("Проверка: Отображаются ссылки на стартовой странице")
    public void linksDisplayed(List<String> args) {
        WebDriver driver = WebDriverFactory.getCurrentDriver();
        for (String element : args) {
            WebElement el = driver.findElement(By.xpath("//a[text()=\"" + element + "\"]"));
            Assertions.assertTrue(el.isDisplayed(), "Ссылка " + el.getText() + " не отображается");
        }
        logger.info("Ссылки отображатся");
    }

    @Когда("Выполнен переход по ссылке \"Электрочайники\"")
    public void goToElectricKettles() {
        WaitHelper.clickabilityOfElement(startPage.linkElectricKettles().getWebElement());
        startPage.linkElectricKettles().click();
    }
}
