package workWithCartTest;

import baseTest.BaseTest;
import org.junit.Test;

public class WorkCartWithPageObject extends BaseTest {
    @Test
    public void addingAndRemovingItemsToCart() {
        homePage.openHomePage()
                .clickOnSubPagePizza()
                .addPizzaKidsInShoppingCart()
                .checkIsButtonCartDisplayed()
                .clickOnSubPageBurgers()
                .addBurgerMiniToCart();
        homePage.openCart();
        cartPage.dellPizzaKidsInCart()
                .сheckCartAfterDeletingItem();


    }

    @Test
    public void changingTheQuantityOfProductInTheCart() {
        homePage.openHomePage()
                .clickOnSubPagePizza()
                .addPizzaKidsInShoppingCart();
        homePage.openCart()
                .checkCounter("1")
                .clickOnButtonPlus()
                .checkCounter("2")
                .clickOnButtonMinus()
                .checkCounter("1");

    }
}
