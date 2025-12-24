package Page;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class Forms_PracticeForm extends BaseTest {

    public Forms_PracticeForm() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement userEmailField;

    @FindBy(css = "label[for*='gender-radio']")
    public List<WebElement> genderLabels;

    @FindBy(css = "input[id*='gender-radio']")
    public List<WebElement> genderInputs;

    @FindBy(id = "userNumber")
    public WebElement userNumberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthField;

    @FindBy(id = "subjectsInput")
    public WebElement subjectField;

    //#subjectsWrapper je id koji se ne menja, dok subject je klasa koja je moguce podlozna promeni
    @FindBy(css = "#subjectsWrapper .subjects-auto-complete__multi-value__label")
    public List<WebElement> subjectTags;

    @FindBy(css = "label[for*='hobbies-checkbox']")
    public List<WebElement> hobbiesLabels;

    @FindBy(css = "input[id*='hobbies-checkbox']")
    public List<WebElement> hobbiesInputs;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "state")
    public WebElement stateDropDown;

    @FindBy(id = "city")
    public WebElement cityDropdown;

    @FindBy(id = "react-select-3-input") // Skriveni input unutar State menija
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input") // Skriveni input unutar City menija
    public WebElement cityInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(className = "modal-content")
    public WebElement submissionModal;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement modalHeader;

    // Lokator za samo telo tabele (gde su svi rezultati)
    @FindBy(className = "table-responsive")
    public WebElement modalTableBody;



    //-----------------------------

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void inputFirstName(String nameFirst) {
        firstNameField.clear();
        firstNameField.sendKeys(nameFirst);
    }

    public void inputLastName(String nameLast) {
        lastNameField.clear();
        lastNameField.sendKeys(nameLast);
    }

    public void inputEmail(String email) {
        userEmailField.clear();
        userEmailField.sendKeys(email);
    }

    // biranje gendera
    public void selectGender(String genderName) {
        for (int i = 0; i < genderLabels.size(); i++) {
            if (genderLabels.get(i).getText().equalsIgnoreCase(genderName)) {
                genderLabels.get(i).click();      // klik na label
                break;
            }
        }
    }

    // asertacija za odabrani gender
    public boolean isGenderSelected(String genderName) {
        for (int i = 0; i < genderLabels.size(); i++) {
            if (genderLabels.get(i).getText().equalsIgnoreCase(genderName)) {
                return genderInputs.get(i).isSelected();
            }
        }
        return false;
    }

    public void inputMobileNumber(String mobileNumber) {
        userNumberField.clear();
        userNumberField.sendKeys(mobileNumber);
    }

    public void inputDateOfBirth(String date){
        dateOfBirthField.sendKeys(Keys.CONTROL + "a");
        dateOfBirthField.sendKeys(date);
        dateOfBirthField.sendKeys(Keys.ENTER);
    }

    public void inputSubject(String subject) {
        subjectField.clear();
        subjectField.sendKeys(subject);
        subjectField.sendKeys(Keys.ENTER);
    }

    public boolean validateChosenSubjects(String subject) {
        for (WebElement tag : subjectTags) {
            if (tag.getText().equalsIgnoreCase(subject)) {
                return true;
            }
        }
        return false;
    }
    // Metoda za odabir jednog hobija
    public void selectHobby(String hobby) {
        for (int i = 0; i < hobbiesLabels.size(); i++) {
            if (hobbiesLabels.get(i).getText().equalsIgnoreCase(hobby)) {
                hobbiesLabels.get(i).click();  // klik na label
                break;
            }
        }
    }

    // Metoda za proveru da li je hobi selektovan
    public boolean isHobbySelected(String hobby) {
        for (int i = 0; i < hobbiesLabels.size(); i++) {
            if (hobbiesLabels.get(i).getText().equalsIgnoreCase(hobby)) {
                return hobbiesInputs.get(i).isSelected();
            }
        }
        return false;
    }

    public void uploadPicture(String filePath) {
        uploadPicture.sendKeys(filePath);
    }

    public void inputCurrentAddress(String address) {
        currentAddressField.clear();
        currentAddressField.sendKeys(address);
    }

    public void selectCity(String cityName) {
        clickViaJS(cityDropdown);
        cityInput.sendKeys(cityName);
        cityInput.sendKeys(Keys.ENTER);
    }
    public void selectState(String stateName) {
        clickViaJS(stateDropDown);
        stateInput.sendKeys(stateName);
        stateInput.sendKeys(Keys.ENTER);
    }
    // metoda sa kojom uploadujemo sliku
    public void uploadPicture1(String relativePath) {
        // Pretvori relativnu putanju u apsolutnu
        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();

        // Pošalji apsolutnu putanju u input
        uploadPicture.sendKeys(absolutePath);
    }








}
