package jpstore.page.object;

import jpstore.driver.DriverManager;
import jpstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelaFishPage {

    @FindBy(css = "a.Button[href$='EST-2']")
    WebElement smallAngelaBtnAdd;

    public AngelaFishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickAddSmallAngelaToCart(){
        WaitForElement.waitUntilElementIsClickable(smallAngelaBtnAdd);
        smallAngelaBtnAdd.click();
    }
}
