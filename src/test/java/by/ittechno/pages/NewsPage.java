package by.ittechno.pages;

import by.ittechno.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class NewsPage extends AbstractPage{

    public NewsPage(Browser browser) {
        super(browser);
    }
    public boolean isNewsPage() {
        return browser.getDriver().getTitle() == "Новости компании";
    }
}
