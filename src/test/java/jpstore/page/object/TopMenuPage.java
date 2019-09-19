package jpstore.page.object;

import jpstore.driver.DriverManager;
import jpstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    WebElement signOnLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);

    }

    public void goToSingInForm() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
    }
}
