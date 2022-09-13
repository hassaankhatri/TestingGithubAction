package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_SearchAppointment extends BasePage{
	
	Utility utility = new Utility();
	By openFilter = By.id("com.veemed.veedoc:id/btnRight");
	By startDate = By.id("com.veemed.veedoc:id/etStartDate");
	By endDate = By.id("com.veemed.veedoc:id/etEndDate");
	By patientFirstName = By.id("com.veemed.veedoc:id/etPatientFirstName");
	By patientLastName = By.id("com.veemed.veedoc:id/etPatientLastName");
	By buttonSearch = By.id("com.veemed.veedoc:id/btnSearchAppointment");
	By calenderOk = By.xpath("//android.widget.Button[@text='OK']");
	//after serach patient name locator
	By patientName = By.id("com.veemed.veedoc:id/tvPatientName");
	By apppointmentDate = By.id("com.veemed.veedoc:id/tvDate");
	
	

	public PageVeeDoc_SearchAppointment(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver= driver;
	}
	
	public void searchAppointment(String fname) throws Exception{
		utility.clickElement(openFilter);
		utility.clickElement(startDate);
		utility.clickElement(calenderOk);
		utility.clickElement(endDate);
		utility.clickElement(calenderOk);
		utility.setText(patientFirstName, fname);
		utility.clickElement(buttonSearch);
		utility.clickElement(openFilter);
	}
	
	public String getPatientName() throws Exception{
		
		utility.Wait();
		return utility.getTextFunc(patientName);
	}
}
