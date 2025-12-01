package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

    private WebDriver driver;

    // Locator
    private By categoryHeader = By.cssSelector("h2, h1, .category-title");

    // Constructor
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get category title
    public String getCategoryTitle() {
        return driver.findElement(categoryHeader).getText().trim();
    }
}
