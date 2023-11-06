package Commons.Utils;

import Framework.Selenium.SeleniumDriver;
import com.cucumber.listener.ExtentCucumberFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class GenericUtils {
    private static Logger log = LogManager.getLogger(GenericUtils.class.getName());



    public static Properties properties;
    public static Map<String,Object> data;


    public static String getCurrentDir(){
        return System.getProperty("user.dir");
    }

    public static void runSetUp(String reportName){
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("-hh-mm");

        Date curDate = new Date();
        String strDate = sdfDate.format(curDate);
        String strTime = sdfTime.format(curDate);

        String fileName = System.getProperty("user.dir").concat("\\target\\Extent_Reports\\").concat(strDate).
                concat("\\"+ reportName).concat(strTime).concat(".html");

        File newFile = new File(fileName);

        ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile);
        ExtentCucumberFormatter.loadConfig(new File(System.getProperty("user.dir").concat("\\src\\test\\resources\\extent-config.xml")));
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");

        Map<String, String> systemInfo = new HashMap<>();
        systemInfo.put("Cucumber v","123");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }

    public static void InitializeProperties() {
        properties = new Properties();
        try {
            properties.load(new FileReader("application.properties"));
        } catch (IOException e) {
            log.error(e.getMessage(),e.getCause());
        }
    }

    public static String GetProperty(String prop){
        return properties.getProperty(prop);
    }
    public static void InitializeJsonData(){
        JSONParser jp = new JSONParser();

        try {
            FileReader reader = new FileReader("data.json");
            Object obj = jp.parse(reader);

             data = (Map) obj;

        } catch (FileNotFoundException e){
            log.error(e.getMessage(),e.getCause());
        } catch (IOException e){
            log.error(e.getMessage(),e.getCause());
        } catch (ParseException e){
            log.error(e.getMessage(),e.getCause());
        }
    }

    public static void PrintElements(List<WebElement> elements){
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
        }
    }

    public static boolean listOfTextContainsAtLeast(List<WebElement> listingTitles, String criteria, int minCriteria) {
        return listingTitles.stream().filter(webElement -> webElement.getText().contains(criteria) || webElement.getText().contains(criteria.toUpperCase())).count() >= minCriteria;
    }

    public static WebElement getWebElementByXpathAndValue(String xpath, String value){
        return SeleniumDriver.getDriver().findElement(By.xpath(String.format(xpath,value)));
    }
}
