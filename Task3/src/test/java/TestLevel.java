import Pages.DocumentPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLevel {

    HomePage homePage;
    DocumentPage documentPage;
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        homePage=new HomePage(driver);
        documentPage=new DocumentPage(driver);
    }
    @Test
    public void testDocumentPrice(){
        homePage.navigateToHomePage();
        homePage.clickOnGetPaid();
        String price=documentPage.getPrice();
        Assert.assertEquals(price,"$449","The price doesn't match");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
