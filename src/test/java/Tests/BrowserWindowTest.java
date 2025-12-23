package Tests;

import Base.BaseTest;

import Page.AlertsFrameWindows_BrowserWindows;
import Page.HomePage;
import Page.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void test1() {

    }

}
