package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> homePageSideBar;


    //--------------------------------------

    public void clickOnhomePageCardName(String homePageCardName) {
        for(int i=0; i<homePageSideBar.size(); i++) {
            if(homePageSideBar.get(i).getText().contains(homePageCardName)) {
                homePageSideBar.get(i).click();
                break;
            }
        }
    }


}
