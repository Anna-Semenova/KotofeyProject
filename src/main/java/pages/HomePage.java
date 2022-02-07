package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openHomePage() {
        try {
            webDriver.get("https://kotofey-cafe.com.ua/");
            logger.info("HomePage was opened ");
        } catch (Exception e) {
            logger.error("Can not open HomePage " + e);
            Assert.fail("Can not open HomePage ");
        }
    }
}
