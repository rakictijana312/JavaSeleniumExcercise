//package Utils;
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class CommonMethods extends BaseClass {
//	private static final String ConfigReader = null;
//	public static WebDriver driver;
//    public static void setUp(){
//        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
//        switch (ConfigReader.getPropertyValue("browser")){
//            case "chrome":
//                //System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
//                WebDriverManager.chromedriver().setup();
//                if(ConfigReader.getPropertyValue("headless").equals("true")){
//                    ChromeOptions chromeOptions=new ChromeOptions();
//                    chromeOptions.setHeadless(true);
//                    driver = new ChromeDriver(chromeOptions);
//                }else {
//                    driver = new ChromeDriver();
//                }
//
//
//                break;
//            case "firefox":
//              //  System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            default:
//                throw new RuntimeException("Inavlid name of browser");
//        }
//
//        driver.get(ConfigReader.getPropertyValue("url"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
//    }
//
//    public static void sendText(WebElement element, String textToSend){
//        element.clear();
//        element.sendKeys(textToSend);
//    }
//
//    public static WebDriverWait getWait(){
//        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
//        return wait;
//    }
//
//    public static void waitForClickability(WebElement element){
//        getWait().until(ExpectedConditions.elementToBeClickable(element));
//    }
//
//    public static void click(WebElement element){
//        waitForClickability(element);
//        element.click();
//    }
//
//    public static JavascriptExecutor getJSExecutor(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        return js;
//    }
//
//    public static void jsClick(WebElement element){
//       getJSExecutor().executeScript("arguments[0].click()", element);
//    }
//
//
//    public static byte[] takeScreenshot(String fileName) {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//
//        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
//
//        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(sourceFile, new File( Constants.SCREENSHOT_FILEPATH + fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return picBytes;
//    }
//
//    public static String getTimeStamp(String pattern){
//       Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        return sdf.format(date);
//    }
//
//    public static void tearDown(){
//        if(driver!=null){
//            driver.quit();
//        }
//    }
//
//}
