package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement {
    public TextBox(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    public void setValue(String value) {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.sendKeys(value);
    }
}
