package Reuse;
import MainPrgm.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ssonfail implements ITestListener
{
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().toString().trim();
        takeScreenShot(methodName);
    }

    public static String takeScreenShot(String methodName)
    {


        String destDir = "";
        File scrFile = ((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("hh_mm_ssaa");
        DateFormat date = new SimpleDateFormat("dd-MMM-yyyy__hh_mm");
        //If status = fail then set folder name "screenshots/Failures"
        destDir = "//home//screenshots//Failures/"+date.format(new Date());


        //If status = pass then set folder name "screenshots/Success"

        //To create folder to store screenshots
        new File(destDir).mkdirs();
        //Set file name with combination of test class name + date time.
        String destFile = methodName+dateFormat.format(new Date())+ ".png";

        try {
            //Store file at destination folder location
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
          
        catch (IOException e) {
            e.printStackTrace();
        }
        	return destDir;
    }
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }






}
