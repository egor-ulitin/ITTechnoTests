package by.ittechno.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class NewsPage extends AbstractPage{

    public NewsPage(EventFiringWebDriver driver) {
        super();
    }
    public boolean isNewsPage() {
        return driver.getTitle() == "Новости компании";
    }
}
