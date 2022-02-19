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
    public void unvalidValueInOrder() {
        cartPage.enterTextIntoFioInput("/")
                .enterTextIntoPhoneInput("")
                .enterTextIntoAddressInput("")
                .clickOnRadioButtonToTheDoor()
                .enterNumbersToFieldTime(timeDelivery)
//                .checkDeliveryTime(timeDelivery)
                .clickOnRadioButtonPayCash()
                .clickOnCheckBox("switchOn")
                .clickOnButtonPlaceAnOrderWithCash()
                .checkIsMessagesDisplayed();


    }

    @Test
    public void orderingProduct() {
        cartPage.enterTextIntoFioInput(" Анна Тест-заказ")
                .enterTextIntoPhoneInput("123456789")
                .enterTextIntoAddressInput("Киев")
                .clickOnRadioButtonToTheDoor()
                .enterNumbersToFieldTime("1200")
                .clickOnRadioButtonPaymentWithCard()
                .clickOnCheckBox("switchOn")
                .clickOnButtonPlaceOrderWithCard()
                .checkIsRedirectToLiqpayPage();
    }
}
