package MainPrgm;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Reuse.Ssonfail;

public class Base {
        public static WebDriver driver;
        protected static ExtentReports report;
        protected static ExtentTest test;
        
         String browser = "chrome";
        @Parameters("browser")
        @BeforeTest
        public void openbrowser(String browser) {
            if (browser.equalsIgnoreCase("firefox")) {

                System.setProperty("webdriver.gecko.driver", "D:/lthpoc-Automation/src/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("ie")) {

                System.setProperty("webdriver.ie.driver", "D:/lthpoc-Automation/src/Drivers/gIEDriverServer.exe");

                driver = new InternetExplorerDriver();

            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "D:/lthpoc-Automation/src/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
         
            report=new ExtentReports("C:\\Report\\Screenshots.html");


        }



    @AfterMethod
    
    public void tearDown(ITestResult result) throws IOException 
    {
    if(result.getStatus()==ITestResult.FAILURE)
    {
    	String scrFile=Ssonfail.takeScreenShot("screenshotForExtentReport");
    	test.log(LogStatus.FAIL, result.getThrowable());
        test.log(LogStatus.FAIL, "Title verification:" +test.addScreenCapture(scrFile)); 
     
    }
      report.endTest(test);
    }
    @AfterTest
    
        public void closebrowser() {
            driver.close();
            report.flush();
            report.close();
     }
 }


