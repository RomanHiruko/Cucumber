package web.elements;

import web.helpers.NavigationHelper;
import web.helpers.SwitchHelper;
import web.helpers.WaitHelper;
import web.helpers.WindowHelper;
import org.openqa.selenium.WebElement;

public class Link extends BaseElement {

    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    public String getAttribute(String attr) {
        return webElement.getAttribute(attr);
    }

    public void openInNewWindow() {
        String URL = this.getURL();
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
    }

    public String getURL() {
        return webElement.getAttribute("href");
    }

    public String getText() {
        return webElement.getText();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public String Text() {
        return webElement.getText();
    }
}
