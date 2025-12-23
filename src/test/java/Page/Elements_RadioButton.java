package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements_RadioButton extends BaseTest {

    public Elements_RadioButton() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "label[for='yesRadio']")
    public WebElement yesRadioButton;

    @FindBy(css = "label[for='impressiveRadio']")
    public WebElement impressiveRadioButton;

    @FindBy(id = "noRadio")
    public WebElement noRadioButton;

    @FindBy(css = "p.mt-3")
    public WebElement textResult;

    //------------------------

    public void clickOnYesRadio () {
        yesRadioButton.click();
    }

    public void clickOnImpressiveRadio() {
        impressiveRadioButton.click();
    }

    public boolean noRadioButtonIsDisabled() {
        return !noRadioButton.isEnabled();
    }

    public String resultText() {
        return textResult.getText();
    }


}
