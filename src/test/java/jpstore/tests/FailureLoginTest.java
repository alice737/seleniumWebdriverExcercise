package jpstore.tests;

import jpstore.page.object.LandingPage;
import jpstore.page.object.LoginPage;
import jpstore.page.object.TopMenuPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FailureLoginTest extends BaseTest {
    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickEnterStore();
        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.goToSingInForm();


        LoginPage loginPage = new LoginPage();
        loginPage.markUsername("NotExistingLogin");
        loginPage.markPassword("NotProperPassword");
        loginPage.enterSubmitButton();


        assertEquals(loginPage.getLabelMessage(), "Invalid username or password. Signon failed.");
    }
}
