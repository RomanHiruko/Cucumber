package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;

import java.util.ArrayList;
import java.util.List;

public class KitchenAppliancesPage extends BasePage {
    private Logger logger = LogManager.getLogger(KitchenAppliancesPage.class);

    @FindBy(xpath = "//a[text()='Собрать свою кухню']")
    private WebElement linkMakeKitchen;

    @FindBy(xpath = "//div[@class='subcategory__item-container ']/a")
    private List<WebElement> linksSubCategories;

    @FindBy(xpath = "//h1[text()='Техника для кухни']")
    private WebElement textKitchenAppliances;

    public KitchenAppliancesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> linksSubCategories() {
        return new ArrayList<>(linksSubCategories);
    }

    public void allCategories() {
        List<WebElement> elements = this.linksSubCategories;
        for (WebElement element : elements) {
            logger.info(element.getText());
        }
    }

    public Link linkMakeKitchen() {
        return new Link(linkMakeKitchen);
    }

    public Link textKitchenAppliances() {
        return new Link(textKitchenAppliances);
    }
}
