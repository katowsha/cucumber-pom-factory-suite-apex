package Suite.Models.Hooks;

import Framework.Selenium.SeleniumDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AfterActions {
    private static Logger log = LogManager.getLogger(AfterActions.class.getName());

    @After
    public static void tearDown(Scenario scenario) {
        if (!scenario.getSourceTagNames().contains("@API")) {
            log.info("Tearing down...");
            WebDriver driver = SeleniumDriver.getDriver();
            if (scenario.isFailed()) {
                byte[] screenShotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShotBytes, "image/png");
            }
            SeleniumDriver.tearDown();
        }
    }
}
