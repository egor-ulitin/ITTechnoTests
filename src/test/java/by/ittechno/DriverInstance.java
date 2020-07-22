package by.ittechno;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.HashMap;

public class DriverInstance {
    static HashMap<String, EventFiringWebDriver> drivers = new HashMap<String, EventFiringWebDriver>();
    static Browser browser;
    private DriverInstance() {
    }
    public static EventFiringWebDriver getDriverInstance(String driverType) {
        if (drivers != null && drivers.containsKey(driverType)) {
            return drivers.get(driverType);
        }
        else {
            if (driverType.equals("FirefoxDriver")) {
                EventFiringWebDriver driver = firefoxDriverCreator();
                drivers.put(driverType, driver);
                return driver;
            }
            else {
                EventFiringWebDriver driver = chromeDriverCreator();
                WebDriverListener listener = new WebDriverListener();
                driver.register(listener);
                drivers.put(driverType, driver);
                return driver;
            }
        }
    }
    //Для chrome
    private static EventFiringWebDriver chromeDriverCreator() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        EventFiringWebDriver webDriverEventListener = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
        return webDriverEventListener;
    }
    private static EventFiringWebDriver firefoxDriverCreator() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        EventFiringWebDriver webDriverEventListener = new EventFiringWebDriver(new FirefoxDriver(firefoxOptions));
        WebDriverListener listener = new WebDriverListener();
        webDriverEventListener.register(listener);
        return webDriverEventListener;
    }
    public static Browser getInstanceBrowser(EventFiringWebDriver webDriver) {
        if (browser != null) {
            return browser;
        }
        else {
            browser = new Browser(webDriver);
            return browser;
        }
    }
}
