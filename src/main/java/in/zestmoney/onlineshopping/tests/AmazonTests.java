package in.zestmoney.onlineshopping.tests;

import in.zestmoney.onlineshopping.pages.Amazon;
import in.zestmoney.onlineshopping.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AmazonTests extends TestBase {
    Amazon amazon;

    public AmazonTests() {
        amazon = PageFactory.initElements(driver, Amazon.class);
    }

    @Test
    public void goToAmazonSiteSearchProduct() {
        amazon.goToAmazonAndSearchProduct();
    }

    @Test
    public void selectProduct() {
        amazon.selectProduct();
    }

    @Test
    public void getPriceOfTheProduct() {
        amazon.goToAmazonProductPage();
        amazon.fetchAmazonProductPrice();
    }

}
