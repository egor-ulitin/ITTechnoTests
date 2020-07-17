package by.ittechno.pages;

import by.ittechno.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected static WebDriver driver;
    protected static Browser browser;
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        browser = new Browser(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public  boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
