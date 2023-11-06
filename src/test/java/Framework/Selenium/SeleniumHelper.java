package Framework.Selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumHelper {

    private static Logger log = LogManager.getLogger(SeleniumHelper.class.getName());

    public static void WaitForElementToBeClickable(WebElement we){
        SeleniumDriver.getWait().until(ExpectedConditions.elementToBeClickable(we));
    }

    public static void WaitForElementToBeDisplayed(WebElement we){
        SeleniumDriver.getWait().until(ExpectedConditions.visibilityOf(we));
    }

    public static void fluentWaitForElementToBeDisplayed(WebElement we){
        SeleniumDriver.getFluentWait().until(ExpectedConditions.visibilityOf(we));
    }

    public static void FluentWaitForElementToBeDisplayed(WebElement we){



    }

    public static void waitForPageToLoad(){
        SeleniumDriver.getWait().until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static String waitForPageToLoad(String currentUrl){
        SeleniumDriver.getWait().until(
                webDriver -> !webDriver.getCurrentUrl().equals(currentUrl));
        return SeleniumDriver.getDriver().getCurrentUrl();
    }
}
