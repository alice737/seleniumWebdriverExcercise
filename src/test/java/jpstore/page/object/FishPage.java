package jpstore.page.object;

import jpstore.driver.DriverManager;
import jpstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishPage {

    @FindBy(css = "tr:nth-child(2) a")
    WebElement angelProductIdBtn;

    public FishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickAngelFish(){
        WaitForElement.waitUntilElementIsClickable(angelProductIdBtn);

        angelProductIdBtn.click();
    }
}
