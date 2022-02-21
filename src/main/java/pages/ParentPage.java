package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


abstract public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    WebDriverWait webDriverWait10;
    protected String baseUrl = "https://kotofey-cafe.com.ua";

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, 10);
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isMessageDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info("Element is displayed");
            } else {
                logger.info("Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }

    }

    protected void enterTextIntoInput(WebElement webElement, String text) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was imputed ");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void isCheckboxCondition(WebElement checkbox, String condition) {
        try {
            if (condition.equalsIgnoreCase("switchOn") && checkbox.isSelected()) {
                logger.info("Checkbox is selected ");
            } else if (condition.equalsIgnoreCase("switchOff") && checkbox.isSelected()) {
                clickOnElement(checkbox);
                logger.info("Checkbox switched off ");
            } else if (condition.equalsIgnoreCase("switchOn") && !checkbox.isSelected()) {
                clickOnElement(checkbox);
                logger.info("Checkbox switched on ");
            } else if (condition.equalsIgnoreCase("switchOff ") && !checkbox.isSelected()) {
                logger.info("Checkbox not selected ");
            } else {
                logger.info("Condition is not selected ");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    private void printErrorAndStopTest(Exception e) {
        logger.info("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}
