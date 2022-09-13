package Tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Utilities.JsonReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends Reports {
	
	static AppiumDriver<MobileElement> driver;
	private static String jsonFilePath = "src/test/resources/Capabilities/config.json";
	private static String apkFilePath = System.getProperty("user.dir");
	public static AndroidDriver<AndroidElement> Driver;
	
	@BeforeTest
	public void setup() {
		
		try {
		JsonReader jsonReader = new JsonReader(jsonFilePath);
    	jsonReader = new JsonReader("src/test/resources/Capabilities/"+jsonReader.getValue("capability"));
//    		
		DesiredCapabilities capa = new DesiredCapabilities();

		capa.setCapability(MobileCapabilityType.AUTOMATION_NAME, jsonReader.getValue("deviceName"));
		capa.setCapability(MobileCapabilityType.UDID,  jsonReader.getValue("uid"));
		capa.setCapability(MobileCapabilityType.PLATFORM_NAME, jsonReader.getValue("pname"));
		capa.setCapability(MobileCapabilityType.PLATFORM_VERSION, jsonReader.getValue("version"));
		capa.setCapability(MobileCapabilityType.DEVICE_NAME, jsonReader.getValue("emulator"));
		capa.setCapability("no",true);
		capa.setCapability("newCommandTimeout", 100000);
		//capa.setCapability(MobileCapabilityType.APP, "C:\\Apks\\veedoc-user-v2.3.0.4-Sep-23-qa-debug.apk");
		
		if(!apkFilePath.contains(".apk")) {
			apkFilePath = apkFilePath+jsonReader.getValue("app");
		}
		capa.setCapability(MobileCapabilityType.APP, apkFilePath);
		
		URL url = new URL("http://localhost:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, capa);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver= new AndroidDriver<MobileElement>(url, capa);
		//driver= new IOSDriver<MobileElement>(url, capa);
		
		}
		catch(Exception exp) {
			
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is: " + exp.getMessage());
			exp.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void teardown() {
		
		
	}
	
//	@Test
//	public void test() {
//		
//		
//		System.out.println("Test passed");
//		
//	}

	public static AppiumDriver<MobileElement> getDriverInstance(){
    	return driver;
    }


}
