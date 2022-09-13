package Pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_Settings  extends BasePage{

	Utility utility = new Utility();
	
	By biometric=  By.id("com.veemed.veedoc:id/switchBiometric");
	
	By profile = By.id("com.veemed.veedoc:id/layoutProfile");
	
	By changePass = By.id("com.veemed.veedoc:id/layoutChangePassword");
	
	public PageVeeDoc_Settings(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		//this.driver= driver;
	}
	
	public void clickOnProfile() throws Exception {
		
		//utility.Wait();
		utility.clickElement(profile);
		
		
	
	}
	
public void ChangePassword() throws Exception {
		
		//utility.Wait();
		utility.clickElement(changePass);
		
		
	
	}


}

