package by.ittechno.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DescriptionProductPage extends AbstractPage{
    @FindBy(xpath = "//span[@onclick = 'return pre_click(this);']")
    private WebElement buyProductButton;

    public DescriptionProductPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isDescriptionProductPage() {
        String urlPage = driver.getCurrentUrl();
        return urlPage.contains("productid");
    }
    @Step("Переход к корзине")
    public CartPage goToCartPage() {
        browser.click(buyProductButton);
        return new CartPage(driver);
    }
}
