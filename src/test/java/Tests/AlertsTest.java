package Tests;

import Base.BaseTest;
import Page.AlertsFrameWindows_Alerts;
import Page.HomePage;
import Page.SideBar;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        alertsFrameWindowsAlerts = new AlertsFrameWindows_Alerts();
        homePage.clickOnhomePageCardName("Alerts, Frame & Windows");
        sideBar.clickOnSideBarCard("Alerts");
    }

    @Test(priority = 10)
    public void userCanOpenAlertWindow(){ //validateAlertWindowCanBeOpen
        alertsFrameWindowsAlerts.clickOnAlertButton();
        String alertText = alertText();
        Assert.assertEquals(alertText,"You clicked a button");
        driver.switchTo().alert().accept();
    }

    @Test(priority = 20)
    public void userCanOpenTimerAlertWindow() {//validateTimerAlertWindowCanBeOpen
        alertsFrameWindowsAlerts.clickOnTimerAlertButton();
        String alertText = alertText();
        Assert.assertEquals(alertText, "This alert appeared after 5 seconds");
        driver.switchTo().alert().accept();
    }
    @Test(priority = 30)
    public void userCanOpenConfirmWindow() {//ValidateConfirmWindowCanBeOpen
        alertsFrameWindowsAlerts.clickOnConfirmButton();
        String alertText = alertText();
        Assert.assertEquals(alertText, "Do you confirm action?");
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(alertsFrameWindowsAlerts.successMessage));
        Assert.assertEquals(alertsFrameWindowsAlerts.successMessage.getText(), "You selected Ok");
    }

    @Test(priority = 40)
    public void userCanOpenPromptWindow(){//validatePromptWindowCanBeOpen
        alertsFrameWindowsAlerts.clickOnPromptButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String inputText = "test";
        alert.sendKeys(inputText);
        alert.accept();
        wait.until(ExpectedConditions.visibilityOf(alertsFrameWindowsAlerts.successMessage));
        Assert.assertEquals(alertsFrameWindowsAlerts.successMessage.getText(),  inputText);
    }

        @AfterMethod
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
