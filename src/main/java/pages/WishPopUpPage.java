package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishPopUpPage extends ParentPageWithElement {

    @FindBy(xpath = ".//*[@class='t1002__product-link']")
    private WebElement burgerSuperInWish;

    @FindBy(xpath = ".//*[@class='t1002__wishlistwin-heading t-name t-name_xl']")
    private WebElement messageWish;

    public WishPopUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WishPopUpPage checkBurgerSuperInWish() {
        Assert.assertTrue(isElementDisplayed(burgerSuperInWish));
        return this;
    }
    public WishPopUpPage checkIsRedirectWishPopUp() {
        Assert.assertTrue(isElementDisplayed(messageWish));
        return new WishPopUpPage(webDriver);
    }
}
