package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindows_BrowserWindows extends BaseTest {

    public AlertsFrameWindows_BrowserWindows () {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;

    @FindBy(id = "messageWindowButton")
    public WebElement newWindowMessage;

    //-------------------------------

    public void clickOnNewTabButton() {
        newTabButton.click();
    }

    public void clickOnNewWindowButton() {
        newWindowButton.click();
    }

    public void clickOnNewWindowMessageButton() {
        newWindowMessage.click();
    }
}
