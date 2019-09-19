package jpstore.page.object;

import jpstore.driver.DriverManager;
import jpstore.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    @FindBy(css = "area[alt='Fish']")
    private WebElement btnFishImage;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);

    }

    public void markUsername(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);

    }

    public void markPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterSubmitButton() {
        WaitForElement.waitUntilElementIsClickable(signOnButton);
        signOnButton.click();
    }

    public String getLabelMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        return messageLabel.getText();
    }

    public void clickFishBtn() {
        WaitForElement.waitUntilElementIsClickable(btnFishImage);
        btnFishImage.click();
    }
}
