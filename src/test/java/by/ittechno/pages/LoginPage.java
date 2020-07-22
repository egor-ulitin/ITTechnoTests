package by.ittechno.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage extends AbstractPage{

    public LoginPage(EventFiringWebDriver driver) {
        super();
    }
    public boolean isLoginPage()
    {
        String title = driver.getTitle();
        return title.equals("Авторизоваться");
    }
}
