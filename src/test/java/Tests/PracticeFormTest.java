package Tests;

import Base.BaseTest;
import Page.Forms_PracticeForm;
import Page.HomePage;
import Page.SideBar;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        forms_practiceForm = new Forms_PracticeForm();
        homePage.clickOnhomePageCardName("Forms");
        sideBar.clickOnSideBarCard("Practice Form");


    }

    @Test
    public void endToEndTest()  {


        String firstName = "Joel";
        String lastName = "Momfis";
        String email = "practice.test@try.com";
        String gender = "Female";
        String phoneNumber = "0123456789";
        String dateOfBirth = "31 Dec 1918";
        String subjects = "English";
        String subjects1 = "Maths";
        String subjects2 = "Civics";
        String hobby = "Sports";
        String hobby1 = "Music";
        String currentAddress = "Test Adresa 00, 11200";
        String state = "NCR";
        String city = "Delhi";


        forms_practiceForm.inputFirstName(firstName);
        forms_practiceForm.inputLastName(lastName);
        forms_practiceForm.inputEmail(email);
        forms_practiceForm.selectGender(gender);
        //asertacija za odabrani gender:
        forms_practiceForm.isGenderSelected(gender);
        forms_practiceForm.inputMobileNumber(phoneNumber);
        forms_practiceForm.inputDateOfBirth(dateOfBirth);
        forms_practiceForm.inputSubject(subjects);
        forms_practiceForm.inputSubject(subjects1);
        forms_practiceForm.inputSubject(subjects2);
        Assert.assertTrue(forms_practiceForm.validateChosenSubjects(subjects));
        Assert.assertTrue(forms_practiceForm.validateChosenSubjects(subjects1));
        Assert.assertTrue(forms_practiceForm.validateChosenSubjects(subjects2));

        forms_practiceForm.selectHobby(hobby);
        forms_practiceForm.selectHobby(hobby1);
        Assert.assertTrue(forms_practiceForm.isHobbySelected(hobby));
        Assert.assertTrue(forms_practiceForm.isHobbySelected(hobby1));

        forms_practiceForm.inputCurrentAddress(currentAddress);

        forms_practiceForm.uploadPicture("C:\\Users\\Sidras\\Desktop\\ProjektnaSlika.png");
        Assert.assertTrue(forms_practiceForm.uploadPicture.getAttribute("value").contains("ProjektnaSlika.png"));

        forms_practiceForm.selectState(state);
        forms_practiceForm.selectCity(city);

        forms_practiceForm.clickViaJS(forms_practiceForm.submitButton);


        String titleAfterSubmission = "Thanks for submitting the form";
        Assert.assertEquals(forms_practiceForm.modalHeader.getText(), titleAfterSubmission);
        String allResults = forms_practiceForm.modalTableBody.getText();

        Assert.assertTrue(allResults.contains(firstName+ " " +lastName));
        Assert.assertTrue(allResults.contains(email));
        Assert.assertTrue(allResults.contains(gender));
        Assert.assertTrue(allResults.contains(phoneNumber));
        Assert.assertTrue(allResults.contains("31 December,1918"));
        Assert.assertTrue(allResults.contains(subjects+ ", "+subjects1+", " +subjects2));
        Assert.assertTrue(allResults.contains(hobby+ ", " +hobby1));
        Assert.assertTrue(allResults.contains("ProjektnaSlika.png"));
        Assert.assertTrue(allResults.contains(currentAddress));
        Assert.assertTrue(allResults.contains(state + " " + city));

    }

    @AfterMethod
    public void clearAllCookies() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
