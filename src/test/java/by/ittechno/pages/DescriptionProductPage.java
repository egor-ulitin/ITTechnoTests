package by.ittechno.pages;

import by.ittechno.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DescriptionProductPage extends AbstractPage{
    @FindBy(xpath = "//span[@onclick = 'return pre_click(this);']")
    private WebElement buyProductButton;

    public DescriptionProductPage(Browser browser) {
        super(browser);
    }

    public Boolean isDescriptionProductPage() {
        String urlPage = browser.getDriver().getCurrentUrl();
        return urlPage.contains("productid");
    }
    @Step("Переход к корзине")
    public CartPage goToCartPage() {
        browser.click(buyProductButton);
        return new CartPage(browser);
    }
}
