package by.ittechno;

import by.ittechno.reporting.MyLogger;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
    private WebDriver driver;
    public Browser(WebDriver driver) {
        this.driver = driver;
    }
    public void highlightElement(WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    public void click(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(element);
        MyLogger.info("Clicking element" + element.getText() + " Located:" + element.getLocation());
        element.click();
    }
    public void sendKeys(String searchString, WebElement searchInput) {
        MyLogger.info("Type text in located:" + searchInput.getLocation());
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchInput));
        highlightElement(searchInput);
        searchInput.sendKeys(searchString);
    }
    public void doubleClick(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        MyLogger.info("Double click on an item located:" + element.getLocation());
        highlightElement(element);
        new Actions(driver).doubleClick(element).build().perform();
    }
    @Attachment(value = "Exception screenshot")
    public static byte[] takeScreenshot(WebDriver driver) {
        byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screen;
    }

}
