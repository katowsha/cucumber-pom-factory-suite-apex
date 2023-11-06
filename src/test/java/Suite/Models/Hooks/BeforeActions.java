package Suite.Models.Hooks;

import cucumber.api.Scenario;
import Commons.Utils.GenericUtils;
import Framework.Selenium.SeleniumDriver;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeforeActions {
    private static Logger log = LogManager.getLogger(BeforeActions.class.getName());

    @Before
    public static void setUp(Scenario scenario) {
        if(!scenario.getSourceTagNames().contains("@API")){
            SeleniumDriver.setUpDriver();
        }
        GenericUtils.InitializeProperties();
        GenericUtils.InitializeJsonData();

    }
}
