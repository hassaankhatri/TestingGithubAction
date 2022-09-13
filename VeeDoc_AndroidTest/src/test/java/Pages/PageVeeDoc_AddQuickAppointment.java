package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_AddQuickAppointment extends BasePage{

	Utility utility = new Utility();
	By lastName = By.id("com.veemed.veedoc:id/etPatientLastName");
	
	By firstName = By.id("com.veemed.veedoc:id/etFirstName");
	
	By email = By.id("com.veemed.veedoc:id/etEmail");
	
	By selectCountry=  By.id("com.veemed.veedoc:id/rlClickConsumer");
	
	By searchCountry = By.id("com.veemed.veedoc:id/editText_search");
	
	By countryName = By.id("com.veemed.veedoc:id/textView_countryName");
	
	By phoneNumber = By.id("com.veemed.veedoc:id/etMobileNo");
	
	By reason = By.id("com.veemed.veedoc:id/etReason");
	
	By create = By.id("com.veemed.veedoc:id/btnCreateAppointment");
	
	
	
	public PageVeeDoc_AddQuickAppointment(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public void createQuickAppointment(String fname, String lname, String emails, String number, String reasons) throws Exception {
	
		utility.clickElement(selectCountry);
		utility.setText(searchCountry, "Pakistan");
		utility.clickElement(countryName);
		utility.setText(phoneNumber, number);
		utility.setText(firstName, fname);
		utility.setText(lastName, lname);
		utility.setText(email, emails);
		utility.setText(reason, reasons);
	
		utility.clickElement(create);
		
       
	}

}
