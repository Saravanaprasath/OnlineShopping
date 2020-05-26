package in.zestmoney.onlineshopping.testbase;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class TestBase {
    public static WebDriver driver = null;
    public static String browser = "Chrome";

    public TestBase() {
        if (driver == null) {
            initDriver();
        }
    }

    public void initDriver() {
        browser = browser.toLowerCase();
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println(osName);
        if (osName.contains("windows")) {
            if (browser.contains("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
            }
            if (browser.contains("firefox")) {
                System.setProperty("webdriver.chrome.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
        if (osName.contains("linux")) {
            if (browser.contains("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver(chromeOptions);
            }
            if (browser.contains("firefox")) {
                System.setProperty("webdriver.chrome.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
            }
        }
        if (osName.contains("mac")) {
            if (browser.contains("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_mac");
                driver = new ChromeDriver(chromeOptions);
            }
            if (browser.contains("firefox")) {
                System.setProperty("webdriver.chrome.driver", "drivers/geckodriver_mac");
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
    }

    //@AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}
