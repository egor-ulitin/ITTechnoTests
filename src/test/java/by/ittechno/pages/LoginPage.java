package by.ittechno.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public Boolean isLoginPage()
    {
        String title = driver.getTitle();
        return title.equals("Авторизоваться");
    }
}
