package Pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_AddGroupAppointment extends BasePage{

	Utility utility = new Utility();
	
	String day = "//android.widget.CheckedTextView[@text='";
	String day1 = "']";
	
	String date = "//android.view.View[@text='";
	String date1 = "']";
	
	By Ok = By.xpath("//android.widget.Button[@text='OK']");
	
	By time = By.xpath("//android.widget.Button[@text='23']");
	
	By groupName=  By.id("com.veemed.veedoc:id/etGroupName");
	
	By appointTime=  By.id("com.veemed.veedoc:id/tvAppointmentTime");
	
	By timeZone = By.id("com.veemed.veedoc:id/tv_item");
	
	By appointDays=  By.id("com.veemed.veedoc:id/spAppointmentDays");
	
	By startDate = By.id("com.veemed.veedoc:id/tvStartDate");
	
	By endDate = By.id("com.veemed.veedoc:id/tvEndDate");
	
	By addPatient = By.id("com.veemed.veedoc:id/btnAddPatient");
	
	By done = By.id("com.veemed.veedoc:id/btnDone");
	
	By getpatient = By.id("com.veemed.veedoc:id/tvPatientName");
	
	By back = By.id("com.veemed.veedoc:id/btnBack");
	
	By patientRow = By.id("com.veemed.veedoc:id/tvPatientName");
	
	public PageVeeDoc_AddGroupAppointment(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public String verifypatient() throws Exception{
		
		//utility.Wait();
		//MobileElement result = driver.findElement(By.xpath(userName));
		return utility.getTextFunc(getpatient);
	}
	
	public void addGroupInfo(String gname) throws Exception {
		
		utility.setText(groupName, gname);
	
		Date dates=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dates);
        String dayWeekText = new SimpleDateFormat("EEEE").format(dates);
        int dayofMonth = c.get(Calendar.DAY_OF_MONTH);
      
        utility.clickElement(appointDays);
        String dayName = day + dayWeekText +day1;
        By todaysDay = By.xpath(dayName);
        utility.clickElement(todaysDay);
        utility.clickElement(Ok);
	
      //  utility.Wait();
        utility.clickElement(startDate);
        String currentdate = date + dayofMonth +date1;
        By todaysDate = By.xpath(currentdate);
        utility.clickElement(todaysDate);
        utility.clickElement(Ok);
        
       // utility.Wait();
        utility.clickElement(endDate);
        utility.clickElement(todaysDate);
        utility.clickElement(Ok);
        
        
       // utility.Wait();
        utility.clickElement(appointTime);
        utility.clickElement(time);
       
        utility.clickElement(done);
        
        //utility.Wait();
        utility.clickElement(addPatient);
        
	}
	
	public void saveGroupInfo() throws Exception {
		utility.clickElement(done);
	}
	
	public void back() throws Exception {
		utility.clickElement(back);
	}
	
	public void patientRow(String fName) throws Exception {
		if (utility.getTextFunc(patientRow) != fName) {
			utility.scrollToText(fName);
		}
	}
}
