package in.zestmoney.onlineshopping.tests;

import org.testng.annotations.Test;

import static in.zestmoney.onlineshopping.pages.Amazon.amazonPrice;
import static in.zestmoney.onlineshopping.pages.Amazon.productName;
import static in.zestmoney.onlineshopping.pages.Flipkart.flipKartPrice;

public class CompareProductTests {

    @Test
    public void comparePrice() {
        double priceAmazon = Double.parseDouble(amazonPrice);
        double priceFlipkart = Double.parseDouble(flipKartPrice);
        System.out.println("==============");
        System.out.println("Product Name : "+productName);
        System.out.println("Amazon Price : " + priceAmazon);
        System.out.println("Flipkart Price : " + priceFlipkart);
        int result = Double.compare(priceAmazon,priceFlipkart);
        if(result > 0) {
            System.out.println("Flipkart price is less than the Amazon price");
        } else if(result < 0) {
            System.out.println("Amazon price is less than the Flipkart price");
        } else {
            System.out.println("Amazon price is equal to the Flipkart price");
        }
        System.out.println("===============");
    }
}
