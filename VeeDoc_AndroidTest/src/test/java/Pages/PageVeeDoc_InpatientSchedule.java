package Pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_InpatientSchedule extends BasePage{

	Utility utility = new Utility();
	
	By dayOffDate = By.xpath("//android.widget.CheckedTextView[@checked='true']");
	
	By dayOffStatus = By.xpath("//android.widget.RelativeLayout[@resource-id='com.veemed.veedoc:id/scheduleItemLayout_offDay']//child::android.widget.TextView[@resource-id='com.veemed.veedoc:id/eventDescriptionTextView_mySchedule']");
	
	By markOff=  By.xpath("//android.widget.CheckedTextView[@text='28']");
	
	By back=  By.className("android.widget.ImageButton");
	
	Date dates=new Date();
    Calendar c = Calendar.getInstance();
   // c.setTime(datess);
    String dayWeekText = new SimpleDateFormat("EEEE").format(dates);
    int dayofMonth = c.get(Calendar.DAY_OF_MONTH);
    
	String currentDate = "//android.widget.CheckedTextView[@text=";
	String currentDate1 = " and @checked=\"true\" ]";
	
	String selectCurrentDateInCalender = currentDate + dayofMonth + currentDate1;
	
	By selectCurrentDate=  By.xpath(selectCurrentDateInCalender);
	
	public PageVeeDoc_InpatientSchedule(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public String getDate() throws Exception{
		
		
		return utility.getTextFunc(dayOffDate);
	}
	
	public String getDayoffStatus() throws Exception{
		

		return utility.getTextFunc(dayOffStatus);
	}
	
	public void goBack() throws Exception {
		
		utility.clickElement(back);   
	}
	
	public void selectCurrentDate() throws Exception {
		
		utility.clickElement(selectCurrentDate);   
	}

}
