package Locators;

import org.openqa.selenium.By;

	public class RegisterForm 	{
	
	    public static By firstname =By.id("firstname");
	    public static By surname =By.id("lastname");
	    public static By totalprice =By.id("totalprice");
	    public static By deposit =By.id("depositpaid");
	    public static By save =By.xpath("//*[@type='button'][contains(@value,'Save')]");
	    public static By checkin =By.id("checkin");
	    public static By checkout =By.id("checkout");
	    public static By bookingcreated= By.xpath("//*[@id='bookings']/div/div[1]");
	    public static By bookingname = By.xpath("//*[@id='bookings']");
	    public static String[] price = {"200","-100","999","9999","10000" }; 


	}

