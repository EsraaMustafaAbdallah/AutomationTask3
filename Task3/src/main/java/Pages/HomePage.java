package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    String URL = "https://www.levelset.com/";
    String getPaidXpath = "//a[@class='btn btn-info btn-outline mob-dropdown-btn']";

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public  void navigateToHomePage(){
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPaidXpath)));
    }
    public  void  clickOnGetPaid(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getPaidXpath)));
        WebElement button = driver.findElement(By.xpath(getPaidXpath));
        if(button.isEnabled()){
            button.click();
            button.click();
        }
        else {
            System.out.println("The Button is not clickable");
        }
    }






}
