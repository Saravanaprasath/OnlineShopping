package in.zestmoney.onlineshopping.pages;


import in.zestmoney.onlineshopping.testbase.TestBase;
import in.zestmoney.onlineshopping.wrapper.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Amazon extends TestBase {
    WebDriver driver;
    SeleniumWrapper se;
    public String productNameInWebPage;
    ArrayList<String> tabs;

    public Amazon(WebDriver driver) {
        this.driver = driver;
        se = new SeleniumWrapper(driver);
    }

    public static String amazonUrl = "https://www.amazon.in/";
    public static String productName = "iPhone XR (64GB) - Yellow";
    public static String amazonPrice = null;

    //WebElements
    @FindBy(id = "twotabsearchtextbox")
    WebElement productSearchBox;
    @FindBy(xpath = "//div[@id='price']//span[@id='priceblock_ourprice']")
    WebElement price;
    @FindBy(xpath = "//span[@id='productTitle']")
    WebElement productTitle;


    //Methods
    public void goToAmazonAndSearchProduct() {
        try {
            driver.get(amazonUrl);
            se.waitAndClick(productSearchBox);
            productSearchBox.sendKeys(productName);
            productSearchBox.sendKeys(Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }


    public void selectProduct() {
        try {
            String product = "//img[contains(@alt,'" + productName + "')]";
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(product)));
            WebElement productItem = driver.findElement(By.xpath(product));
            productItem.click();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void goToAmazonProductPage() {
        goToProductPage(productTitle);
    }



    public void goToProductPage(WebElement element) {
        try {
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            productNameInWebPage = element.getText().toLowerCase().trim();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }


    public void fetchAmazonProductPrice() {
        String priceText = price.getText();
        amazonPrice = priceText.replaceAll("\\s|₹|,", "");
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

}
