package Framework.Selenium;

import Commons.Utils.GenericUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumDriver {
    private static Logger log = LogManager.getLogger(SeleniumDriver.class.getName());

    private static SeleniumDriver seleniumDriver;
    private static WebDriver driver;
    private static WebDriverWait waitDriver;
    private static Wait<WebDriver> wditDriverFluent;
    private final static int TIMEOUT = 30;
    private final static int PAGE_LOAD_TIMEOUT = 120;

    private SeleniumDriver(){
        log.info("Selenium driver initialization....");

        String downloadFilePath = GenericUtils.getCurrentDir().concat("\\downloads");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory",downloadFilePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        //driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver, TIMEOUT);
        wditDriverFluent = new FluentWait<>(SeleniumDriver.getDriver())
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(3,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        String window = driver.getWindowHandle();
        System.out.println("Window -> ".concat(window));
        log.info(".....Selenium driver initialized");
    }

    public static WebDriverWait getWait(){
        return waitDriver;
    }

    public static Wait<WebDriver> getFluentWait() {return wditDriverFluent;}

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setUpDriver(){
        if(seleniumDriver == null){
            seleniumDriver = new SeleniumDriver();
        }
    }

    public static void tearDown(){
        log.info("Selenium driver teardown...");
        if(driver != null){
            driver.close();
            driver.quit();

        }
        seleniumDriver = null;
    }

}
