package by.ittechno.tests;//package by.ittechno.tests;

import by.ittechno.pages.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenDescriptionNewsTest extends BaseTest{
    @Test
    public void openDescriptionNewsTest() {
        Boolean checkIsItNewsPage = new GeneralPage(driver).goToDescriptionNews(1).isNewsPage();
        Assert.assertTrue(checkIsItNewsPage, "Подробное описание новости не открылось");
    }
}
