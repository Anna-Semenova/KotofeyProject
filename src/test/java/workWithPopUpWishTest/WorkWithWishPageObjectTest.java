package workWithPopUpWishTest;

import baseTest.BaseTest;
import org.junit.Test;


public class WorkWithWishPageObjectTest extends BaseTest {

    @Test
    public void workWithWish() {

        homePage.openHomePage()
                .clickOnSubPageBurgers()
                .clickOnButtonWishOnBurgerSuper()
                .openWishPopUp()
                .checkIsRedirectWishPopUp()
                .checkBurgerSuperInWish();
    }

}
