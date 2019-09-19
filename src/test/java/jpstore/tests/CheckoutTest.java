package jpstore.tests;

import jpstore.page.object.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void proccedToCheckoutWitchoutLogin(){
        LandingPage landingPage = new LandingPage();
        landingPage.clickEnterStore();

        LoginPage loginPage = new LoginPage();
        loginPage.clickFishBtn();

        FishPage fishPage = new FishPage();
        fishPage.clickAngelFish();

        AngelaFishPage angelaFishPage = new AngelaFishPage();
        angelaFishPage.clickAddSmallAngelaToCart();

        ShoppingCardPage shoppingCardPage = new ShoppingCardPage();
        shoppingCardPage.clickProccedCheckoutBtn();

        Assert.assertTrue(loginPage.getLabelMessage().contains("You must sign on before attempting to check out."));


    }


}
