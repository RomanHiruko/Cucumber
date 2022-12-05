package web.pages;

import web.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KettlesPage extends BasePage {
    private Logger logger = LogManager.getLogger(KettlesPage.class);

    @FindBy(xpath = "//span[contains(text(),'товар')]")
    private WebElement textCountProduct;

    public KettlesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Link textProductCount() {
        return new Link(textCountProduct);
    }
}
