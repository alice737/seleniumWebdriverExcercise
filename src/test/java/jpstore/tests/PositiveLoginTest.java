package jpstore.tests;

import jpstore.driver.DriverUtils;
import jpstore.page.object.FooterPage;
import jpstore.page.object.LandingPage;
import jpstore.page.object.LoginPage;
import jpstore.page.object.TopMenuPage;
import org.testng.annotations.Test;

import static jpstore.navigation.ApplicationUrl.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTest  extends  BaseTest{
    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.markUsername("j2ee");
        loginPage.markPassword("j2ee");
        loginPage.enterSubmitButton();
        FooterPage footerPage = new FooterPage();

        assertTrue(footerPage.getIsDisplayedBanner());
    }
}
