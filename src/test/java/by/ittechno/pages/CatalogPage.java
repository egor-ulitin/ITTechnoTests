package by.ittechno.pages;

import by.ittechno.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'smallparamscont catalog-rewrite-item']//div[@class = 'pic']")
    private List<WebElement> productPhoto;

    public CatalogPage(Browser browser) {
        super(browser);
    }

    @Step("Переход к экрану подробного описания товара")
    public DescriptionProductPage goToDescriptionProduct(int numberProductInCatalog) {
        browser.click(productPhoto.get(numberProductInCatalog - 1));
        return new DescriptionProductPage(browser);
    }
    public boolean isCatalogPage() {
       // new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(productPhoto));
        return productPhoto.size() != 0;
    }
}
