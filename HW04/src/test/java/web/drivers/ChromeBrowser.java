package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeBrowser {
    // Получение экземпляра драйвера браузера "Google Chrome"
    public static WebDriver getDriver(String loadStrategy) {
        // Настройка исполняемого файла драйвера
        WebDriverManager.chromedriver().setup();

        // Опции драйвера:
        ChromeOptions options = new ChromeOptions();
        // - прием небезопасных сертификатов = true
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        // - стратегия загрузки страницы
        options.setPageLoadStrategy(PageLoadStrategy.valueOf(loadStrategy));
        // - режим "Инкогнито"
        options.addArguments("--incognito");
        // - режим "Полный экран"
        options.addArguments("--start-fullscreen");

        // Новый экземпляр драйвера
        return new ChromeDriver(options);
    }
}