package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class ParentPageWithElement extends ParentPage {

    @FindBy(xpath = ".//*[@class='t706__carticon-img']")
    WebElement cart;

    @FindBy(xpath = ".//*[@class='t1002__wishlisticon-wrapper']")
    WebElement wish;

    public ParentPageWithElement(WebDriver webDriver) {
        super(webDriver);
    }

    public WishPopUpPage checkIsRedirectWishPopUp() {
        isElementDisplayed(wish);
        return new WishPopUpPage(webDriver);
    }

    public WishPopUpPage openWishPopUp() {
        clickOnElement(wish);
        return new WishPopUpPage(webDriver);
    }

    public CartPage openCart() {
        clickOnElement(cart);
        return new CartPage(webDriver);
    }
}
