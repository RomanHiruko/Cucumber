package web.pages;

import web.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppliancesPage extends BasePage {
    private Logger logger = LogManager.getLogger(AppliancesPage.class);

    @FindBy(xpath = "//label[text()='Техника для кухни']/..")
    private WebElement linkKitchenAppliances;

    @FindBy(xpath = "//h1[text()='Бытовая техника']")
    private WebElement textAppliances;


    public AppliancesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Link linkKitchenAppliances() {
        return new Link(linkKitchenAppliances);
    }

    public Link textAppliances() {
        return new Link(textAppliances);
    }
}
