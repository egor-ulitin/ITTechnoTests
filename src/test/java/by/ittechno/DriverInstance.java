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
    static HashMap<String, WebDriver> drivers = new HashMap<String, WebDriver>();
    private DriverInstance() {
    }
    public static WebDriver getDriverInstance(String name, String driverType) {
        if (drivers != null && drivers.containsKey(name)) {
            return drivers.get(name);
        } else {
            if (driverType.equals("FirefoxDriver")) {
                WebDriver driver = firefoxDriverCreator();
                drivers.put(name, driver);
                return driver;
            }
            else {
                WebDriver driver = chromeDriverCreator();
                drivers.put(name, driver);
                return driver;
            }
        }
    }
    //Для chrome
    private static WebDriver chromeDriverCreator() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        EventFiringWebDriver webDriverEventListener = new EventFiringWebDriver(new ChromeDriver());
        WebDriverListener listener = new WebDriverListener();
        webDriverEventListener.register(listener);
        return webDriverEventListener;
    }
    private static WebDriver firefoxDriverCreator() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        EventFiringWebDriver webDriverEventListener = new EventFiringWebDriver(new FirefoxDriver());
        WebDriverListener listener = new WebDriverListener();
        webDriverEventListener.register(listener);
        return webDriverEventListener;
    }
}
