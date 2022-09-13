package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {
	
	protected AppiumDriver<MobileElement> driver;
	
	public BasePage(AppiumDriver<MobileElement> driver) {
		
		this.driver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

}
