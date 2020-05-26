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

public class Flipkart extends TestBase {
    WebDriver driver;
    SeleniumWrapper se;
    Amazon amazon;

    public Flipkart(WebDriver driver) {
        this.driver = driver;
        se = new SeleniumWrapper(driver);
        amazon = new Amazon(driver);
    }

    public static String flipkartUrl = "https://www.flipkart.com/";
    public static String productName = "Apple iPhone XR (Yellow, 64 GB)";
    public static String flipKartPrice = null;

    //WebElements
    @FindBy(xpath = "//button[text()='✕']")
    WebElement closePopupBtn;
    @FindBy(xpath = "//form[@action='/search']//input[contains(@title,'Search')]")
    WebElement productSearchBox;
    @FindBy(xpath = "//h1//span")
    WebElement productNameInPage;
    @FindBy(xpath = "//div[@class='_1vC4OE _3qQ9m1']")
    WebElement price;

    //Methods
    public void goToFlipkartAndSearchProduct() {
        try {
            driver.navigate().to(flipkartUrl);
            se.waitAndClick(closePopupBtn);
            productSearchBox.sendKeys(Amazon.productName);
            productSearchBox.sendKeys(Keys.ENTER);
        } catch (Exception e) {
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

    public void goToFlipkartProductPage() {
        amazon.goToProductPage(productNameInPage);
    }

    public void fetchFlipkartProductPrice() {
        String priceText = price.getText();
        flipKartPrice = priceText.replaceAll("\\s|₹|,", "");
        driver.close();
    }


}
