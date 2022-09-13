package Utilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

@SuppressWarnings("serial")
public class Capabilities extends DesiredCapabilities {
	private static AppiumDriver<MobileElement> appiumDriver;
    private static String jsonFilePath = "src/test/resources/Capabilities/config.json";
    private static String apkFilePath = System.getProperty("user.dir");
	public static AndroidDriver<AndroidElement> Driver;
    
    public static void startService() {
    	try {
    		JsonReader jsonReader = new JsonReader(jsonFilePath);
    		jsonReader = new JsonReader("src/test/resources/Capabilities/"+jsonReader.getValue("capability"));
    		DesiredCapabilities capabilities = new DesiredCapabilities();
//    		capabilities.setCapability(CapabilityType.PLATFORM_NAME, jsonReader.getValue("platformName"));
//    		capabilities.setCapability(CapabilityType.VERSION, jsonReader.getValue("platformVersoin"));
    		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,  jsonReader.getValue("deviceName"));
    		capabilities.setCapability(MobileCapabilityType.UDID,  jsonReader.getValue("uid"));
    		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,  jsonReader.getValue("platformVersoin"));
    		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,  jsonReader.getValue("appPackage"));
    		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,  jsonReader.getValue("appActivity"));
//    		capabilities.setCapability(MobileCapabilityType.NO_RESET, jsonReader.getValue("noReset"));
			if(!apkFilePath.contains(".apk")) {
				apkFilePath = apkFilePath+jsonReader.getValue("app");
			}
    		capabilities.setCapability(MobileCapabilityType.APP, apkFilePath);

    		appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
        catch (Exception e) {
			System.out.println("Cause: "+e.getCause());
			System.out.println("Message: "+e.getMessage());
			e.printStackTrace();
		}
    }
    
    
    public static void stopService() {
    	appiumDriver.quit();
    }
    
    public static AppiumDriver<MobileElement> getDriverInstance(){
    	return appiumDriver;
    }
}