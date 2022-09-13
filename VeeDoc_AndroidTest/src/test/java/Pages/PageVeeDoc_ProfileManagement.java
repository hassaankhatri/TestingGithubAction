package Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_ProfileManagement  extends BasePage{

	Utility utility = new Utility();
	String save_btn= "com.veemed.veedoc:id/saveButton_profileManagement";
	
	By firstName=  By.id("com.veemed.veedoc:id/firstNameEditText_profileManagement");
	
	By lastName = By.id("com.veemed.veedoc:id/lastNameEditText_profileManagement");
	
	By phone = By.id("com.veemed.veedoc:id/mobileNumberEditText_profileManagement");
	
	By navigateBack = By.className("android.widget.ImageButton");
	
	By state = By.id("com.veemed.veedoc:id/cityTextView_profileManagement");
	
	By verifyTitle = By.id("com.veemed.veedoc:id/pracGroupEditText_profileManagement");
	//MobileElement group = driver.findElement(By.id("com.veemed.veedoc:id/pracGroupEditText_profileManagement"));
	
	public PageVeeDoc_ProfileManagement(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		this.driver= driver;
	}
	public boolean swipeFromBottomToUp()
	{
	try {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	HashMap<String, String> scrollObject = new HashMap<String, String>();
	scrollObject.put("direction", "down");
	js.executeScript("mobile: scroll", scrollObject);
	}
	catch (Exception e)
	{
	System.out.println("swipe down was not successfull");
	}
	return false;
	}
	
	public void updateProfile(String fname, String lname, String number) throws Exception {
		//String save_btn = "com.veemed.veedoc:id/saveButton_profileManagement";
		//String id= "com.veemed.veedoc:id/tvDevice";
//		utility.clearText(firstName);
//		utility.setText(firstName, "QA");
//		utility.clearText(lastName);
//		utility.setText(lastName, "Zeeshan");
//		
//		utility.clearText(phone);
//		utility.setText(phone, "03463911243");
//		
//		utility.clickButton(firstName);
//
//		utility.scrollandClick(save_btn);
//		utility.Wait();
//		utility.clickButton(navigateBack);
	
		utility.clearText(firstName);
		utility.setText(firstName, fname);
		
		utility.clearText(lastName);
		utility.setText(lastName, lname);
		
		utility.clearText(phone);
		utility.setText(phone, number);
		
		utility.clickElement(firstName);

		utility.scrollandClick(save_btn);
		utility.Wait();
		utility.clickElement(navigateBack);
	}
	
	public void revertProfile(String fname, String lname, String number) throws Exception {
		//String save_btn = "com.veemed.veedoc:id/saveButton_profileManagement";
		//String id= "com.veemed.veedoc:id/tvDevice";
		utility.clearText(firstName);
		utility.setText(firstName, fname);
		
		utility.clearText(lastName);
		utility.setText(lastName, lname);
		
		utility.clearText(phone);
		utility.setText(phone, number);
		
		//utility.clickElement(lastName);
		//utility.clickButton(state);
		//utility.scrollandClick(alaska);
		//MobileElement result = driver.findElement(By.xpath(alaska));
		//utility.clickButton(result);
		utility.scrollandClick(save_btn);
		//MobileElement result = driver.findElement(By.id("com.veemed.veedoc:id/saveButton_profileManagement"));
		//utility.clickButton(result);
//		utility.Wait();
//		utility.scrollandClick(save_btn);
		
		utility.Wait();
		utility.clickElement(navigateBack);
	
	}
	
	public String getFirstName() throws Exception{
		
		utility.Wait();
		//MobileElement result = driver.findElement(By.xpath(firstName));
		return utility.getTextFunc(firstName);
	}
	
	public String getLastName() throws Exception{
		
		//utility.Wait();
		//MobileElement result = driver.findElement(By.xpath(firstName));
		return utility.getTextFunc(lastName);
	}
	
	public String getMobileNumber() throws Exception{
		
		//utility.Wait();
		//MobileElement result = driver.findElement(By.xpath(firstName));
		return utility.getTextFunc(phone);
	}
	
}


