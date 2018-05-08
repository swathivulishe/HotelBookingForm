package TestScripts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Locators.RegisterForm;
import MainPrgm.Base;
import Reuse.utilities;

public class Booking extends Base {
	
	
        String url="http://hotel-test.equalexperts.io/";

        @Test(priority =0)
		public void saveHotelReservationForm() throws IOException, InterruptedException {
        	Base.test=report.startTest("Booking");
			Base.driver.get(url);	
			Base.driver.manage().window().maximize();	
			Base.driver.findElement(RegisterForm.firstname).sendKeys("Tester One");
			Base.driver.findElement(RegisterForm.surname).sendKeys("QA");
		    Base.driver.findElement(RegisterForm.totalprice).sendKeys(Reuse.utilities.random(RegisterForm.price));
			Base.driver.findElement(RegisterForm.deposit).click();;
     		utilities.SelectBox(Base.driver.findElement(RegisterForm.deposit), "false");
		    Date curDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    String DateToStr = format.format(curDate);
		    Base.driver.findElement(RegisterForm.checkin).sendKeys(DateToStr);
		    Calendar c = Calendar.getInstance();
		    c.add(Calendar.DAY_OF_MONTH, +1);
		    String formatted = format.format(c.getTime());
		    Base.driver.findElement(RegisterForm.checkout).sendKeys(formatted);
		    Base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Base.driver.findElement(RegisterForm.save).click();
		    Reuse.utilities.explicitWait(RegisterForm.bookingname, "Tester One", driver);
		    Assert.assertTrue(Base.driver.findElement(RegisterForm.bookingname).getText().contains("Tester One"));
       }
	


@Test(priority =1)
public void DeleteHotelReservationForm() throws IOException, InterruptedException {
	List <WebElement> Firstname = Base.driver.findElements(RegisterForm.bookingcreated);
	for(int i=3;i<=Firstname.size();i++)
	{		
		 	if(Base.driver.findElement(By.xpath("//*[@id='bookings']/div["+i+"]/div[1]")).getText().contains("Tester One")) {
			Base.driver.findElement(By.xpath("//*[@id='bookings']/div["+i+"]/div[7]/input")).click();
		    Reuse.utilities.explicitWaitForElementNotPresent(RegisterForm.bookingname, "Tester One",driver);
    }

}
	Assert.assertFalse(Base.driver.findElement(RegisterForm.bookingname).getText().contains("Tester One"));
  }
}

