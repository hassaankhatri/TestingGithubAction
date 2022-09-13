package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_AddPatientGroup extends BasePage{

	Utility utility = new Utility();
	By searchCountry = By.id("com.veemed.veedoc:id/editText_search");
	By countryName = By.id("com.veemed.veedoc:id/textView_countryName");
	
	By firstName=  By.id("com.veemed.veedoc:id/etPatientFirstName");
	
	By lastName=  By.id("com.veemed.veedoc:id/etPatientLastName");
	
	By email = By.id("com.veemed.veedoc:id/etPatientEmail");
	
	By selectCountry=  By.id("com.veemed.veedoc:id/rlClickConsumer");
	
	By phoneNumber = By.id("com.veemed.veedoc:id/etPatientMobile");
	
	By done = By.id("com.veemed.veedoc:id/btnDone");
	
	
	
	public PageVeeDoc_AddPatientGroup(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public void addPatient(String fname, String lname, String emails, String number) throws Exception {
	
		utility.clickElement(selectCountry);
		utility.setText(searchCountry, "Pakistan");
		utility.clickElement(countryName);
		utility.setText(phoneNumber, number);
		utility.setText(firstName, fname);
		utility.setText(lastName, lname);
		utility.setText(email, emails);
	
		utility.clickElement(done);
		
       
	}

}
