package Pages;

import org.apache.commons.math3.stat.descriptive.moment.SemiVariance.Direction;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;

import Tests.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

//import sun.plugin.dom.html.HTMLElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class Utility {
	public AppiumDriver<MobileElement> driver;
	public AndroidDriver<MobileElement> androidDriver;
	
	public Utility() {
		this.driver = (AppiumDriver<MobileElement>) BaseClass.getDriverInstance();
	}

	public void waitForElement(WebDriver d,WebElement element) throws Exception{
		WebDriverWait wait = new WebDriverWait(d, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void fluentWaitForElement(WebDriver d,WebElement element) {
		Wait wait = new FluentWait(d)
				.withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(30))
				.ignoring(Exception.class)
				.ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void Wait() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	//added
	public void waitForElementEnable(WebDriver d,By element) throws Exception{
		WebDriverWait wait = new WebDriverWait(d, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//added
	public void clickElement(By locator) throws Exception {
		
		waitForElementEnable(driver, locator);
		MobileElement element = driver.findElement(locator);
		element.click();
		
	}
	
	public void clearText(By locator) throws Exception {
		waitForElementEnable(driver, locator);
		MobileElement element = driver.findElement(locator);
		element.clear();
	}
	//added
	public void setText(By locator, String value) throws Exception {
		//fluentWaitForElement(driver,locator);
		waitForElementEnable(driver, locator);
		MobileElement element = driver.findElement(locator);
		element.sendKeys(value);
	}
	//added
	public String getTextFunc(By locator) throws Exception {
		waitForElementEnable(driver, locator);
		MobileElement element = driver.findElement(locator);
		return element.getText();
	}
	
//	public String getTextFunc(MobileElement locator) {
//		fluentWaitForElement(driver,locator);
//		return locator.getText();
//	}

	public void clickTextView(String textView) {
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+textView+"')]")).click();;
	}
	
	public void scrollandClick(String text) {
		
		MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().resourceIdMatches(\"" + text + "\"));"));

		System.out.println(el.getLocation());
		el.click();
		
	}
	
	public void scrollToTextById(String text) {
		MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().resourceIdMatches(\"" + text + "\"));"));

		System.out.println(el.getLocation());
		el.getText();
	}
	
	public void scrollToText(String text) {
		MobileElement el = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
						+ "new UiSelector().text(\"" + text + "\"));"));

		System.out.println(el.getLocation());
		el.getText();
	}
	
	public void pressSearchKey() throws InterruptedException {
		  driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
		  Wait();
		  driver.hideKeyboard();
	}
	
	public void relaunch() {
		driver.launchApp();
	}
	
	public void swipeLeft(By locator) throws Exception {
		Dimension windowSize = driver.manage().window().getSize();
		double startX, startY, endX, endY;
		startX = 0.75 * windowSize.width;
		startY = 0.15 * windowSize.height;
		endX = 0.10 * windowSize.width;
		endY = 0.15 * windowSize.height;
		
		MobileElement element = driver.findElement(locator);
        TouchAction touchAction = new TouchAction(driver);
        //touchAction.press(ElementOption.element(element)).waitAction().moveTo(swipe).release().perform();
        touchAction.press(ElementOption.element(element).point((int)startX, (int)startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point((int)endX, (int)endY)).release().perform();
	}
	
	public void swipeLeftGroup(By locator) throws Exception {
		Dimension windowSize = driver.manage().window().getSize();
		double startX, startY, endX, endY;
		startX = 0.75 * windowSize.width;
		startY = 0.34 * windowSize.height;
		endX = 0.10 * windowSize.width;
		endY = 0.34 * windowSize.height;
		
		MobileElement element = driver.findElement(locator);
        TouchAction touchAction = new TouchAction(driver);
        //touchAction.press(ElementOption.element(element)).waitAction().moveTo(swipe).release().perform();
        touchAction.press(ElementOption.element(element).point((int)startX, (int)startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point((int)endX, (int)endY)).release().perform();
	}
	
	//Random digit edit in name function
		// class variable
		final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

		final java.util.Random rand = new java.util.Random();

		// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
		final Set<String> identifiers = new HashSet<String>();

		public String randomIdentifier() {
		    StringBuilder builder = new StringBuilder();
		    while(builder.toString().length() == 0) {
		        int length = rand.nextInt(5)+5;
		        for(int i = 0; i < length; i++) {
		            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
		        }
		        if(identifiers.contains(builder.toString())) {
		            builder = new StringBuilder();
		        }
		    }
		    return builder.toString();
		}

}
