package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BurgersPage;
import pages.CartPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected HomePage homePage;
    protected BurgersPage burgerPage;
    protected CartPage cartPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        homePage = new HomePage(webDriver);
        cartPage = new CartPage(webDriver);
    }

//    @After
//    public void tearDown() {
//        webDriver.quit();
//        logger.info("Browser was closed");
//
//    }

}
