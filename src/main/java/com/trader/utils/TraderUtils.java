package com.trader.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trader.po_manager.PageObjectManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TraderUtils {

    public static WebDriver driver;
    public static PageObjectManager po_manager;

    // return the class name as a string
    public String exceptionClassNameAndMessage(Exception exceptionObj) {

        return " | Default error message --> " + exceptionObj.getMessage()
                + " | Method implementation class --> " + exceptionObj.getStackTrace()[0]
                + " | Method extends class --> " + exceptionObj.getStackTrace()[1];
    }

    // this method is user for browser launch
    // parameter ==> (browser -> name), (url -> application url)
    public static WebDriver launchBrowser(String browser, String url, String headLess) {

        try {

            if (browser.equalsIgnoreCase("Chrome")) {

                driver = new ChromeDriver(options(headLess));

            } else if (browser.equalsIgnoreCase("Edge")) {

                driver = new EdgeDriver();

            } else if (browser.equalsIgnoreCase("Firefox")) {

                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get(url);

            po_manager = new PageObjectManager(driver);

        } catch (Exception exception) {

            System.out.println("problem on launching browser"
                    + " | Default error message --> " + exception.getMessage()
                    + " | Method implementation class --> " + exception.getStackTrace()[0]
                    + " | Method extends class --> " + exception.getStackTrace()[1]);
        }

        return driver;
    }


    static ChromeOptions option;
    static Map<String, Integer> contentSettings = new HashMap<>();
    static Map<String, Object> profile = new HashMap<>();
    static Map<String, Object> prefs = new HashMap<>();

    private static ChromeOptions options(String headLess) {

        option = new ChromeOptions();

        if (headLess.equalsIgnoreCase("HeadLess")) {

            option.addArguments("--headless=new");
        }

        contentSettings.put("media_stream", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        option.setExperimentalOption("prefs", prefs);

        return option;
    }


    static WebDriverWait wait;

    public WebDriverWait waitObj() {

        return wait == null ? new WebDriverWait(driver, Duration.ofSeconds(20)) : wait;
    }

    // send keys to element
    // para: element - WebElement, text - 'value'
    public void sendKeys(WebElement element, String text) {

        try { waitObj().until(elementToBeClickable(element)).sendKeys(text);}
        catch (Exception exception) { exceptionClassNameAndMessage(exception); }
    }

    // click the element
    public void clickElement(WebElement element) {

        try { waitObj().until(elementToBeClickable(element)).click(); }
        catch (Exception exception) { exceptionClassNameAndMessage(exception); }
    }

    public void sleep(long time) {

        try { Thread.sleep(time); } catch (Exception exception) { exceptionClassNameAndMessage(exception); }
    }

    static ObjectMapper mapper = new ObjectMapper();

    // Json file reader and return as Map
    // para: filePath - json file path
    @SuppressWarnings(value = "unchecked")
    public Map<Object, Object> jsonReader(String filePath) {

        Map<Object, Object> json = null;

        try {

            json = mapper.readValue(Paths.get(System.getProperty("user.dir") + filePath).toFile(), Map.class);


        } catch (Exception ex) {

            System.out.println("problem on jsonRead method");
        }

        return json;
    }

    // Json file writer
    //para: Object - Map, filePath - json File path
    public void jsonPayloadWriter(Object object, String filePath) {

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(System.getProperty("user.dir") + filePath), object);
        } catch (Exception ex) {

            System.out.println("problem on jsonPayloadWriter method");
        }
    }

    // over here we have all the file paths in this method, which return as map
    public Map<String, String> filePaths() {

        Map<String, String> files = new HashMap<>();

        files.put("Screenshots", "/screenshots");
        files.put("Login", "/applicationData/Login.json");
        files.put("Register", "/Register.json");

        return files;
    }

    // this method will create new Screenshot folder in our project
    public void createNewFolder() {

        try {

            File newDirectory = new File(System.getProperty("user.dir") + File.separator + filePaths().get("Screenshots"));

            if (!newDirectory.exists()) {

                newDirectory.mkdir();

            }
        } catch (Exception exception) {

            System.out.println(exceptionClassNameAndMessage(exception));
        }

    }

    // this method will delete the Screenshot folder
    public void deleteFolder() {

        try {

            File directory = new File(System.getProperty("user.dir") + File.separator + filePaths().get("Screenshots"));

            if (directory.exists()) {
                directory.delete();
            }
        } catch (Exception exception) {

            System.out.println(exceptionClassNameAndMessage(exception));
        }
    }

    // get the current URL and return as String
    public String getUrl() {

        return driver.getCurrentUrl();
    }

    // this method will close the current web page or current tab
    public void browserClose() {

        try { driver.close();} catch (Exception e) { throw new RuntimeException(e); }
    }

    // this will return string, from any tag which have text
    public String getElementText(WebElement element) {

        return element.getText();
    }

    // this method will take screenshot and stores in screenshot folder
    // para: webdriver - driver, fileWithPath - folder path
    public void takeSnapShot(WebDriver webdriver, String fileWithPath) {

        try {

            TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

            File DestFile = new File(System.getProperty("user.dir") + fileWithPath);

            FileUtils.copyFile(SrcFile, DestFile);

        } catch (Exception exception) {

            System.out.println("Problem on Taking snap shot" + exceptionClassNameAndMessage(exception));

        }
    }

    // return date format in string
    public String date(){

        return new SimpleDateFormat("dd MMMM yyyy").format(new Date());
    }

    //  return date in string format [eg: 29 | 30]
    public String day(){

        return date().substring(0, 2);
    }

    // return month is string format [eg: may | april | march]
    public String month(){

        return date().substring(3, date().length()-5);
    }

}
