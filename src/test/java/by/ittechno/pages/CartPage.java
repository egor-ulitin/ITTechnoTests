package by.ittechno.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "h2")
    private WebElement checkoutText;

    @FindBy(id = "plus")
    private WebElement increaseQuantityOfProductBtn;

    @FindBy(id = "kluk")
    private WebElement numberProducts;
    public boolean isCartPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkoutText));
        System.out.println(checkoutText.getText());
        return checkoutText.getText().contains("Оформление товара");
    }
    @Step("Увеличение количества товара")
    public CartPage increaseQuantityOfProduct() {
        browser.click(increaseQuantityOfProductBtn);
        return this;
    }

    public int getQuantityProductInCart() {
        browser.highlightElement(numberProducts);
        return Integer.parseInt(numberProducts.getText());
    }

}
