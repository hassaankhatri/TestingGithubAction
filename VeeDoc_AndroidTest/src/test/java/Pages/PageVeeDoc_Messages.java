package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_Messages extends BasePage{

	Utility utility = new Utility();
	String user = "//android.widget.TextView[@text='";
	String user1 = "']";
	
	String msg = "//android.widget.TextView[@text='";
	String msg1 = "']";
	
	By allowAudio = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
	
	By allowMedia = By.id("com.android.permissioncontroller:id/permission_allow_button");
	
	By chat_tab = By.id("com.veemed.veedoc:id/btnChat");
	
	By deferred_tab = By.id("com.veemed.veedoc:id/btnDeferMessages");
	
	By newChat=  By.id("com.veemed.veedoc:id/btnAddUser");
	
	By searchUserChat=  By.id("com.veemed.veedoc:id/etSearchUser");
	
	By messageChat=  By.id("com.veemed.veedoc:id/etNewMessage");
	
	By message_btn=  By.id("com.veemed.veedoc:id/btnSendMessage");
	
	By back=  By.id("com.veemed.veedoc:id/btnBack");
	
	By cancel=  By.id("com.veemed.veedoc:id/btnCancel");
	
	By attachment=  By.id("com.veemed.veedoc:id/ivAttachment");
	
	
	
	public PageVeeDoc_Messages(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	
	public String verifyMessage(String message) throws Exception{
		
		String chatMsg= msg + message + msg1;
		By getMsg=  By.xpath(chatMsg);
		return utility.getTextFunc(getMsg);
	}
	
	public void searchUser(String name) throws Exception {
		
		utility.clickElement(newChat);
		utility.setText(searchUserChat, name);
		String chatUser= user + name + user1;
		By searchUser=  By.xpath(chatUser);
		utility.clickElement(searchUser);
		
	}
	
	public void sendMessage(String message) throws Exception {
		
		utility.clickElement(allowAudio);
		utility.clickElement(allowMedia);
		//int n = 5;
		utility.setText(messageChat, message);
		utility.clickElement(message_btn);
	}
}
