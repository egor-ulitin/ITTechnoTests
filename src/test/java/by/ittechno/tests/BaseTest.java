package by.ittechno.tests;

import by.ittechno.Browser;
import by.ittechno.DriverInstance;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestNGException;
import org.testng.annotations.*;
public class BaseTest{
    protected Browser browser;

    @BeforeMethod(description = "Start browser")
    public void startBrowser() {
        browser = DriverInstance.getDriverInstance("ChromeDriver");
        browser.getDriver().get("http://it-techno.by/");
    }
    @AfterMethod
    public void stopBrowser() throws TestNGException{
        browser.close();
    }
    @AfterMethod
    public void onTestFailure(ITestResult tr) {
        if(!tr.isSuccess()){
            makeScreenshot();
        }
    }
    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) browser.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
