package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageVeeDoc_InviteCareProvider extends BasePage{

	Utility utility = new Utility();
	
	AndroidDriver<MobileElement> driver1;
	String userName = "//android.widget.TextView[@index='0']";
	String allowCamera = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
	
	MobileElement facilityName=  driver.findElement(By.id("com.veemed.veedoc:id/tvFacilityName"));
	
	MobileElement epName=  driver.findElement(By.id("com.veemed.veedoc:id/tvDeviceEndpoint"));
	
	MobileElement resetbtn = driver.findElement(By.id("com.veemed.veedoc:id/btnResetCamera"));
	
	MobileElement videobtn = driver.findElement(By.id("com.veemed.veedoc:id/btnSwitchVideo"));
	
	MobileElement micbtn = driver.findElement(By.id("com.veemed.veedoc:id/btnMic"));
	
	MobileElement endCall = driver.findElement(By.id("com.veemed.veedoc:id/btnEndCall"));
	
	MobileElement moreOption = driver.findElement(By.id("com.veemed.veedoc:id/btnMoreOptions"));
	
	MobileElement connect_btn = driver.findElement(By.id("com.veemed.veedoc:id/connectButton"));
	
	



	//Constructor for Page class of Veedoc Dashboard
	public PageVeeDoc_InviteCareProvider(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	



}