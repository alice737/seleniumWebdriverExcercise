import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class WebElementTest {
    WebDriver driver;

    @BeforeMethod
    void beforeMetod() {
        System.setProperty("webdriver.chrome.driver", "D:/IntelliJ/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    void typingIntoWebElementTest() {
        WebElement queryUserEmail = driver.findElement(By.id("username"));
        queryUserEmail.sendKeys("Selenium Strat");
        String userNameValue = queryUserEmail.getAttribute("value");
        assertEquals(userNameValue, "Selenium Strat");
    }

    @Test
    void checkRadioButtonTest() {
        WebElement radioButtonMale = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement radioButtonFemale = driver.findElement(By.cssSelector("input[value='female']"));
        radioButtonFemale.click();
        assertTrue(radioButtonFemale.isSelected());
        radioButtonMale.click();
        assertTrue(radioButtonMale.isSelected());
        assertFalse(radioButtonFemale.isSelected());


    }

    @Test
    void dropdownlistTest() {
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        List<WebElement> options = countryDropDown.getOptions();
        List<String> namesOfOptions = new ArrayList<String>();

        for (WebElement option : options) {

            namesOfOptions.add(option.getText());

            System.out.println(option.getText());
        }
        List<String> expectedNamesOfOptions = new ArrayList<String>();
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");

        assertEquals(namesOfOptions, expectedNamesOfOptions);


    }


    @AfterMethod
    void afterTests() {
        driver.close();
        driver.quit();
    }

}
