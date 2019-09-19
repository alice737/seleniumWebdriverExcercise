package jpstore.page.object;

import jpstore.driver.DriverManager;
import jpstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    @FindBy(css = "#Content a")
    WebElement enterStore;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);

    }

    public void clickEnterStore() {
        WaitForElement.waitUntilElementIsClickable(enterStore);
        enterStore.click();
    }
}
