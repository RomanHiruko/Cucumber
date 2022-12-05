package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.*;

import java.util.List;

public class NotebooksPage extends BasePage {
    private Logger logger = LogManager.getLogger(NotebooksPage.class);

    @FindBy(xpath = "//div[@class='products-list__content']")
    private WebElement linkCatalog;

    @FindBy(xpath = "//span[contains(text(), \"Сортировка:\")]/following::a")
    private WebElement accordeonSort;

    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]//span")
    private List<WebElement> radiobuttonSort;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]")
    private WebElement accordeonCompany;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Производитель\"]/../../div//label/span[1]")
    private List<WebElement> checkboxCompany;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()='Объем оперативной памяти (ГБ)']")
    private WebElement accordeonRAM;

    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти (ГБ)\"]/../../div//label/span[1]")
    private List<WebElement> checkboxRAM;

    @FindBy(xpath = "//button[contains(text(), \"Применить\")]")
    private WebElement buttonApply;

    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    private WebElement linkFirstProduct;

    public NotebooksPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public Accordeon accordeonSort() {
        return new Accordeon(accordeonSort);
    }

    public RadioButton radioButtonSort(String type) {
        for (WebElement webElement : radiobuttonSort) {
            if (webElement.getText().contains(type)) {
                return new RadioButton(webElement);
            }
        }
        return null;
    }

    public Accordeon accordeonCompany() {
        return new Accordeon(accordeonCompany);
    }

    public CheckBox checkBoxCompany(String company) {
        for (WebElement webElement : checkboxCompany) {
            if (webElement.getText().contains(company)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }

    public Link linkCatalog() {
        return new Link(linkCatalog);
    }

    public Accordeon accordeonRAM() {
        return new Accordeon(accordeonRAM);
    }

    public CheckBox checkboxRAM(String ram) {
        for (WebElement webElement : checkboxRAM) {
            if (webElement.getText().contains(ram)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }

    public Button buttonApply() {
        return new Button(buttonApply);
    }

    public Link linkFirstProduct() {
        return new Link(linkFirstProduct);
    }
}
