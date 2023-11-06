package Suite.Models.Actions.Liverpool;

import Commons.Utils.GenericUtils;
import Framework.Selenium.SeleniumDriver;
import Framework.Selenium.SeleniumHelper;
import Suite.Models.Actions.BaseActions;
import Suite.Models.Locators.Liverpool.LiverpoolHomeLocators;
import Suite.Models.Locators.Liverpool.LiverpoolItemLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LiverpoolItemPageActions extends BaseActions {
    public LiverpoolItemLocators locators;

    public LiverpoolItemPageActions(){
        locators = new LiverpoolItemLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), locators);
    }

    public void waitForPageToLoad() {
        SeleniumHelper.WaitForElementToBeDisplayed(locators.ratingElement);
    }


}
