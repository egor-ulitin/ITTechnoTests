package by.ittechno.tests;

import by.ittechno.pages.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        Boolean checkIsItLoginPage = new GeneralPage(driver).goToLoginPage().isLoginPage();
        Assert.assertTrue(checkIsItLoginPage, "Переход на экран логина не выполнен");
    }
}
