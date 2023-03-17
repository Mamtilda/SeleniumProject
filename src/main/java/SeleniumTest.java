import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Mamta Thind/Downloads/geckodriver-v0.32.2-win32/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        driver = new FirefoxDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAmazon() {
        amazonLaunch();
        acceptCookies();
        amazonSearch();
        amazonSelectItem();
        amazonAddToCart();
        amazonRemoveFromCart();
        amazonHomePage();
    }

    private void amazonLaunch() {
        driver.get("https://www.amazon.co.uk/");
    }

    private void acceptCookies() {
        WebElement acceptButton = driver.findElement(By.id("sp-cc-accept"));
        acceptButton.click();
    }

    private void amazonSearch() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("speakers");
        searchBox.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-asin] h2 a")));
    }

    private void amazonSelectItem() {
        driver.findElement(By.cssSelector("[data-asin] h2 a")).click();
    }

    private void amazonAddToCart() {
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    private void amazonRemoveFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement basketButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-labelledby='attach-sidesheet-view-cart-button-announce']")));
        basketButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
        deleteButton.click();
    }

    private void amazonHomePage() {
        driver.findElement(By.id("nav-logo-sprites")).click();
    }
}
