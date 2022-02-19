package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BurgersPage extends ParentPageWithElement {

    @FindBy(xpath = ".//a//*[text()='Бургер «Міні»']//..//..//..//..//*[text()='У кошик']")
    private WebElement burgerMiniToCart;

    public BurgersPage(WebDriver webDriver) {
        super(webDriver);
    }


    public BurgersPage addBurgerMiniToCart() {
        clickOnElement(burgerMiniToCart);
        return this;
    }

}
