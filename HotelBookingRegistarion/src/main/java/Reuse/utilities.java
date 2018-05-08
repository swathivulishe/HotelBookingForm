package Reuse;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class utilities {
	public static WebDriver driver;
   
    public static void explicitWait(By locator,String text, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    
    public static void explicitWaitForElementNotPresent(By locator,String text, WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }
    

    public static void impliciteWait(long time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	

    public static int random(int num)
    {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(num);
        return randomInt;
    }



    public static void SelectBox(WebElement element,String option)
    {
        Select dropClass1 = new Select(element);
        dropClass1.selectByVisibleText(option);

    }

    public static void SelectBox_value(WebElement element,String option)
    {
        Select dropClass1 = new Select(element);
        dropClass1.selectByValue(option);

    }

	public static  String random(String[] price) 
	{
	 
		   Random randomGenerator = new Random();
	       int randomInt = randomGenerator.nextInt(price.length);
	       return price[randomInt];

		
	}

		
}


