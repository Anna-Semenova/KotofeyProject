package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends ParentPageWithElement {

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement ordering;

    @FindBy(xpath = ".//div[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']//..//..//*[@class='t706__product-del']")
    private WebElement dellPizzaKids;

    @FindBy(xpath = ".//*[@class='t706__cartwin-close-icon']")
    private WebElement buttonCloseCart;

    @FindBy(xpath = ".//div[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']")
    private WebElement pizzaKidsInShoppingCart;

    @FindBy(xpath = ".//*[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']//..//..//*[@class='t706__product-minus']")
    private WebElement buttonMinus;

    @FindBy(xpath = ".//*[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']//..//..//*[@class='t706__product-plus']")
    private WebElement buttonPlus;

    @FindBy(xpath = ".//*[@class='t706__product-quantity']")
    private WebElement quantity;

    @FindBy(xpath = ".//*[@name='Name']")
    private WebElement fioInput;

    @FindBy(xpath = ".//*[@name='tildaspec-phone-part[]']")
    private WebElement phoneImput;

    @FindBy(xpath = ".//*[@name='Адреса доставки']")
    private WebElement addressInput;

//    @FindBy(xpath = ".//input[@type='radio' and @value='До дверей (Зелена зона. Див. сторінку Зони доставки) 50 грн.=50']")
//    private WebElement radioButtonTotheDoor;

    @FindBy(xpath = ".//*[text()='До дверей (Зелена зона. Див. сторінку Зони доставки) 50 грн.']")
    private WebElement radioButtonToDoor;

//    @FindBy(xpath = ".//input[@type='radio' and @value='liqpay']")
//    private WebElement paymentWithCard;

    @FindBy(xpath = ".//*[text()=' Готівкою при отриманні ']")
    private WebElement payWithCash;

    @FindBy(xpath = ".//*[text()=' Кредитной картой (Visa, Mastercard) или Privat24 через LiqPay ']")
    private WebElement payWithCard;

    @FindBy(xpath = ".//*[@class='t-input t-inputtime js-tilda-rule js-tilda-mask ']")
    private WebElement desiredDeliveryTime;

    @FindBy(xpath = ".//*[@class='t-checkbox__indicator']")
    private WebElement checkbox;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement placeAnOrder;

    @FindBy(xpath = ".//*[@name='Name']//..//*[@class='t-input-error']")
    private WebElement messageFieldName;

    @FindBy(xpath = ".//*[@name='tildaspec-phone-part[]']//..//..//*[@class='t-input-error']")
    private WebElement messageFieldPhone;

    @FindBy(xpath = ".//*[@name='Адреса доставки']//..//..//*[@class='t-input-error']")
    private WebElement messageFieldAddress;

    @FindBy(xpath = ".//*[@class='t-form__errorbox-middle']")
    private WebElement messageGeneral;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage dellPizzaKidsInCart() {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(dellPizzaKids));
        clickOnElement(dellPizzaKids);
        logger.info("Product was deleted");
        return this;
    }

    public CartPage closeCart() {
        clickOnElement(buttonCloseCart);
        return this;
    }

    public CartPage сheckCartAfterDeletingItem() {
        webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(By.xpath
                (".//div[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']"), 0));
        Assert.assertTrue("Item has not been removed from the cart", !isElementDisplayed(pizzaKidsInShoppingCart));
        return this;
    }

    public CartPage clickOnButtonPlus() {
        clickOnElement(buttonPlus);
        return this;
    }

    public CartPage checkCounter(String a) {
        Assert.assertEquals("Number ", a, quantity.getText());
        logger.info("Number " + quantity.getText());

        return this;
    }

    public CartPage clickOnButtonMinus() {
        clickOnElement(buttonMinus);
        return this;
    }

    public CartPage enterTextIntoFioInput(String text) {
        enterTextIntoInput(fioInput, text);
        return this;
    }

    public CartPage enterTextIntoPhoneInput(String text) {
        enterTextIntoInput(phoneImput, text);
        return this;
    }

    public CartPage enterTextIntoAddressInput(String text) {
        enterTextIntoInput(addressInput, text);
        return this;
    }

    public CartPage clickOnRadioButtonToTheDoor() {
        clickOnElement(radioButtonToDoor);
        return this;
    }

    public CartPage clickOnRadioButtonPayCash() {
        clickOnElement(payWithCash);
        return this;
    }

    public CartPage clickOnRadioButtonPaymentWithCard() {
        clickOnElement(payWithCard);
        return this;
    }

    public CartPage enterNumbersToFieldTime(String numbers) {
        enterTextIntoInput(desiredDeliveryTime, numbers);
        return this;
    }

    public CartPage checkDeliveryTime(String numbers) {

        Assert.assertEquals("Time Delivery ", numbers, desiredDeliveryTime.getText());
        return this;
    }

    public CartPage clickOnCheckBox(String text) {
        isCheckboxCondition(checkbox, text);
        return this;
    }

    public CartPage clickOnButtonPlaceAnOrderWithCash() {
        clickOnElement(placeAnOrder);
        return this;
    }

    public LiqpayPage clickOnButtonPlaceOrderWithCard() {
        clickOnElement(placeAnOrder);
        return new LiqpayPage(webDriver);
    }

    public CartPage checkIsMessagesDisplayed() {
        Assert.assertTrue("Message is not displayed", messageFieldNameDisplayed());
        Assert.assertTrue("Message is not displayed", messageFieldPhoneDisplayed());
        Assert.assertTrue("Message is not displayed", messageFieldDeliveryAddressDisplayed());
        Assert.assertTrue("Message is not displayed", messageGeneralDisplayed());
        return this;
    }

    public boolean messageFieldNameDisplayed() {
        return isMessageDisplayed(messageFieldName);
    }

    public boolean messageFieldPhoneDisplayed() {
        return isMessageDisplayed(messageFieldPhone);
    }

    public boolean messageFieldDeliveryAddressDisplayed() {
        return isMessageDisplayed(messageFieldAddress);
    }

    public boolean messageGeneralDisplayed() {
        return isMessageDisplayed(messageGeneral);
    }
}
