package web.elements;

import web.helpers.ActionHelper;
import org.openqa.selenium.WebElement;

public class BaseElement {
    protected WebElement webElement;

    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void focusOnLink() {
        ActionHelper.moveToElement(webElement);
    }
}
