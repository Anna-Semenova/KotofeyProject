package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class ParentPageWithElement extends ParentPage {

    @FindBy(xpath = ".//*[@class='t706__carticon-img']")
    WebElement cart;


    public ParentPageWithElement(WebDriver webDriver) {
        super(webDriver);
    }



}
