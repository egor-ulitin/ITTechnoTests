package by.ittechno.tests;

import by.ittechno.Browser;
import by.ittechno.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.internal.TestResult;

import java.util.concurrent.TimeUnit;

public class BaseTest{
    protected WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver();
       // driver = DriverInstance.getDriverInstance("Driver", "ChromeDriver");
        driver.get("http://it-techno.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void stopBrowser() {
   //     if (result.getStatus() == ITestResult.FAILURE) {
     //       Browser.takeScreenshot(driver);
       // }
        driver.quit();
    }
}
