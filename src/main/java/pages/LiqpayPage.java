package pages;


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

    public LiqpayPage checkIsRedirectToLiqpayPage() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(send));
        isElementDisplayed(send);

        return this;
    }
}
