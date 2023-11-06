package Suite.Steps.Liverpool;

import Commons.Utils.GenericUtils;
import Framework.Selenium.SeleniumDriver;
import Framework.Selenium.SeleniumHelper;
import Suite.Models.Actions.Liverpool.LiverpoolItemPageActions;
import Suite.Models.Actions.Liverpool.LiverpoolPageActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;



public class LiverpoolPageSteps {

    protected LiverpoolPageActions liverpoolPageActions;
    protected LiverpoolItemPageActions liverpoolItemPageActions;
    private String currentItemTitle;
    private String currentItemPrice;

    public LiverpoolPageSteps() {
        super();
        this.liverpoolPageActions = new LiverpoolPageActions();
        this.liverpoolItemPageActions = new LiverpoolItemPageActions();

    }

    @Given("^User navigate to \"([^\"]*)\" site$")
    public void user_navigate_to_site(String arg1) throws Throwable {
        liverpoolPageActions.openDefaultPage();
    }

    @When("^User wait until page is totally loaded$")
    public void user_wait_until_page_is_totally_loaded() throws Throwable {
        liverpoolPageActions.waitForPageToLoad();
    }

    @When("^User hover categories menu$")
    public void user_hover_categories_menu() throws Throwable {

    }

    @Then("^User filter by \"([^\"]*)\" brand$")
    public void user_filter_by_brand(String brand) throws Throwable {
        liverpoolPageActions.locators.viewMoreBrandButton.click();
        String currentUrl = SeleniumDriver.getDriver().getCurrentUrl();
        GenericUtils.getWebElementByXpathAndValue(liverpoolPageActions.locators.dynamicFilterCheck, brand).click();
        currentUrl = SeleniumHelper.waitForPageToLoad(currentUrl);

    }

    @Then("^User is able to see listing of \"([^\"]*)\" brand selection$")
    public void user_is_able_to_see_listing_of_brand_selection(String brand) throws Throwable {
        SeleniumDriver.getDriver().navigate().refresh();
        Assert.assertTrue(GenericUtils.listOfTextContainsAtLeast(liverpoolPageActions.locators.listingTitles, brand,10));
    }

    @When("^User search for \"([^\"]*)\"$")
    public void user_search_for(String item) throws Throwable {
        liverpoolPageActions.searchItem(item);
        liverpoolPageActions.waitForSearchToFinish();
    }

    @Then("^User should see playstation \"([^\"]*)\" game items$")
    public void user_should_see_playstation_game_items(String criteria) throws Throwable {
        liverpoolPageActions.verifyPlayStationTitlesOnListing(criteria, 3);
    }

    @Then("^User should see playstation console item as \"([^\"]*)\"$")
    public void user_should_see_playstation_console_item(String criteria) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        liverpoolPageActions.verifyPlayStationTitlesOnListing(criteria, 1);
        currentItemTitle = liverpoolPageActions.getItemTitle(criteria);
        currentItemPrice = liverpoolPageActions.getItemPrice(criteria);
    }

    @When("^User clicks on \"([^\"]*)\" item$")
    public void user_clicks_on_playstation_console(String item) throws Throwable {
        liverpoolPageActions.selectItem(item);
    }

    @Then("^User should be able to see title and price$")
    public void user_should_be_able_to_see_title_and_price() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(currentItemTitle,liverpoolItemPageActions.locators.itemTitle.getText().replace("\n",""));
        Assert.assertEquals(currentItemPrice,liverpoolItemPageActions.locators.itemPrice.getText().replace("\n",""));
    }

    @Then("^User should see size and price filters$")
    public void user_should_see_size_and_price_filters() throws Throwable {
        Assert.assertTrue(liverpoolPageActions.locators.priceFilter.isDisplayed());
        Assert.assertTrue(liverpoolPageActions.locators.sizeFilter.isDisplayed());
    }

    @Then("^User filter by 55 inches as \"([^\"]*)\", price as \"([^\"]*)\" and \"([^\"]*)\" brand$")
    public void user_filter_by_inches_price_greater_than_and_brand(String size, String price, String brand) throws Throwable {
        liverpoolPageActions.locators.viewMoreSizeButton.click();
        liverpoolPageActions.locators.viewMoreBrandButton.click();
        String currentUrl = SeleniumDriver.getDriver().getCurrentUrl();
        GenericUtils.getWebElementByXpathAndValue(liverpoolPageActions.locators.dynamicFilterCheck, size).click();
        currentUrl = SeleniumHelper.waitForPageToLoad(currentUrl);
        GenericUtils.getWebElementByXpathAndValue(liverpoolPageActions.locators.dynamicFilterRadio, price).click();
        currentUrl = SeleniumHelper.waitForPageToLoad(currentUrl);
        GenericUtils.getWebElementByXpathAndValue(liverpoolPageActions.locators.dynamicFilterCheck, brand).click();
    }

    @Then("^User is able to see results count$")
    public void user_is_able_to_see_results_count() throws Throwable {
        Assert.assertTrue(liverpoolPageActions.locators.itemsCount.getText().contains(String.valueOf(liverpoolPageActions.locators.listingTitles.size())));
    }

    @And("^User click for \"([^\"]*)\" category and click on \"([^\"]*)\" sub category$")
    public void userClickForCategoryAndClickOnSubCategory(String category, String subCategory) throws Throwable {
        liverpoolPageActions.clickOnCategoryAndSubCategory(category, subCategory);
    }
}
