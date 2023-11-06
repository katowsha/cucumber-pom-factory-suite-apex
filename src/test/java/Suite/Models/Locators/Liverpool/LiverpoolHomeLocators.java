package Suite.Models.Locators.Liverpool;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LiverpoolHomeLocators {

    @FindBy(how= How.XPATH, using = "//*[contains(@class,'m-boutiques-links')]")
    public WebElement boutiquesNavBar;

    @FindBy(how= How.XPATH, using = "//*[contains(@class,'menu-action') and (not (contains(@class,'mobile')))]/..")
    public WebElement category_link;

    @FindBy(how= How.ID, using = "mainSearchbar")
    public WebElement searchBar;

    @FindBy(how= How.XPATH, using = "//*[@class='card-title a-card-description']")
    public List<WebElement> listingTitles;

    @FindBy(how= How.XPATH, using = "//*[@class='a-plp-results-title']")
    public WebElement itemsCount;

    public String dynamicItem = "//article//h5[contains(text(),'%s')]";
    public String dynamicItemPrice = "//article//h5[contains(text(),'%s')]/../..//*[contains(@class,'discount')]";
    public String dynamicFilterCheck = "//label[contains(text(),'%s')]/ancestor::div[contains(@class,'m-checkbox')]//input";
    public String dynamicFilterRadio = "//label[contains(text(),'%s')]/ancestor::div[contains(@class,'m-radioButton')]//input";
    public String filterDynamicPill = "//div[@class='mdc-chip__text' and contains(text(),'%s')]";

    @FindBy(how= How.XPATH, using = "//label[contains(text(),'Tamaño')]/ancestor::div[contains(@class,'m-plp__filterSection')]")
    public WebElement sizeFilter;

    @FindBy(how= How.XPATH, using = "//label[contains(text(),'Precios')]/ancestor::div[contains(@class,'m-plp__filterSection')]")
    public WebElement priceFilter;

    @FindBy(how= How.ID, using = "Tamao")
    public WebElement viewMoreSizeButton;

    @FindBy(how= How.ID, using = "Marcas")
    public WebElement viewMoreBrandButton;

    public String dynamicSubCategory = "//*[contains(@class, 'a-desktop__subcategoryTitle') and contains(text(),'%s')]";
    public String dynamicCategory = "//*[contains(@class, 'a-dekstop__categoryLink')]//*[contains(text(),'%s')]";
}
