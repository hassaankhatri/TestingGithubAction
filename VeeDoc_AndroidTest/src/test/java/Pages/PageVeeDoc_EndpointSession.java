package Pages;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import java.text.SimpleDateFormat;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageVeeDoc_EndpointSession extends BasePage{

	Utility utility = new Utility();
	
	AndroidDriver<MobileElement> driver1;
	By inviteGuest = By.id("//android.widget.TextView[@text='Invite Guest']");
	By inviteCareProvider = By.id("//android.widget.TextView[@text='Invite Care Provider']");
	By endSession = By.id("com.veemed.veedoc:id/btnPositive");
	
	By facilityName=  By.id("com.veemed.veedoc:id/tvFacilityName");
	
	By epName=  By.id("com.veemed.veedoc:id/tvDeviceEndpoint");
	
	By resetbtn = By.id("com.veemed.veedoc:id/btnResetCamera");
	
	By videobtn = By.id("com.veemed.veedoc:id/btnSwitchVideo");
	
	By micbtn = By.id("com.veemed.veedoc:id/btnMic");
	
	By endCall = By.id("com.veemed.veedoc:id/btnEndCall");
	
	By moreOption = By.id("com.veemed.veedoc:id/btnMoreOptions");
	
	Date dates=new Date();
	Calendar date = Calendar.getInstance();
	long timeInSecs = date.getTimeInMillis();
	Date afterAdding1Mins = new Date(timeInSecs + (1 * 60 * 1000));
	public String currentDate, currentDatePlusOne;


	//Constructor for Page class of Veedoc Dashboard
	public PageVeeDoc_EndpointSession(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public String getFacilityName() throws Exception{
		
		utility.Wait();
		//MobileElement result = driver.findElement(By.id(facilityName));
		return utility.getTextFunc(facilityName);
	}
	
	public String getEndpointName() throws Exception{
		currentDatePlusOne = new SimpleDateFormat("MMM dd, YYYY hh:mm aaa").format(afterAdding1Mins);
		currentDate = new SimpleDateFormat("MMM dd, YYYY hh:mm aaa").format(dates);
		return utility.getTextFunc(epName);
		
	}

	public void endSession() throws Exception {
		
		Thread.sleep(20000);
		utility.clickElement(endCall);
		//MobileElement endcall_yes = driver.findElement(By.id(endSession));
		utility.clickElement(endSession);

}

}


