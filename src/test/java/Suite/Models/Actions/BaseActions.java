package Suite.Models.Actions;

import Commons.Utils.GenericUtils;
import Framework.Interfaces.IBaseActions;

import Framework.Selenium.SeleniumDriver;
import Suite.Models.Locators.Liverpool.LiverpoolBaseLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class BaseActions implements IBaseActions {

    private static Logger log = LogManager.getLogger(BaseActions.class.getName());

    public LiverpoolBaseLocators locators;
    public BaseActions() {
        locators = new LiverpoolBaseLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), locators);
    }

    @Override
    public void openPage(String url){
        log.info("Navigate to -> ".concat(url));
        SeleniumDriver.getDriver().get(url);
    }

    @Override
    public void openDefaultPage() {
        log.info("Navigate to -> ".concat(GenericUtils.GetProperty("definedUrl")));
        SeleniumDriver.getDriver().get(GenericUtils.GetProperty("definedUrl"));
    }

    public void hoverAndClickElement(WebElement hover, WebElement click){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(),e.getCause());
        }
        Actions act = new Actions(SeleniumDriver.getDriver());
        act.moveToElement(hover).click(click).perform();
        act = null;
    }

}
