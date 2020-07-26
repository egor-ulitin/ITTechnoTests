package by.ittechno.pages;

import by.ittechno.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage extends AbstractPage{

    public LoginPage(Browser browser) {
        super(browser);
    }
    public boolean isLoginPage()
    {
        String title = browser.getDriver().getTitle();
        return title.equals("Авторизоваться");
    }
}
