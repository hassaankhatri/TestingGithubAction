package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class PageVeeDoc_GroupSessions extends BasePage{

	Utility utility = new Utility();
	
	By newGroup = By.id("com.veemed.veedoc:id/btnCreateGroupAppointment");
	
	By todaysAppointment_tab = By.id("com.veemed.veedoc:id/btnTodaysAppt");
	
	By group_tab = By.id("com.veemed.veedoc:id/btnGroups");
	
	By history_tab = By.id("com.veemed.veedoc:id/btnGroupsHistory");
	
	By gName = By.id("com.veemed.veedoc:id/tvGroupName");
	
	By toDate = By.id("com.veemed.veedoc:id/tvTo");
	
	By swipe = By.id("com.veemed.veedoc:id/lblApptDays");
	
	By groupList = By.id("com.veemed.veedoc:id/rvGroupAppointmentList");
	
	By yes = By.id("com.veemed.veedoc:id/btnPositive");
	
	By noAppointment = By.id("com.veemed.veedoc:id/tvNoGroupAppointmentFound");
	
	
	public PageVeeDoc_GroupSessions(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		//this.driver= driver;
	}
	
	public void navigateTo(String tabname) throws Exception {
		
		//utility.Wait();
		if(tabname == "Group") {
			
			utility.clickElement(group_tab);
		
		}
		if(tabname == "TodaysApp") {
			
			utility.clickElement(todaysAppointment_tab);
		
		}
		if(tabname == "History") {
	
			utility.clickElement(history_tab);

		}
	
	}

	public void createNewGroup() throws Exception {
		
		utility.clickElement(newGroup);
	
	}
	
	public String getName() throws Exception{

		return utility.getTextFunc(gName);
	}
	
	public String createdDate() throws Exception{
		
		return utility.getTextFunc(toDate);
	}
	
	public void openCreatedGroup() throws Exception{
		
		utility.clickElement(gName);
	}
	
	public String getTextNoAppoint() throws Exception{

		return utility.getTextFunc(noAppointment);
	}
	
	public void deleteGroupAppointment() throws Exception{
		utility.swipeLeftGroup(swipe);
		Dimension windowSize = driver.manage().window().getSize();
		double x, y;
		x = 0.91 * windowSize.width;
		y = 0.34 * windowSize.height;
		
		MobileElement element = driver.findElement(groupList);
        TouchAction action = new TouchAction(driver);
		action.tap(ElementOption.element(element).point((int)x, (int)y)).perform();
		
		utility.clickElement(yes);
		utility.clickTextView(getTextNoAppoint());
	}


}
