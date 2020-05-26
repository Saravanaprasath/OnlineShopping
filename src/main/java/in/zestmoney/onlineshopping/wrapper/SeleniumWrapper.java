package in.zestmoney.onlineshopping.wrapper;

import in.zestmoney.onlineshopping.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrapper extends TestBase {
    WebDriver driver;

    public SeleniumWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAndClick(WebElement element) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
            ele.click();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
