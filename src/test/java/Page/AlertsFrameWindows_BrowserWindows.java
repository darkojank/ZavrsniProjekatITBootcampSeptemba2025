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

    @FindBy(id = "sampleHeading")
    public WebElement textFromWindow;

    @FindBy(tagName = "body")
    public WebElement bodyForWindowMessage;

    //-------------------------------

    public void clickOnNewTabButton() {
        newTabButton.click();
    }

    public void clickOnNewWindowButton() {
        newWindowButton.click();
    }

    // Prebacuje fokus WebDriver-a na novi prozor/tab koji nije glavni
    public void switchToNewWindow(String mainWindowHandle) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
