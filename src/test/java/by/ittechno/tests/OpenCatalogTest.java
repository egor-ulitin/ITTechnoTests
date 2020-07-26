package by.ittechno.tests;//package by.ittechno.tests;

import by.ittechno.pages.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCatalogTest extends BaseTest{
    @Test
    public void openCatalogTest() throws Exception {
        boolean checkIsItCatalogPage = new GeneralPage(browser).selectCategoryInCatalog("DECT").isCatalogPage();
        Assert.assertTrue(checkIsItCatalogPage, "Каталог не открылся");
    }
}
