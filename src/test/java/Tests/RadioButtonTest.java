package Tests;

import Base.BaseTest;
import Page.Elements_RadioButton;
import Page.HomePage;
import Page.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadioButtonTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        elements_radioButton = new Elements_RadioButton();

    }

    @Test(priority = 10)
    public void yesRadioButton ()  {
        homePage.clickOnhomePageCardName("Elements");
        String expectedUrlElements = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlElements );
        sideBar.clickOnSideBarCard("Radio Button");
        String expectedUrlRadioButton = "https://demoqa.com/radio-button";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlRadioButton);
        Assert.assertFalse(elements_radioButton.yesRadioSelect.isSelected());
        Assert.assertFalse(elements_radioButton.impressiveSelect.isSelected());
        Assert.assertFalse(elements_radioButton.noRadioButton.isEnabled());


        Assert.assertTrue(elements_radioButton.yesRadioButton.isDisplayed());
        elements_radioButton.clickOnYesRadio();

        String expectResultForYes = "Yes";
        Assert.assertTrue(elements_radioButton.resultText().contains(expectResultForYes));
        Assert.assertTrue(elements_radioButton.yesRadioSelect.isSelected());


    }

    @Test(priority = 20)
    public void impressiveRadioButton () {
        homePage.clickOnhomePageCardName("Elements");
        String expectedUrlElements = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlElements );
        sideBar.clickOnSideBarCard("Radio Button");
        String expectedUrlRadioButton = "https://demoqa.com/radio-button";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlRadioButton);
        Assert.assertFalse(elements_radioButton.yesRadioSelect.isSelected());
        Assert.assertFalse(elements_radioButton.impressiveSelect.isSelected());
        Assert.assertFalse(elements_radioButton.noRadioButton.isEnabled());

        Assert.assertTrue(elements_radioButton.impressiveRadioButton.isDisplayed());
        elements_radioButton.clickOnImpressiveRadio();

        String expectedResultForImpressive = "Impressive";
        Assert.assertTrue(elements_radioButton.resultText().contains(expectedResultForImpressive));
        Assert.assertTrue(elements_radioButton.impressiveSelect.isSelected());

    }

    @Test(priority = 30)
    public void noRadioButton() {
        homePage.clickOnhomePageCardName("Elements");
        String expectedUrlElements = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlElements );
        sideBar.clickOnSideBarCard("Radio Button");
        String expectedUrlRadioButton = "https://demoqa.com/radio-button";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlRadioButton);
        Assert.assertFalse(elements_radioButton.yesRadioSelect.isSelected());
        Assert.assertFalse(elements_radioButton.impressiveSelect.isSelected());
        Assert.assertFalse(elements_radioButton.noRadioButton.isEnabled());


        Assert.assertTrue(elements_radioButton.noRadioSelect.isDisplayed());
        Assert.assertTrue(elements_radioButton.noRadioButtonIsDisabled());
        Assert.assertFalse(elements_radioButton.noRadioButton.isSelected());


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