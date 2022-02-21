package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishPopUpPage extends ParentPageWithElement {

    @FindBy(xpath = ".//*[@class='t1002__product-link']")
    private WebElement burgerSuperInWish;

    public WishPopUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WishPopUpPage checkBurgerSuperInWish() {
        isElementDisplayed(burgerSuperInWish);
        return this;
    }
}
