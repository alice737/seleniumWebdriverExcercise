package jpstore.page.object;

import jpstore.driver.DriverManager;
import jpstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCardPage {

    @FindBy(css = "a[href$='newOrderForm=']")
    WebElement proccedCheckoutBtn;

    public ShoppingCardPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);

    }

    public void clickProccedCheckoutBtn() {
        WaitForElement.waitUntilElementIsClickable(proccedCheckoutBtn);
        proccedCheckoutBtn.click();
    }
}
