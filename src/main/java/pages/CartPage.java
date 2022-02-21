package pages;

import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends ParentPageWithElement {

    @FindBy(xpath = ".//div[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']//..//..//*[@class='t706__product-del']")
    private WebElement dellPizzaKids;

    @FindBy(xpath = ".//div[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']")
    private WebElement pizzaKidsInShoppingCart;

    @FindBy(xpath = ".//*[@class='t706__product-title t-descr t-descr_sm']//*[text()='Бургер «Міні»']")
    private WebElement burgerMiniInShoppingCart;

    @FindBy(xpath = ".//*[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']//..//..//*[@class='t706__product-minus']")
    private WebElement buttonMinus;

    @FindBy(xpath = ".//*[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']//..//..//*[@class='t706__product-plus']")
    private WebElement buttonPlus;

    @FindBy(xpath = ".//*[@class='t706__product-quantity']")
    private WebElement quantity;

    @FindBy(xpath = ".//*[@name='Name']")
    private WebElement fioInput;

    @FindBy(xpath = ".//*[@name='tildaspec-phone-part[]']")
    private WebElement phoneInput;

    @FindBy(xpath = ".//*[@name='Адреса доставки']")
    private WebElement addressInput;

    @FindBy(xpath = ".//*[text()='До дверей (Зелена зона. Див. сторінку Зони доставки) 50 грн.']")
    private WebElement radioButtonToDoor;

    @FindBy(xpath = ".//*[text()=' Готівкою при отриманні ']")
    private WebElement payWithCash;

    @FindBy(xpath = ".//*[text()=' Кредитной картой (Visa, Mastercard) или Privat24 через LiqPay ']")
    private WebElement payWithCard;

    @FindBy(xpath = ".//*[@class='t-input t-inputtime js-tilda-rule js-tilda-mask ']")
    private WebElement desiredDeliveryTime;

    @FindBy(xpath = ".//*[@class='t-checkbox__indicator']")
    private WebElement checkbox;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement placeOrder;

    @FindBy(xpath = ".//*[@name='Name']//..//*[@class='t-input-error']")
    private WebElement messageErrorFieldName;

    @FindBy(xpath = ".//*[@name='tildaspec-phone-part[]']//..//..//*[@class='t-input-error']")
    private WebElement messageErrorFieldPhone;

    @FindBy(xpath = ".//*[@name='Адреса доставки']//..//..//*[@class='t-input-error']")
    private WebElement messageErrorFieldAddress;

    @FindBy(xpath = ".//*[@class='t-form__errorbox-middle']//*[@class='t-form__errorbox-item js-rule-error js-rule-error-req']")
    private WebElement messageErrorFillAllFields;

    @FindBy(xpath = ".//*[@class='t-form__errorbox-middle']//*[@class='t-form__errorbox-item js-rule-error js-rule-error-name']")
    private WebElement messageErrorEnterName;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage dellPizzaKidsInCart() {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(dellPizzaKids));
        clickOnElement(dellPizzaKids);
        logger.info("Product was deleted");
        return this;
    }

    public CartPage сheckIsCartAfterDeletingPizzaKids() {
        webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(By.xpath
                (".//div[@class='t706__product-title t-descr t-descr_sm']//*[text()='Піца «Дитяча»']"), 0));
        Assert.assertTrue("Item has not been removed from the cart", !isElementDisplayed(pizzaKidsInShoppingCart));
        Assert.assertTrue("BurgerMini is not displayed ", isElementDisplayed(burgerMiniInShoppingCart));
        return this;
    }

    public CartPage clickOnButtonPlus() {
        clickOnElement(buttonPlus);
        return this;
    }

    public CartPage checkCounter(String numbersOf) {
        Assert.assertEquals("Number ", numbersOf, quantity.getText());
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
        enterTextIntoInput(phoneInput, text);
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
        Util.waitABit(5);
        return this;
    }

    public CartPage clickOnCheckBox(String text) {
        setStateToCheckBox(checkbox, text);
        return this;
    }

    public CartPage clickOnButtonPlaceOrder() {
        clickOnElement(placeOrder);
        return this;
    }

    public LiqpayPage clickOnButtonPlaceOrderWithCard() {
        clickOnElement(placeOrder);
        return new LiqpayPage(webDriver);
    }

    public CartPage checkIsMessagesDisplayed() {
        checkIsMessageNameDisplayed();
        checkIsMessagePhoneDisplayed();
        checkIsMessageAddressDisplayed();
        checkIsMessageFillAllDisplayed();
        checkIsMessageEnterNameDisplayed();
        return this;
    }

    public boolean isMessageFieldNameDisplayed() {
        return isMessageDisplayed(messageErrorFieldName);
    }

    public CartPage checkIsMessageNameDisplayed() {
        Assert.assertTrue("Message is not displayed", isMessageFieldNameDisplayed());
        return this;
    }

    public boolean isMessageFieldPhoneDisplayed() {
        return isMessageDisplayed(messageErrorFieldPhone);
    }

    public CartPage checkIsMessagePhoneDisplayed() {
        Assert.assertTrue("Message is not displayed", isMessageFieldPhoneDisplayed());
        return this;
    }

    public boolean isMessageFieldDeliveryAddressDisplayed() {
        return isMessageDisplayed(messageErrorFieldAddress);
    }

    public CartPage checkIsMessageAddressDisplayed() {
        Assert.assertTrue("Message is not displayed", isMessageFieldDeliveryAddressDisplayed());
        return this;
    }

    public boolean isMessageFillAllFieldsDisplayed() {
        return isMessageDisplayed(messageErrorFillAllFields);
    }

    public CartPage checkIsMessageFillAllDisplayed() {
        Assert.assertTrue("Message is not displayed", isMessageFillAllFieldsDisplayed());
        return this;
    }

    public boolean isMessageEnterNameDisplayed() {
        return isMessageDisplayed(messageErrorEnterName);
    }

    public CartPage checkIsMessageEnterNameDisplayed() {
        Assert.assertTrue("Message is not displayed", isMessageEnterNameDisplayed());
        return this;
    }

}
