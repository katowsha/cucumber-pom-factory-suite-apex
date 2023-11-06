package Suite.Models.Locators.Liverpool;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LiverpoolBaseLocators {

    @FindBy(how= How.XPATH, using = "//*[contains(@class,'selected-item login-button only-one-link') and contains(text(), 'Banca por Internet')]")
    public WebElement bankLogon;

    @FindBy(how= How.XPATH, using = "//*[@data-dojo-attach-point='_interstitialNode']")
    public WebElement bank_wait_blur;

    @FindBy(how= How.XPATH, using = "//*[@id='username']")
    public WebElement username;
}
