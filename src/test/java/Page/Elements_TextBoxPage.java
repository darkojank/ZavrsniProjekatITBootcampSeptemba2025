package Page;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements_TextBoxPage extends BaseTest {

    public Elements_TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "output")
    public List<WebElement> outputResult;

    //----------Output

    @FindBy(id = "name")
    public WebElement outputName;

    @FindBy(id = "email")
    public WebElement outputEmail;

    @FindBy(css = "p[id='currentAddress']")
    public WebElement outputAddress;

    @FindBy(css = "p[id='permanentAddress']")
    public WebElement outputPermanentAddress;



    public List<WebElement> getOutputParagraphs() {
        return driver.findElements(By.cssSelector("#output p"));
    }


    //--------------------------------



    public void inputFullName(String nameFull) {
        fullName.clear();
        fullName.sendKeys(nameFull);
    }

    public void inputEmail(String emailAddress) {
        email.clear();
        email.sendKeys(emailAddress);
    }

    public void inputCurrentAddress(String addressCurrent) {
        currentAddress.clear();
        currentAddress.sendKeys(addressCurrent);
    }

    public void inputPermanentAddress(String addressPermanent) {
        permanentAddress.clear();
        permanentAddress.sendKeys(addressPermanent);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public boolean checkOutputResult(String fieldToCheck) {
        for(int i =0; i<outputResult.size(); i++) {
            if(outputResult.get(i).getText().equals(fieldToCheck)) {
                outputResult.get(i).isDisplayed();
                return true;
            }
        }
        return false;
    }

    public boolean isEmailFieldInvalid() {
        return email.getAttribute("class").contains("field-error");
    }

    public boolean isOutputEmailPresent() {
        return !driver.findElements(By.id("email")).isEmpty();
    }




}
