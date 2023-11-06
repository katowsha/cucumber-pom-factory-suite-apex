package Suite.Models.Locators.Liverpool;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LiverpoolItemLocators {

    @FindBy(how= How.XPATH, using = "//h1[contains(@class,'a-product__information--title')]")
    public WebElement itemTitle;

    @FindBy(how= How.XPATH, using = "//fieldset[@class='rating']")
    public WebElement ratingElement;

    @FindBy(how= How.XPATH, using = "//p[contains(@class,'DiscountPrice')]")
    public WebElement itemPrice;
}
