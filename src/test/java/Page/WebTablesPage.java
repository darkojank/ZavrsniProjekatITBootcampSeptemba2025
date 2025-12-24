package Page;

import Base.BaseTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="addNewRecordButton")
    public WebElement addNewRecordButton;

    @FindBy(id ="firstName")
    public WebElement firstNameField;

    @FindBy(id ="lastName")
    public WebElement lastNameField;

    @FindBy(id ="userEmail")
    public WebElement emailField;

    @FindBy(id ="age")
    public WebElement ageField;

    @FindBy(id ="salary")
    public WebElement salaryField;

    @FindBy(id ="department")
    public WebElement departmentField;

    @FindBy(id ="submit")
    public WebElement submitButton;

    @FindBy(css = "span[title='Delete']")
    public List<WebElement> deleteButtons;



    @FindBy(css = "span[title='Edit']")
    public List<WebElement> editButtons;

    public List<WebElement> getEditButtons() {
        return editButtons;
    }



    public List<WebElement> getDeleteButtons() {
        return deleteButtons;
    }


    public List<WebElement> getGetRowContent() {
        return getRowContent;
    }

    @FindBy(css = ".rt-tr-group")
    public List<WebElement> getRowContent;


    public List<WebElement> getGetCell() {
        return getCell;
    }

    @FindBy(css = ".rt-td")
    public List<WebElement> getCell;

    @FindBy(id = "searchBox")
    public WebElement searchBoxField;

    //-----------------------------------------------------------

    public void clickOnAddButton() {
        addNewRecordButton.click();
    }

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputAge(String age) {
        ageField.clear();
        ageField.sendKeys(age);
    }

    public void inputSalary(String salary) {
        salaryField.clear();
        salaryField.sendKeys(salary);
    }

    public void inputDepartment(String department) {
        departmentField.clear();
        departmentField.sendKeys(department);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void clickOnEditButtonByIndex(int index) {
        if (index < editButtons.size()) {
            editButtons.get(index).click();
        }
    }

    public void clickOnDeleteButton() {
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
        }
    }
    //Broj delete dugmica
    public int getNumberOfRecords() {
        return deleteButtons.size();
    }

    public void deleteAllRecords() {
        int j = getDeleteButtons().size();
        for (int i = 0; i < j; i++) {
            clickOnDeleteButton();
        }
    }

    public void inputSearchBox(String search) {
        searchBoxField.clear();
        searchBoxField.sendKeys(search);
    }

    public void addNewUserInformation(String firstName, String lastName, String email, String salary, String department, String age) {
        clickOnAddButton();
        inputFirstName(firstName);
        inputLastName(lastName);
        inputAge(age);
        inputEmail(email);
        inputSalary(salary);
        inputDepartment(department);
        clickOnSubmitButton();
    }


    // Metoda koja samo popunjava polja i klikće submit
    public void fillFormForEdit(String firstName, String lastName, String email, String salary, String department, String age) {
        inputFirstName(firstName);
        inputLastName(lastName);
        inputAge(age);
        inputEmail(email);
        inputSalary(salary);
        inputDepartment(department);
        clickOnSubmitButton();
    }














}
