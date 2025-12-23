package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindows_Alerts extends BaseTest {

    public AlertsFrameWindows_Alerts()  {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="alertButton")
    public WebElement alertButton;

    @FindBy(id ="timerAlertButton")
    public WebElement timeAlertButton;

    @FindBy(id ="confirmButton")
    public WebElement confirmButton;

    @FindBy(id ="promtButton")
    public WebElement promtButton;

    @FindBy(className = "text-success")
    public WebElement successMessage;

    //------------------------------------

    public void clickOnAlertButton() {
        alertButton.click();
    }

    public void clickOnTimerAlertButton() {
        timeAlertButton.click();
        setAsyncTimeout(5);
    }

    public void clickOnConfirmButton() {
        confirmButton.click();
    }

    public void clickOnPromptButton() {
        promtButton.click();
    }




}
