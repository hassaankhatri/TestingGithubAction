package Pages;

import org.openqa.selenium.By;
//import Tests.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_OutpatientSchedule extends BasePage{

	Utility utility = new Utility();
	
	String day = "//android.widget.TextView[@text ='";
	String dayRemaining = "']//parent::*//following-sibling::android.widget.TextView[@text ='+']";
	//By sunday = By.xpath("//android.widget.TextView[@text ='Wednesday']//parent::*//following-sibling::android.widget.TextView[@text ='+']");
	
	By addSlot = By.id("com.veemed.veedoc:id/btnAddSlot");
	
	By startTime=  By.id("com.veemed.veedoc:id/tvStartTime");
	
	By endTime=  By.id("com.veemed.veedoc:id/tvEndTime");
	
	By add=  By.id("com.veemed.veedoc:id/btnPositive");
	
	By done=  By.id("com.veemed.veedoc:id/btnDone");
	
	By timeSlotHour = By.xpath("//android.widget.Button[@text='23']");
	
	By timeSlotMinutes = By.xpath("//android.widget.Button[@text='59']");
	
	By startAddedTime = By.id("com.veemed.veedoc:id/tvStartTime");
	
	By endAddedTime = By.id("com.veemed.veedoc:id/tvEndTime");
	
	By saveSchedule = By.xpath("//android.widget.TextView[@text='Done']");
	
	String more = "//android.widget.TextView[@text ='";
	String more2 = "']//parent::*//following-sibling::android.widget.TextView[@text ='More']";
	
	By swipeToDelete = By.xpath("//android.widget.TextView[@resource-id='com.veemed.veedoc:id/tvStartTime']//parent::*");
	
	By back =  By.id("com.veemed.veedoc:id/btnBack");
	
	By signOut = By.id("com.veemed.veedoc:id/signOut_icon");
	
	By yesSignOut = By.id("com.veemed.veedoc:id/btnPositive");
	
	public PageVeeDoc_OutpatientSchedule(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public String getStartTime() throws Exception{
		
		
		return utility.getTextFunc(startAddedTime);
	}
	
	public String getEndTime() throws Exception{
		
		return utility.getTextFunc(endAddedTime);
	}
	
	
	
	public void selectTodaysDay(String dayName) throws Exception {
		
		String todaysDay = day + dayName +dayRemaining;
		By today = By.xpath(todaysDay);
		utility.clickElement(today);
		
	}
	
	public void addTimeSlots() throws Exception {
		utility.clickElement(addSlot);
		utility.clickElement(startTime);
		utility.clickElement(done);
		
		utility.clickElement(endTime);
		utility.clickElement(timeSlotHour);
		utility.clickElement(timeSlotMinutes);
		utility.clickElement(done);
		
		utility.clickElement(add);
		utility.clickElement(saveSchedule);
	}
	
	public void selectTodaysDayMore(String dayName) throws Exception {
		
		String todaysDay = more + dayName +more2;
		By today = By.xpath(todaysDay);
		utility.clickElement(today);
	}
	
	public void deleteTimeSlots() throws Exception {
		utility.swipeLeft(swipeToDelete);
		utility.clickElement(done);	
	}
	
	public void logOut() throws Exception {
		utility.clickElement(back);
		utility.clickElement(signOut);	
		utility.clickElement(yesSignOut);	
	}

}