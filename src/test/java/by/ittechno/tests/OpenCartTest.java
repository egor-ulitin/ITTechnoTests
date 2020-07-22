package by.ittechno.tests;//package by.ittechno.tests;

import by.ittechno.pages.CatalogPage;
import by.ittechno.pages.DescriptionProductPage;
import by.ittechno.pages.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {
    @Test
    public void openCart() throws InterruptedException {
        boolean checkIsItCatalog = new GeneralPage(driver).searchProductsInCatalog("Камера").isCatalogPage();
        Assert.assertTrue(checkIsItCatalog, "Каталог не открылся");
        boolean checkIsItDescriptionProductPage = new CatalogPage(driver).goToDescriptionProduct(1)
                .isDescriptionProductPage();
        Assert.assertTrue(checkIsItDescriptionProductPage, "Подробное описание странички не открылось");
        boolean isCartOpen = new DescriptionProductPage(driver).goToCartPage().isCartPage();
        Assert.assertTrue(isCartOpen, "Корзина не открылась");
    }

}
