package pages;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LiqpayPage extends ParentPageWithElement{

    @FindBy(xpath = ".//*[text()='Сплатити ']")
    private WebElement send;

    public LiqpayPage(WebDriver webDriver) {
        super(webDriver);
    }
    public LiqpayPage checkIsRedirectToLiqpayPage(){
        isElementDisplayed(send);
        return this;
    }
}
