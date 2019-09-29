package jpstore.page.object;

import jpstore.driver.DriverManager;
import jpstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
    @FindBy(css="#Banner > img")
    WebElement bannerAfterLogIn;

    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public Boolean getIsDisplayedBanner(){
       WaitForElement.waitUntilElementIsVisible(bannerAfterLogIn);
        return bannerAfterLogIn.isDisplayed();
    }
}
