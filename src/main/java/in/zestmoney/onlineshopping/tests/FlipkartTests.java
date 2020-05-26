package in.zestmoney.onlineshopping.tests;

import in.zestmoney.onlineshopping.pages.Flipkart;
import in.zestmoney.onlineshopping.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FlipkartTests extends TestBase {
    Flipkart flipkart;

    public FlipkartTests() {
        flipkart = PageFactory.initElements(driver, Flipkart.class);
    }

    @Test
    public void goToFlipkartSiteAndSearchProduct() {
        flipkart.goToFlipkartAndSearchProduct();
    }

    @Test
    public void selectProduct() {
        flipkart.selectProduct();
    }

    @Test
    public void getPriceOfTheProductFlipkart() {
        flipkart.goToFlipkartProductPage();
        flipkart.fetchFlipkartProductPrice();
    }

    /*@Test
    public void comparePrices() {
        flipkart.comparePrice();
    }*/

}
