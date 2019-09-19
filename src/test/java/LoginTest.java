import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class LoginTest {
    protected WebDriver driver;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:/IntelliJ/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    void invalidLoginText(){
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/login");
        WebElement loginInput= driver.findElement(By.id("username"));
        WebElement passwordInput=driver.findElement(By.id("password"));

        loginInput.sendKeys("tomsmith");
        passwordInput.sendKeys("dowolne");
        passwordInput.submit();

        WebElement alert = driver.findElement(By.id("flash"));

        System.out.println(alert.getText());

       Assert.assertTrue(alert.getText().contains("Your password is invalid!"));


    }
    @AfterMethod
    public void close() {
        driver.close();
        driver.quit();

    }
}
