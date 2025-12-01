package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    public void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
