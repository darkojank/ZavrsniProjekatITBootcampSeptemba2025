package Tests;

import Base.BaseTest;

import Page.AlertsFrameWindows_BrowserWindows;
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

public class BrowserWindowTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        alertsFrameWindowsBrowserWindows = new AlertsFrameWindows_BrowserWindows();
        homePage.clickOnhomePageCardName("Alerts, Frame & Windows");
        sideBar.clickOnSideBarCard("Browser Windows");

    }

    @Test
    public void testNewTab() {
        String mainWindow = driver.getWindowHandle();
        alertsFrameWindowsBrowserWindows.clickOnNewTabButton();
        alertsFrameWindowsBrowserWindows.switchToNewWindow(mainWindow);

        String text = alertsFrameWindowsBrowserWindows.textFromWindow.getText();
        String expectedText = "This is a sample page";
        Assert.assertEquals(text, expectedText);
        String expectedURL = "https://demoqa.com/sample";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        driver.close();
        driver.switchTo().window(mainWindow);

    }

    @Test
    public void testNewWindow() {
        String mainWindow = driver.getWindowHandle();
        alertsFrameWindowsBrowserWindows.clickOnNewWindowButton();
        alertsFrameWindowsBrowserWindows.switchToNewWindow(mainWindow);

        String text = alertsFrameWindowsBrowserWindows.textFromWindow.getText();
        String expectedText = "This is a sample page";
        Assert.assertEquals(text, expectedText);
        String expectedURL = "https://demoqa.com/sample";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        driver.close();
        driver.switchTo().window(mainWindow);

    }

    @Test
    public void testNewWindowMessage() {
        String mainWindow = driver.getWindowHandle();
        alertsFrameWindowsBrowserWindows.clickViaJS(alertsFrameWindowsBrowserWindows.newWindowMessage);
        System.out.println("Broj prozora: " + driver.getWindowHandles().size());
        alertsFrameWindowsBrowserWindows.switchToNewWindow(mainWindow);

        String bodyText = alertsFrameWindowsBrowserWindows.bodyForWindowMessage.getText();
        Assert.assertTrue(bodyText.contains("Knowledge increases by sharing but not by saving."));

        driver.close();
        driver.switchTo().window(mainWindow);

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
