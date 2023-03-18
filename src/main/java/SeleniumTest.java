import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class SeleniumTest {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void amazonLaunch() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Mamta Thind/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        driver = new FirefoxDriver(options);
        driver.get("https://www.amazon.co.uk/");
    }

    public void acceptCookies() {
        WebElement acceptButton = driver.findElement(By.id("sp-cc-accept"));
        acceptButton.click();
    }

    public void amazonSearch() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("speakers");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public void amazonSelectItem() {
        driver.findElement(By.cssSelector("[data-asin] h2 a")).click();
    }

    public void amazonAddToCart() {
        driver.findElement(By.id("add-to-cart-button")).click();
    }


    public void amazonRemoveFromCart() {
        WebDriverWait basketWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement goToBasket = basketWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sw-gtc")));
        goToBasket.click();

        WebElement deleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
        deleteButton.click();
    }

    public void amazonHomePage() {
        driver.findElement(By.id("nav-logo-sprites")).click();
        driver.quit();
    }

    @Test
    public void testAmazon() {
        this.amazonLaunch();
        this.acceptCookies();
        this.amazonSearch();
        this.amazonSelectItem();
        this.amazonAddToCart();
        this.amazonRemoveFromCart();
        this.amazonHomePage();

        //Verify that the driver has quit
        Assert.assertTrue(this.getDriver().toString().contains("(null)"));
    }
}
