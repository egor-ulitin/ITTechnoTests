package by.ittechno.tests;

import by.ittechno.pages.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CitySelectionThroughSearch extends BaseTest {
    @Test
    public void changeCityThroughSearch() {
        String selectedCity = new GeneralPage(driver).changeCityThroughSearch("Москва").getSelectedCity();
        Assert.assertEquals(selectedCity, "Москва", "Изменить город не удалось");
    }
}
