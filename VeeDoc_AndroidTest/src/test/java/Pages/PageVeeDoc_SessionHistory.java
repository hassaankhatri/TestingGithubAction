package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_SessionHistory extends BasePage{
	
	Utility utility = new Utility();
	
	By searchIcon = By.id("com.veemed.veedoc:id/search_button");
	By searchBar = By.id("com.veemed.veedoc:id/search_src_text");
	
	By endpointName = By.id("com.veemed.veedoc:id/endpointContents_sessionHistory");
	
	By endpointSessionDateandTime = By.id("com.veemed.veedoc:id/receivedOnContents");
	By back = By.id("com.veemed.veedoc:id/btnBack");
	
	public PageVeeDoc_SessionHistory(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void searchInSessionHistory(String endpointName) throws Exception{
		utility.clickElement(searchIcon);
		utility.setText(searchBar, endpointName);
		utility.pressSearchKey();
	}
	
	public String getEndPointName() throws Exception{
		return utility.getTextFunc(endpointName);
	}
	
	
	public String getSessionDateTime() throws Exception{
		return utility.getTextFunc(endpointSessionDateandTime);
	}
	
	public void backToDashboard() throws Exception{
		utility.clickElement(back);
	}
	
}
