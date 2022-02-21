package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPageWithElement {
    @FindBy(xpath = ".//*[@class='t395__title t-name t-name_xs' and text()='Піца']")
    private WebElement subPagePizza;

    @FindBy(xpath = ".//*[@class='t706__carticon-img']")
    private WebElement buttonCart;

    @FindBy(xpath = ".//*[@class='t395__title t-name t-name_xs' and text()='Бургери']")
    private WebElement subPageBurgers;

    @FindBy(xpath = ".//a//*[text()='Піца «Дитяча»']//..//..//..//..//*[text()='У кошик']")
    private WebElement pizzaKids;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage openHomePage() {
        try {
            webDriver.get(baseUrl + "/");
            logger.info("HomePage was opened ");
        } catch (Exception e) {
            logger.error("Can not open HomePage " + e);
            Assert.fail("Can not open HomePage ");
        }
        return this;
    }

    public HomePage addPizzaKidsInShoppingCart() {
        clickOnElement(pizzaKids);
        return this;
    }

    public HomePage clickOnSubPagePizza() {
        clickOnElement(subPagePizza);
        return this;
    }

    public boolean isButtonCartDisplayed() {
        try {
            return buttonCart.isDisplayed();
        } catch (Exception e) {
            logger.info("Button Cart is not displayed ");
            return false;
        }
    }

    public BurgersPage clickOnSubPageBurgers() {
        clickOnElement(subPageBurgers);
        return new BurgersPage(webDriver);
    }

    public HomePage checkIsButtonCartDisplayed() {
        Assert.assertTrue("Button is not displayed", isButtonCartDisplayed());
        return this;
    }
}
