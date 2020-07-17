package by.ittechno.pages;

import org.openqa.selenium.WebDriver;

public class NewsPage extends AbstractPage{

    public NewsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isNewsPage() {
        return driver.getTitle() == "Новости компании";
    }
}
