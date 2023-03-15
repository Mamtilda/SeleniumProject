import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SeleniumTest {

    WebDriver driver;

    public void amazonLaunch() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Mamta Thind/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        driver = new FirefoxDriver(options);
        driver.get("https://www.amazon.co.uk");
    }
    public void acceptCookies() {
        WebElement acceptButton = driver.findElement(By.id("sp-cc-accept"));
        acceptButton.click();
    }

    public void amazonSearch() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public void amazonSelectItem() {
        driver.findElement(By.cssSelector("[data-asin] h2 a")).click();
    }
    public void amazonAddToCart() {
        driver.findElement(By.id("add-to-cart-button")).click();
        WebElement noThanksButton = driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", noThanksButton);
    }
    /*
    public void amazonRemoveFromCart() {
        driver.findElement(By.id("nav-cart-count-container")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit.deleteItem")));
        WebElement deleteButton = driver.findElement(By.name("submit.deleteItem"));
        deleteButton.click();

    }*/
    public static void main(String [] args) {
        SeleniumTest test = new SeleniumTest();

        test.amazonLaunch();
        test.acceptCookies();
        test.amazonSearch();
        test.amazonSelectItem();
        test.amazonAddToCart();
        
    }



}