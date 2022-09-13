package Pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_Dashboard  extends BasePage{

	Utility utility = new Utility();
	
	//AppiumDriver<MobileElement> driver;
	By userName = By.xpath("//android.widget.TextView[@index='0']");
	
	By yes_opt = By.id("com.veemed.veedoc:id/btnPositive");
	
	By inpatient_tab=  By.id("com.veemed.veedoc:id/btnInpatient");
	
	By outpatient_tab=  By.id("com.veemed.veedoc:id/btnOutpatient");
	
	By appoint_tab=  By.id("com.veemed.veedoc:id/btnAppointments");
	
	By sessions=  By.id("com.veemed.veedoc:id/session_option");
	
	By invites= By.id("com.veemed.veedoc:id/invites_option");
	
	By messages = By.id("com.veemed.veedoc:id/messages_option");
	
	By endpoint = By.id("com.veemed.veedoc:id/endpoints_option");
	
	By more = By.id("com.veemed.veedoc:id/more_option");
	
	By logOut = By.id("com.veemed.veedoc:id/signOut_icon");
	
	By appoint_btn = By.id("com.veemed.veedoc:id/btnCreateAppointment");

	//Constructor for Page class of Veedoc Dashboard
	public PageVeeDoc_Dashboard(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	public void navigateToMenu(String menuName) throws Exception {
		
		//utility.Wait();
		if(menuName == "More") {
			
			utility.clickElement(more);
		}
		if(menuName == "Endpoints") {
			
			utility.clickElement(endpoint);
		}
		if(menuName == "InPatient") {
			
			utility.clickElement(inpatient_tab);
		}
		if(menuName == "OutPatient") {
			
			utility.clickElement(outpatient_tab);
		}
		if(menuName == "Appointment") {
	
			utility.clickElement(appoint_tab);
		}
		
		if(menuName == "Messages") {
			
			utility.clickElement(messages);
		}
	
	}
	public String getName() throws Exception{
		
		utility.Wait();
		//MobileElement result = driver.findElement(By.xpath(userName));
		return utility.getTextFunc(userName);
	}
	
	public void signOut() throws Exception {
		
		utility.clickElement(logOut);
		//MobileElement yesOpt = driver.findElement(By.id(yes_opt));
		utility.clickElement(yes_opt);
		
	
	}
	
	public void createAppointment() throws Exception {
		
		//MobileElement yesOpt = driver.findElement(By.id(yes_opt));
		utility.clickElement(appoint_btn);
		
	
	}

}

