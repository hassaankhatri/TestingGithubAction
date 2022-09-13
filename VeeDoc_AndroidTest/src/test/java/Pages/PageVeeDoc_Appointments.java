package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_Appointments extends BasePage{

	Utility utility = new Utility();
	
	By patientName = By.xpath("//parent::android.view.ViewGroup//android.widget.TextView[@resource-id='com.veemed.veedoc:id/tvPatientName']");
	
	String scrollToPatientName1= "//android.widget.TextView[@text='";
	String scrollToPatientName2 = "']";
	
//	By scrollToPatientName = By.xpath("//android.widget.TextView[@text='Hassaan40FQKX Khatri']");
	
	By appoint_btn = By.id("com.veemed.veedoc:id/btnCreateAppointment");
	
	By createdDate=  By.id("com.veemed.veedoc:id/tvDate");
	
	
	//Constructor for Page class of Veedoc Dashboard
	public PageVeeDoc_Appointments(AppiumDriver<MobileElement> driver) {
			super(driver);
			
		}
		
	public String verifyDate() throws Exception{
		
		return utility.getTextFunc(createdDate);
	}
	
	public void scrollToPatientName(String pName) throws Exception {
		if (utility.getTextFunc(patientName) != pName) {
			utility.scrollToText(pName);
		}
	}
	
	public String verifyPname(String pName) throws Exception{
		String patient = scrollToPatientName1+pName+scrollToPatientName2;
		return utility.getTextFunc(By.xpath(patient));
	}
}
