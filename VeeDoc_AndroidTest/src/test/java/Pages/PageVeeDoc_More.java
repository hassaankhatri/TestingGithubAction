package Pages;

import org.openqa.selenium.By;
import Utilities.YmlUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_More  extends BasePage{

	Utility utility = new Utility();
	
	YmlUtil yamlData = new YmlUtil();
	//AppiumDriver<MobileElement> driver;
	
	By inpatientSchedules=  By.xpath("//android.widget.TextView[@text='Inpatient Schedule']");
	
	By dayOff=  By.xpath("//android.view.ViewGroup[@index='1']");
	
	By outpatientSchedules = By.xpath("//android.view.ViewGroup[@index='2']");
	
	By searchAppointment = By.xpath("//android.view.ViewGroup[@index='3']");
	
	By sessionHistory = By.xpath("//android.view.ViewGroup[@index='4']");
	
	By groupVisits = By.xpath("//android.view.ViewGroup[@index='5']");
	
	By settings = By.xpath("//android.view.ViewGroup[@index='6']");
	
	
	
	public PageVeeDoc_More(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		//this.driver= driver;
	}
	
	public void settings() throws Exception {
		
		//utility.Wait();
		utility.clickElement(settings);
		
		
	
	}
	
	public void groupSession() throws Exception {
		
		utility.clickElement(groupVisits);
		
		
	
	}
	
	public void outPatientSchedule() throws Exception {
		
		utility.clickElement(outpatientSchedules);
		
	
	}
	
	public void inPatientSchedule() throws Exception {
		
		utility.clickElement(inpatientSchedules);
		
		
	
	}
	
	public void dayOffSchedule() throws Exception {
		
		utility.clickElement(dayOff);
		
		
	
	}
	
	public void searchAppointment() throws Exception {
		
		utility.clickElement(searchAppointment);
		
		
	
	}
	
	public void sessionHistory() throws Exception {
		
		utility.clickElement(sessionHistory);
		
		
	
	}



}

