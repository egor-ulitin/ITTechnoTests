package by.ittechno.pages;

import by.ittechno.Browser;
import by.ittechno.DriverInstance;
import by.ittechno.WebDriverListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.sql.Driver;

public class AbstractPage {

    protected static Browser browser;
    public AbstractPage(Browser browser) {
        this.browser = browser;
      //  this.driver = driver;
    //    browser = DriverInstance.getInstanceBrowser(driver);
        PageFactory.initElements(browser.getDriver(), this);
    }
}
