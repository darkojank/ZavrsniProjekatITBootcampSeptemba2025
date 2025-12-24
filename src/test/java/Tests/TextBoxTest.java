package Tests;

import Base.BaseTest;
import Page.Elements_TextBoxPage;
import Page.HomePage;
import Page.SideBar;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TextBoxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        elements_textBoxPage = new Elements_TextBoxPage();


    }

    @Test(priority = 10)
    public void userCanSubmitAllFields() {
        homePage.clickOnhomePageCardName("Elements");
        String expectedUrlElements = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlElements );
        sideBar.clickOnSideBarCard("Text Box");
        String expectedUrlTextBox = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlTextBox);
        String fullName = "Patak Daca";
        String email = "probni@mail.com";
        String currentAddress = "Nedodjija 228, nepoznata";
        String permanentAddress = "Kacarevo 007";
        elements_textBoxPage.inputFullName(fullName);
        elements_textBoxPage.inputEmail(email);
        elements_textBoxPage.inputCurrentAddress(currentAddress);
        elements_textBoxPage.inputPermanentAddress(permanentAddress);
        elements_textBoxPage.clickOnSubmitButton();

//        elements_textBoxPage.checkOutputResult(fullName);
//
//        Assert.assertEquals(elements_textBoxPage.outputName.getText(), "Name:"+fullName);
//        Assert.assertEquals(elements_textBoxPage.outputEmail.getText(), "Email:"+email);
//        Assert.assertEquals(elements_textBoxPage.outputAddress.getText(), "Current Address :"+currentAddress);
//        Assert.assertEquals(elements_textBoxPage.outputPermanentAddress.getText(), "Permananet Address :"+permanentAddress);

        Assert.assertTrue(elements_textBoxPage.outputName.getText().contains(fullName));
        Assert.assertTrue(elements_textBoxPage.outputEmail.getText().contains(email));
        Assert.assertTrue(elements_textBoxPage.outputAddress.getText().contains(currentAddress));
        Assert.assertTrue(elements_textBoxPage.outputPermanentAddress.getText().contains(permanentAddress));


    }

    @Test(priority = 20)
    public void userCantSubmitEmptyFields() {
        homePage.clickOnhomePageCardName("Elements");
        String expectedUrlElements = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlElements );
        sideBar.clickOnSideBarCard("Text Box");
        String expectedUrlTextBox = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlTextBox);
        elements_textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(elements_textBoxPage.getOutputParagraphs().isEmpty());
    }



    @Test(priority = 30)
    public void userCantSubmitInvalidEmails() {

        homePage.clickOnhomePageCardName("Elements");
        sideBar.clickOnSideBarCard("Text Box");

        String fullName = "Petar Petrovic";
        String currentAddress = "Nedodjija 228, nepoznata";
        String permanentAddress = "Kacarevo 007";

        String[] invalidEmails = {"probnimail.com", "probnimailcom", "probni@mailcom"};

        for (int i = 0; i < invalidEmails.length; i++) {

            elements_textBoxPage.inputFullName(fullName);
            elements_textBoxPage.inputEmail(invalidEmails[i]);
            elements_textBoxPage.inputCurrentAddress(currentAddress);
            elements_textBoxPage.inputPermanentAddress(permanentAddress);
            elements_textBoxPage.clickOnSubmitButton();

            Assert.assertTrue(elements_textBoxPage.isEmailInvalid(), invalidEmails[i]);

            Assert.assertFalse(elements_textBoxPage.isOutputSectionDisplayed(), invalidEmails[i]);

            driver.navigate().refresh();
        }
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
