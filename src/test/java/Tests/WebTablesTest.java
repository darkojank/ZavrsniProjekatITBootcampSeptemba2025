package Tests;

import Base.BaseTest;

import Page.HomePage;
import Page.SideBar;
import Page.WebTablesPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class WebTablesTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");


        homePage = new HomePage();
        sideBar = new SideBar();
        webTablesPage = new WebTablesPage();
        homePage.clickOnhomePageCardName("Elements");
        sideBar.clickOnSideBarCard("Web Tables");

    }


    @Test(priority = 10)
    public void deleteAllRecordsFromTables() {
        int count = webTablesPage.getNumberOfRecords();
        for (int i = 0; i < count; i++) {
            webTablesPage.clickOnDeleteButton();
        }

        Assert.assertEquals(webTablesPage.getNumberOfRecords(), 0);
    }


    @Test(priority = 20)
    public void userCanAddNewRecord()  {
        String firstName = "Darko";
        String lastName = "Markovic";
        String email = "test@test.bom";
        String age = "22";
        String salary = "80000";
        String department = "HR";
        webTablesPage.deleteAllRecords();
        Assert.assertEquals(webTablesPage.getNumberOfRecords(), 0);
        webTablesPage.addNewUserInformation(firstName, lastName, email, salary, department, age);

        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(firstName));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(firstName));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(lastName));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(age));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(email));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(salary));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(department));

    }

    @Test(priority = 30)
    public void userCanAddMultipleRecords()  {
        webTablesPage.deleteAllRecords();
        int j = 0;
        for(int i = 0; i<excelReader.getLastRow("Project"); i++) {
            String firstName = excelReader.getStringData("Project", i+1, 0);
            String lastName = excelReader.getStringData("Project", i+1, 1);
            String email = excelReader.getStringData("Project", i+1,2);

            String age = String.valueOf(excelReader.getIntegerData("Project", i+1, 3));
            String salary = String.valueOf(excelReader.getIntegerData("Project", i+1, 4));
            String department = excelReader.getStringData("Project", i+1, 5);

            webTablesPage.addNewUserInformation(firstName, lastName, email, salary, department, age);
            Assert.assertEquals(firstName, webTablesPage.getGetCell().get(j).getText());
            Assert.assertEquals(lastName, webTablesPage.getGetCell().get(j + 1).getText());
            Assert.assertEquals(age, webTablesPage.getGetCell().get(j + 2).getText());
            Assert.assertEquals(email, webTablesPage.getGetCell().get(j + 3).getText());
            Assert.assertEquals(salary, webTablesPage.getGetCell().get(j + 4).getText());
            Assert.assertEquals(department, webTablesPage.getGetCell().get(j + 5).getText());

            j = j + 7;

        }


    }

    @Test(priority = 40)
    public void userCanEditRecord() {
        webTablesPage.deleteAllRecords();
        String firstName = "Darko";
        String lastName = "Markovic";
        String email = "test@test.bom";
        String age = "22";
        String salary = "80000";
        String department = "HR";
        Assert.assertEquals(webTablesPage.getNumberOfRecords(), 0);
        webTablesPage.addNewUserInformation(firstName, lastName, email, salary, department, age);


        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(firstName));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(lastName));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(age));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(email));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(salary));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(department));

        String firstNameEdit = "Milica";
        String lastNameEdit = "Peric";
        String emailEdit = "edit@edit.bom";
        String ageEdit = "48";
        String salaryEdit = "1000";
        String departmentEdit = "Account";
        Assert.assertEquals(webTablesPage.getNumberOfRecords(), 1);

        webTablesPage.clickOnEditButtonByIndex(0);
        webTablesPage.firstNameField.clear();
        webTablesPage.lastNameField.clear();
        webTablesPage.emailField.clear();
        webTablesPage.ageField.clear();
        webTablesPage.salaryField.clear();
        webTablesPage.departmentField.clear();
        webTablesPage.fillFormForEdit(firstNameEdit, lastNameEdit, emailEdit, salaryEdit,departmentEdit, ageEdit);

        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(firstNameEdit));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(lastNameEdit));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(ageEdit));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(emailEdit));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(salaryEdit));
        Assert.assertTrue(webTablesPage.getGetRowContent().getFirst().getText().contains(departmentEdit));




    }

    @Test(priority = 50)
    public void userCanSearch()  {
        webTablesPage.deleteAllRecords();
        int j = 0;
        for(int i = 0; i<excelReader.getLastRow("TestData"); i++) {
            String firstName = excelReader.getStringData("TestData", i+1, 0);
            String lastName = excelReader.getStringData("TestData", i+1, 1);
            String email = excelReader.getStringData("TestData", i+1,2);
            String age = String.valueOf(excelReader.getIntegerData("TestData", i+1, 3));
            String salary = String.valueOf(excelReader.getIntegerData("TestData", i+1, 4));
            String department = excelReader.getStringData("TestData", i+1, 5);

            webTablesPage.addNewUserInformation(firstName, lastName, email, salary, department, age);
            Assert.assertEquals(firstName, webTablesPage.getGetCell().get(j).getText());
            Assert.assertEquals(lastName, webTablesPage.getGetCell().get(j + 1).getText());
            Assert.assertEquals(age, webTablesPage.getGetCell().get(j + 2).getText());
            Assert.assertEquals(email, webTablesPage.getGetCell().get(j + 3).getText());
            Assert.assertEquals(salary, webTablesPage.getGetCell().get(j + 4).getText());
            Assert.assertEquals(department, webTablesPage.getGetCell().get(j + 5).getText());

            j = j + 7;

        }

        String searchTerm = "Schrutte";

        webTablesPage.inputSearchBox(searchTerm);


        boolean result = false;
        for (WebElement row : webTablesPage.getRowContent) {
            if (row.getText().contains(searchTerm)) {
                result = true;
                break;
            }
        }

        Assert.assertTrue(result, searchTerm );




    }

    @AfterMethod
    public void closeWindows() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }















}
