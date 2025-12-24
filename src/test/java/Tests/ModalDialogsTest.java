package Tests;

import Base.BaseTest;
import Page.AlertsFrameWindows_ModalDialogs;
import Page.HomePage;
import Page.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ModalDialogsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        alertsFrameWindowsModalDialogs = new AlertsFrameWindows_ModalDialogs();

    }

    @Test(priority = 10)
    public void smallModalTest()  {
        homePage.clickOnhomePageCardName("Alerts, Frame & Windows");
        String expectedUrlElements = "https://demoqa.com/alertsWindows";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlElements );
        sideBar.clickOnSideBarCard("Modal Dialogs");
        String expectedUrlModalDialogs = "https://demoqa.com/modal-dialogs";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlModalDialogs);
        Assert.assertTrue(alertsFrameWindowsModalDialogs.smallModalButton.isDisplayed());
        Assert.assertTrue(alertsFrameWindowsModalDialogs.largeModalButton.isDisplayed());

        alertsFrameWindowsModalDialogs.clickOnSmallModalButton();
        Assert.assertTrue(alertsFrameWindowsModalDialogs.closeSmallModalButton.isDisplayed());
        String expectedTitle = "Small Modal";
        Assert.assertEquals(alertsFrameWindowsModalDialogs.smallModalTitle.getText(), expectedTitle);
        String expectedText = "This is a small modal. It has very less content";
        Assert.assertEquals(alertsFrameWindowsModalDialogs.modalBodyText.getText(),expectedText);
        alertsFrameWindowsModalDialogs.closeSmallModalButton.click();
        wait.until(ExpectedConditions.invisibilityOf(alertsFrameWindowsModalDialogs.closeSmallModalButton));

        Assert.assertTrue(alertsFrameWindowsModalDialogs.isSmallModalClosed());



    }

    @Test(priority = 20)
    public void largeModalTest()  {
        homePage.clickOnhomePageCardName("Alerts, Frame & Windows");
        String expectedUrlElements = "https://demoqa.com/alertsWindows";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrlElements );
        sideBar.clickOnSideBarCard("Modal Dialogs");
        String expectedUrlModalDialogs = "https://demoqa.com/modal-dialogs";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlModalDialogs);
        Assert.assertTrue(alertsFrameWindowsModalDialogs.largeModalButton.isDisplayed());
        alertsFrameWindowsModalDialogs.clickOnLargeModalButton();

        String expectedTitle = "Large Modal";
        Assert.assertEquals(alertsFrameWindowsModalDialogs.largeModalTitle.getText(),expectedTitle);
        String expectedText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Assert.assertEquals(alertsFrameWindowsModalDialogs.modalBodyText.getText(), expectedText);
        Assert.assertTrue(alertsFrameWindowsModalDialogs.closeLargeModalButton.isDisplayed());
        alertsFrameWindowsModalDialogs.closeLargeModalButton.click();

        wait.until(ExpectedConditions.invisibilityOf(alertsFrameWindowsModalDialogs.closeLargeModalButton));
        Assert.assertTrue(alertsFrameWindowsModalDialogs.isLargeModalClosed());



    }

    @AfterMethod
    public void closeWindows() {
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



}
