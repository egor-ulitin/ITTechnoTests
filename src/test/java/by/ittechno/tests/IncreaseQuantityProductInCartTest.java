package by.ittechno.tests;//package by.ittechno.tests;
import by.ittechno.pages.CartPage;
import by.ittechno.pages.CatalogPage;
import by.ittechno.pages.DescriptionProductPage;
import by.ittechno.pages.GeneralPage;
import by.ittechno.reporting.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class IncreaseQuantityProductInCartTest extends BaseTest {
    @Test
    public void increaseQuantityProductInCartTest() {
        CatalogPage catalogPage = new GeneralPage(driver).searchProductsInCatalog("Камера");
        Assert.assertTrue(catalogPage.isCatalogPage(), "Каталог не открылся");
        DescriptionProductPage descriptionProductPage = catalogPage.goToDescriptionProduct(1);
        Assert.assertTrue(descriptionProductPage.isDescriptionProductPage(), "Подробное описание продукта не открылось");
        CartPage cartPage = descriptionProductPage.goToCartPage();
        Assert.assertTrue(cartPage.isCartPage(), "Корзина не открылась");
        int numberProducts = cartPage.increaseQuantityOfProduct().getQuantityProductInCart();
        Assert.assertEquals(numberProducts, 2, "Увеличить количество товара в корзине не удалось");
    }
}
