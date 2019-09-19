import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ParametersFromTestNgXmlTests {
    protected WebDriver driver;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:/IntelliJ/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://google.pl");
    }

    @Parameters({"queryToSearch", "expectedTitle"})
    @Test
    public void parametersExampleTest(@Optional("TestNG") String queryToSearch, @Optional("TestNG - Szukaj w Google") String expectedTitle) {
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys(queryToSearch);
        searchField.submit();
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().equals(expectedTitle));
    }
    @Test(dataProvider = "myLocalDataProvider")
    public void localDataProviderTest(String query, String expectedTitle) {

        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("q")).submit();

        String pageTitle = driver.getTitle();

        assertEquals(pageTitle, expectedTitle);
    }
    @DataProvider(name = "myLocalDataProvider")
    public Object[][] queriesTestData() {
        Object[][] testDataArray = {
                {"JavaStart", "JavaStart - Szukaj w Google"},
                {"Selenium", "Selenium - Szukaj w Google"},
                {"TestNG", "TestNG - Szukaj w Google"}};
        return testDataArray;
    }
    @AfterMethod
    public void close() {
        driver.close();
        driver.quit();

    }

}
