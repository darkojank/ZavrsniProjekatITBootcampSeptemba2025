package Page;

import Base.BaseTest;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBar extends BaseTest {

    public SideBar() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "text")
    public List<WebElement> sideBarList;

    //--------------

    public void clickOnSideBarCard(String cardName) {
        for(int i = 0; i<sideBarList.size(); i++) {
            if(sideBarList.get(i).getText().contains(cardName)) {
                sideBarList.get(i).click();
            }
        }
    }


}
