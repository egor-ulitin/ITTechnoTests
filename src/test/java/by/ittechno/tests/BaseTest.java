package by.ittechno.tests;

import by.ittechno.Browser;
import by.ittechno.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.TestResult;

import java.util.concurrent.TimeUnit;

public class BaseTest{
    protected EventFiringWebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {

        driver = DriverInstance.getDriverInstance("ChromeDriver");
        driver.get("http://it-techno.by/");
    }
    @AfterTest
    public void stopBrowser() {
        driver.close();
    }
}
