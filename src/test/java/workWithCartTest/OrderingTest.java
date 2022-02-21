package workWithCartTest;

import baseTest.BaseTest;

import org.junit.Before;
import org.junit.Test;

public class OrderingTest extends BaseTest {
    String timeDelivery = "1200";

    @Before
    public void precondition() {
        homePage.openHomePage()
                .clickOnSubPagePizza()
                .addPizzaKidsInShoppingCart()
                .checkIsButtonCartDisplayed()
                .openCart();
    }

    @Test
    public void invalidValueInOrder() {
        cartPage.enterTextIntoFioInput("/")
                .enterTextIntoPhoneInput("")
                .enterTextIntoAddressInput("")
                .clickOnRadioButtonToTheDoor()
                .enterNumbersToFieldTime(timeDelivery)
                .clickOnCheckBox("switchOff")
                .clickOnRadioButtonPayCash()
                .clickOnButtonPlaceOrder();
        cartPage.checkIsMessagesDisplayed();

    }

    @Test
    public void orderingProduct() {
        cartPage.enterTextIntoFioInput(" Анна Тест-заказ")
                .enterTextIntoPhoneInput("123456789")
                .enterTextIntoAddressInput("Киев")
                .clickOnRadioButtonToTheDoor()
                .enterNumbersToFieldTime(timeDelivery)
                .clickOnCheckBox("switchOn")
                .clickOnRadioButtonPaymentWithCard()
                .clickOnButtonPlaceOrderWithCard()
                .checkIsRedirectToLiqpayPage();

    }
}
