package web.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class EdgeBrowser {
    // Получение экземпляра драйвера браузера "Microsoft Edge"
    public static WebDriver getDriver(String loadStrategy) {
        // Настройка исполняемого файла драйвера
        WebDriverManager.edgedriver().setup();

        // Опции драйвера:
        EdgeOptions options = new EdgeOptions();
        // - прием небезопасных сертификатов = true
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        // - стратегия загрузки страницы
        options.setPageLoadStrategy(PageLoadStrategy.valueOf(loadStrategy));
        // - режим "Инкогнито"
        options.addArguments("--incognito");
        // - режим "Полный экран"
        options.addArguments("--start-fullscreen");

        // Новый экземпляр драйвера
        return new EdgeDriver(options);
    }
}