package Suite.Models.Actions.Liverpool;

import Commons.Utils.GenericUtils;
import Framework.Selenium.SeleniumDriver;
import Framework.Selenium.SeleniumHelper;
import Suite.Models.Actions.BaseActions;
import Suite.Models.Locators.Liverpool.LiverpoolHomeLocators;
import cucumber.api.java.cs.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LiverpoolPageActions extends BaseActions {
    public LiverpoolHomeLocators locators;

    public LiverpoolPageActions(){
        locators = new LiverpoolHomeLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), locators);
    }

    public void waitForPageToLoad() {
        SeleniumHelper.WaitForElementToBeDisplayed(locators.boutiquesNavBar);
    }


    public void searchItem(String item) {
        locators.searchBar.sendKeys(item.concat(Keys.ENTER.toString()));
    }

    public void verifyPlayStationTitlesOnListing(String criteria, int minCriteria) {
        Assert.assertTrue(GenericUtils.listOfTextContainsAtLeast(locators.listingTitles,criteria, minCriteria));
    }


    public void waitForSearchToFinish() {
        SeleniumHelper.WaitForElementToBeDisplayed(locators.itemsCount);
    }

    public void selectItem(String item) {
        GenericUtils.getWebElementByXpathAndValue(locators.dynamicItem,item).click();
    }

    public String getItemTitle(String criteria) {
        return GenericUtils.getWebElementByXpathAndValue(locators.dynamicItem, criteria).getText();
    }

    public String getItemPrice(String criteria) {
        return GenericUtils.getWebElementByXpathAndValue(locators.dynamicItemPrice, criteria).getText();
    }

    public void clickOnCategoryAndSubCategory(String category, String subCategory) {
        Actions act = new Actions(SeleniumDriver.getDriver());
        act.moveToElement(locators.category_link).build().perform();
        WebElement subElement = GenericUtils.getWebElementByXpathAndValue(locators.dynamicCategory, category);
        SeleniumHelper.fluentWaitForElementToBeDisplayed(subElement);
                act.moveToElement(subElement).build().perform();
                GenericUtils.getWebElementByXpathAndValue(locators.dynamicSubCategory, subCategory).click();
    }
}
