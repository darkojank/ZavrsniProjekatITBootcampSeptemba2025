package Tests;

import Base.BaseTest;
import Page.HomePage;
import Page.SideBar;
import Page.Widgets_ProgressBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        widgetsProgressBar = new Widgets_ProgressBar();
        homePage.clickOnhomePageCardName("Widgets");
        sideBar.clickOnSideBarCard("Progress Bar");
    }

    @Test(priority = 10)
    public void progressBarCanGoToTheEnd() {
        widgetsProgressBar.clickOnStartStopButton();
        wait.until(ExpectedConditions.visibilityOf(widgetsProgressBar.successMessage));
        Assert.assertTrue(widgetsProgressBar.resetButton.isDisplayed());
        Assert.assertEquals(widgetsProgressBar.progressBar.getText(), "100%");
    }

    @Test(priority = 20)
    public void progressBarCanBeReset() {
        widgetsProgressBar.clickOnStartStopButton();
        wait.until(ExpectedConditions.visibilityOf(widgetsProgressBar.successMessage));
        Assert.assertEquals(widgetsProgressBar.progressBar.getText(), "100%");
        Assert.assertTrue(widgetsProgressBar.resetButton.isDisplayed());
        widgetsProgressBar.clickOnResetButton();
        Assert.assertTrue(widgetsProgressBar.startStopButton.isDisplayed());
        Assert.assertEquals(widgetsProgressBar.progressBar.getText(), "0%");
    }

    @Test(priority = 30)
    public void progressBarCanBeContinuedAfterStop() {
        widgetsProgressBar.clickOnStartStopButton();
        setAsyncTimeout(3);
        widgetsProgressBar.clickOnStartStopButton();
        setAsyncTimeout(1);
        String currentProgress = widgetsProgressBar.progressBar.getText();
        Assert.assertEquals(currentProgress,"30%");
        Assert.assertEquals(widgetsProgressBar.startStopButton.getText(), "Start");
        widgetsProgressBar.clickOnStartStopButton();
        setAsyncTimeout(1);
        widgetsProgressBar.clickOnStartStopButton();
        String secundCurrentProgress = widgetsProgressBar.progressBar.getText();
        Assert.assertEquals(secundCurrentProgress, "40%");
        Assert.assertEquals(widgetsProgressBar.startStopButton.getText(), "Start");
        Assert.assertNotEquals(secundCurrentProgress, currentProgress);
        widgetsProgressBar.clickOnStartStopButton();
        wait.until(ExpectedConditions.visibilityOf(widgetsProgressBar.successMessage));
        Assert.assertTrue(widgetsProgressBar.resetButton.isDisplayed());
        Assert.assertEquals(widgetsProgressBar.progressBar.getText(), "100%");
        Assert.assertTrue(widgetsProgressBar.resetButton.isDisplayed());
    }

    @Test(priority = 40)
    public void progressBarCanStop() {
        widgetsProgressBar.clickOnStartStopButton();
        setAsyncTimeout(5);
        widgetsProgressBar.clickOnStartStopButton();
        Assert.assertEquals(widgetsProgressBar.startStopButton.getText(), "Start");
        Assert.assertEquals(widgetsProgressBar.progressBar.getText(), "50%");
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
