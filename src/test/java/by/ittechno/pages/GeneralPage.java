package by.ittechno.pages;

import by.ittechno.reporting.MyLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeneralPage extends  AbstractPage {


    @FindBy(id = "enter")
    private WebElement searchInput;

    @FindBy(xpath = "//form[@id = 'searchfield_form']//button[@type = 'submit']")
    private WebElement searchBtn;

    @FindBy(id = "head_geo_select")
    private WebElement cityChangeButton;

    @FindBy(className = "select_city_search_input")
    private WebElement selectCitySearchInput;

    @FindBy(xpath = "//div[@class ='date']/../div[@class = 'title']//a")
    private List<WebElement> lastNews;

    @FindBy(className = "catalog-btn")
    private WebElement openCatalogMenuButton;

    @FindBy(xpath = "//a[@class='kiki']")
    private List<WebElement> categoryInCatalogMenu;

    @FindBy(xpath = "//a[@rel ='loginform']")
    private WebElement personalAccountButton;

    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    @Step("Поиск товаров в каталоге")
    public CatalogPage searchProductsInCatalog(String searchString) {
        browser.sendKeys(searchString, searchInput);
        browser.click(searchBtn);
        return new CatalogPage(driver);
    }
    @Step("Выбор другого города через поиск")
    public GeneralPage changeCityThroughSearch(String city) {
        new WebDriverWait(driver, 10).until((ExpectedConditions.visibilityOf(cityChangeButton)));
        browser.click(cityChangeButton);
        browser.sendKeys(city, selectCitySearchInput);
        selectCitySearchInput.sendKeys(Keys.ENTER);
        return new GeneralPage(driver);
    }

    public String getSelectedCity() {
        return cityChangeButton.getText();
    }

    @Step("Переход к описании новости")
    public NewsPage goToDescriptionNews(int numberNewsOnMainPage) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                elementToBeClickable(lastNews.get(numberNewsOnMainPage - 1)));
        browser.highlightElement(lastNews.get(numberNewsOnMainPage - 1));
        MyLogger.info("Move to element " + lastNews.get(numberNewsOnMainPage).getLocation());
        new Actions(driver).moveToElement(lastNews.get(numberNewsOnMainPage), 100, 1).
                click().build().perform();
        return new NewsPage(driver);
    }
    @Step("Выбор категории в каталоге")
    public CatalogPage selectCategoryInCatalog(String category) {
        browser.click(openCatalogMenuButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(categoryInCatalogMenu));
        for (WebElement item : categoryInCatalogMenu) {
            if (item.equals(category)) {
                browser.doubleClick(item);
                return new CatalogPage(driver);
            }
        }
        return null;
    }
    @Step("Переход к экрану логина")
    public LoginPage goToLoginPage() {
        driver.getCurrentUrl();
        browser.click(personalAccountButton);
        return new LoginPage(driver);
    }
}
