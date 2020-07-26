package by.ittechno;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.HashMap;

public class DriverInstance {
    static HashMap<String, Browser> browsers = new HashMap<String, Browser>();
    private DriverInstance() {
    }
    public static Browser getDriverInstance(String driverType) {
        if (browsers.containsKey(driverType) && browsers.get(driverType).getDriver() != null) {
            return browsers.get(driverType);
        } else {
            if (driverType.equals("FirefoxDriver")) {
                EventFiringWebDriver driver = firefoxDriverCreator();
                browsers.put(driverType, new Browser(driver));
            } else {
                EventFiringWebDriver driver = chromeDriverCreator();
                browsers.put(driverType, new Browser(driver));
            }
            return browsers.get(driverType);
        }

    }
    //Для chrome
    private static EventFiringWebDriver chromeDriverCreator() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        EventFiringWebDriver webDriverEventListener = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
        WebDriverListener listener = new WebDriverListener();
        webDriverEventListener.register(listener);
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
}
