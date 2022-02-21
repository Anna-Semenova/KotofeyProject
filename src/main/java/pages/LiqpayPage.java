package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LiqpayPage extends ParentPageWithElement {

    @FindBy(xpath = ".//*[@class='button__send' and text()='Сплатити']")
    private WebElement send;

    public LiqpayPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonSendDisplayed() {
        try {
            return isElementDisplayed(send);
        } catch (Exception e) {
            return false;
        }
    }

    public LiqpayPage checkIsRedirectToLiqpayPage() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(send));
        Assert.assertTrue("Element is not displayed", isButtonSendDisplayed());
        return this;
    }
}
