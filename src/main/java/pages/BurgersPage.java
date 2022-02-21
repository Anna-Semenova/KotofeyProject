package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BurgersPage extends ParentPageWithElement {

    @FindBy(xpath = ".//a//*[text()='Бургер «Міні»']//..//..//..//..//*[text()='У кошик']")
    private WebElement burgerMiniToCart;

    @FindBy(xpath = ".//a//*[text()='Бургер «Супер»']//..//..//..//..//..//*[@class='t1002__addBtn']")
    private WebElement burgerSuperWish;

    public BurgersPage(WebDriver webDriver) {
        super(webDriver);
    }


    public BurgersPage addBurgerMiniToCart() {
        clickOnElement(burgerMiniToCart);
        return this;
    }

    public BurgersPage clickOnButtonWishOnBurgerSuper() {
        clickOnElement(burgerSuperWish);
        return this;
    }

    public BurgersPage checkIsRedirectWishPopUp() {
        isElementDisplayed(wish);
        return this;
    }

    public WishPopUpPage openWishPopUp() {
        clickOnElement(wish);
        return new WishPopUpPage(webDriver);
    }
}
