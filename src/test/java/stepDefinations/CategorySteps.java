package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CategorySteps {

    public static WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE_URL = "https://www.demoblaze.com";

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
        driver.get(BASE_URL);
    }

    @When("I click on the {string} category")
    @Step("Clicking on category: {0}")
   
    public void i_click_on_the_category(String category) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText(category))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    @Then("I should see the products for {string} category")
    @Step("Verifying products for category: {0}")
    public void i_should_see_the_products_for_category(String category) {
        List<WebElement> products = wait.until(
                ExpectedConditions.refreshed(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#tbodyid .card-title"))
                )
        );
        assertFalse(products.isEmpty(), "No products found for category: " + category);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            attachScreenshot();
        }
        if (driver != null) driver.quit();
    }

    @Attachment(value = "Failed Step Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
