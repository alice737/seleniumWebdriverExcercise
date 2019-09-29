package jpstore.driver;

import jpstore.browser.BrowserFactory;
import jpstore.configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }

        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}