package Pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_DayOff extends BasePage{

	Utility utility = new Utility();
	String off = "//android.widget.CheckedTextView[@text='";
	String off1 = "']";
	
	Date dates=new Date();
    Calendar c = Calendar.getInstance();
   // c.setTime(datess);
    String dayWeekText = new SimpleDateFormat("EEEE").format(dates);
    int dayofMonth = c.get(Calendar.DAY_OF_MONTH);
    
    String selectDate = off + dayofMonth + off1;
    
	By done_btn = By.id("com.veemed.veedoc:id/doneButton_markOffDays");
	
	By markOff=  By.xpath(selectDate);
	
	By back=  By.className("android.widget.ImageButton");
	
	
	
	
	
	public PageVeeDoc_DayOff(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public void markDayOff() throws Exception {
	
		utility.clickElement(markOff);
		
		utility.clickElement(done_btn);
	
		utility.clickElement(back);
		
       
	}
	
	public void unmarkDayOff() throws Exception {
		
		utility.clickElement(markOff);
		
		utility.clickElement(done_btn);
	
		utility.clickElement(back);
		
       
	}

}
