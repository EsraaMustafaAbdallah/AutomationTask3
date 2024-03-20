package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocumentPage {

    WebDriver driver;
    String documentXpath="//div[@class='section']/div[3]/div/div[2]/span[@class='price-amount']";
    String URL ="https://app.levelset.com/wizard/SelectDocument/?_ga=2.235983745.1071780877.1710677540-148030363.1710677540";

    public DocumentPage(WebDriver driver){
        this.driver=driver;
    }
    public  void navigateToDocumentPage(){
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(documentXpath)));
    }
    public String getPrice() {
        String price = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        int trials = 3;
        int count = 0;
        while (count < trials) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(documentXpath)));
                break;
            } catch (TimeoutException e) {
                driver.navigate().refresh();
                count++;
            }
        }
        if (count == 3) {
            System.out.println("The Document Page Doesn't Load");
        } else {
            price = driver.findElement(By.xpath(documentXpath)).getText();
        }
        return price;
    }
}