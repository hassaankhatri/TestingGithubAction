package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_ChangePassword  extends BasePage{

	Utility utility = new Utility();
	
	By signout_opt = By.id("com.veemed.veedoc:id/btnNegative");
	
	By currentPassword=  By.id("com.veemed.veedoc:id/currentPasswordEditText");
	
	By newPassword = By.id("com.veemed.veedoc:id/newPasswordEditText");
	
	By confirmPassword = By.id("com.veemed.veedoc:id/confirmPasswordEditText");
	
	By changePassword_btn = By.id("com.veemed.veedoc:id/button");
	
	public PageVeeDoc_ChangePassword(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		//this.driver= driver;
	}
	
	public void changeToNewPassword(String currentPass, String newPass, String confirmPass) throws Exception {
		
		//utility.Wait();
		utility.setText(currentPassword, currentPass);
		utility.setText(newPassword, newPass);
		utility.setText(confirmPassword, confirmPass);
		
		utility.clickElement(changePassword_btn);
		//utility.Wait();
		//MobileElement signoutOpt = driver.findElement(By.id(signout_opt));
		utility.clickElement(signout_opt);
	
	}
	
	public void changeToOldPassword(String currentPass, String newPass, String confirmPass) throws Exception {
		
		
		//utility.Wait();
		utility.setText(currentPassword, currentPass);
		utility.setText(newPassword, newPass);
		utility.setText(confirmPassword, confirmPass);
		
		utility.clickElement(changePassword_btn);
		//utility.Wait();
		//MobileElement signoutOpt = driver.findElement(By.id(signout_opt));
		utility.clickElement(signout_opt);
	
	}


}

