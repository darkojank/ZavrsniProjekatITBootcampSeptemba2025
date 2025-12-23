package Base;

import Page.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public SideBar sideBar;
    public Elements_TextBoxPage elements_textBoxPage;
    public ExcelReader excelReader;
    public AlertsFrameWindows_ModalDialogs alertsFrameWindowsModalDialogs;
    public Elements_RadioButton elements_radioButton;
    public Forms_PracticeForm forms_practiceForm;
    public AlertsFrameWindows_Alerts alertsFrameWindowsAlerts;
    public WebTablesPage webTablesPage;
    public AlertsFrameWindows_BrowserWindows alertsFrameWindowsBrowserWindows;
    public Widgets_ProgressBar widgetsProgressBar;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("WebTablesData1.xlsx");
    }

    //Setting a JS timeout in order to test elements that are not yet displayed
    public void setAsyncTimeout(int seconds){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], " + (seconds * 1000)+ ");");
    }

    //Extracting text from an alert/confirm window in order to test its value
    public String alertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    //JS for scroll element
    public void clickViaJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
