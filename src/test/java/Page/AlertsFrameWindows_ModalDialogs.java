package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindows_ModalDialogs extends BaseTest {

    public AlertsFrameWindows_ModalDialogs() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="showSmallModal")
    public WebElement smallModalButton;

    @FindBy(id="showLargeModal")
    public WebElement largeModalButton;

    @FindBy(id="closeSmallModal")
    public WebElement closeSmallModalButton;

    @FindBy(id="example-modal-sizes-title-sm")
    public WebElement smallModalTitle;

    @FindBy(id="example-modal-sizes-title-lg")
    public WebElement largeModalTitle;

    @FindBy(css = ".modal-content .modal-body")  //.modal-body je isti lokator za small i za large tekst, pa s' toga koristim samo jedan lokator za oba teksta
    public WebElement modalBodyText;


    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeModalButton;

    //----------------------------

    public void clickOnSmallModalButton() {
        smallModalButton.click();
    }

    public void clickOnLargeModalButton() {
        largeModalButton.click();
    }

    public boolean isSmallModalClosed() {
        try {
            return !closeSmallModalButton.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isLargeModalClosed() {
        try {
            return !closeLargeModalButton.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }




}
