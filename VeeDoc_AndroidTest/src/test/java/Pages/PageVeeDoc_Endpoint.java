package Pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageVeeDoc_Endpoint  extends BasePage{

	Utility utility = new Utility();
	
	AndroidDriver<MobileElement> driver1;
	By userName = By.xpath("//android.widget.TextView[@index='0']");
	
	By allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
	
	By all_tab=  By.id("com.veemed.veedoc:id/btnAll");
	
	By favourites_tab=  By.id("com.veemed.veedoc:id/btnFavourite");
	
	By search = By.id("com.veemed.veedoc:id/etSearchEndpoint");
	
	By endpoint = By.id("com.veemed.veedoc:id/endpoints_option");
	
	By online_btn = By.id("com.veemed.veedoc:id/onlineButton");
	
	By busy_btn = By.id("com.veemed.veedoc:id/busyButton");
	
	By cancel_btn = By.id("com.veemed.veedoc:id/btnCancel");
	
	By reconnect_btn = By.id("com.veemed.veedoc:id/btnStart");
	
	By offline_btn = By.id("com.veemed.veedoc:id/offlineButton");
		
	By connect_btn = By.id("com.veemed.veedoc:id/connectButton");
	
	By endpointHeading = By.id("com.veemed.veedoc:id/toolbarCenterTextView");
	
	By offlineStatus = By.id("com.veemed.veedoc:id/offline_onlineTextView");
	
	By epName = By.id("com.veemed.veedoc:id/tvPcName");
	
	By favourite = By.id("com.veemed.veedoc:id/clickFavourite");
	
	By unFavourite = By.id("com.veemed.veedoc:id/btnEndSession");
	
	

	//Constructor for Page class of Veedoc Dashboard
	public PageVeeDoc_Endpoint(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public void searchEndpoint(String epname) throws Exception {
		
		
			utility.setText(search, epname);
			utility.clickElement(search);
			//utility.Wait();
			utility.pressSearchKey();
		
	
	}
	
	public void connectEndpoint() throws Exception {
		
		
		utility.clickElement(connect_btn);
		//MobileElement allow = driver.findElement(By.id(allowCamera));
		utility.clickElement(allow);
		utility.clickElement(allow);
		Thread.sleep(5000);

	}
	
	public void favouriteEP() throws Exception {
		
		utility.clickElement(favourite);

	}
	
	public void reconnectSession() throws Exception {
		utility.clickElement(reconnect_btn);
		utility.clickElement(allow);
		utility.clickElement(allow);
		Thread.sleep(5000);
	}
	
	public void unfavouriteEP() throws Exception {
		
		utility.clickElement(favourite);
		utility.clickElement(unFavourite);

	}
	
	public void navigateTo(String tabname) throws Exception {
		
		if(tabname == "Online") {
			
			utility.clickElement(online_btn);
		}
		if(tabname == "Offline") {
			
			utility.clickElement(offline_btn);
		}
		if(tabname == "Busy") {
		
		utility.clickElement(busy_btn);
	}
	

}
	
	public void navigateToTab(String tabname) throws Exception {
		
		if(tabname == "All") {
			
			utility.clickElement(all_tab);
		}
		if(tabname == "Favourites") {
			
			utility.clickElement(favourites_tab);
		}

	}
	
	public String navigatedToEP() throws Exception{
		
		utility.Wait();
		//MobileElement result = driver.findElement(By.id(facilityName));
		return utility.getTextFunc(endpointHeading);
	}
	
	public String getEPname() throws Exception{
		//MobileElement result = driver.findElement(By.id(facilityName));
		return utility.getTextFunc(epName);
	}
	
	public boolean isElementPresent() {
		  try {
//			MobileElement allow = driver.findElement(epName);
		    return true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    return false;
		   
		  }
		  
		}

	public String getOfflinestatus() throws Exception{
		
		//utility.Wait();
		//MobileElement result = driver.findElement(By.id(facilityName));
		return utility.getTextFunc(offlineStatus);
	}
}

