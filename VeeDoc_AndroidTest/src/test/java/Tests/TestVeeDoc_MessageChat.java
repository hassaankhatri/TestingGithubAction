package Tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import Pages.PageVeeDoc_Dashboard;
import Pages.PageVeeDoc_Login;
import Pages.PageVeeDoc_Messages;
import Pages.PageVeeDoc_More;
import Pages.PageVeeDoc_ProfileManagement;
import Pages.PageVeeDoc_Settings;
import Pages.Utility;
import Utilities.Xls_Reader;

public class TestVeeDoc_MessageChat extends BaseClass{
	PageVeeDoc_Login loginpage;
	PageVeeDoc_Dashboard dashboard;
	PageVeeDoc_More morepage;
	PageVeeDoc_Settings settings;
	PageVeeDoc_ProfileManagement profile;
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	PageVeeDoc_Messages msg;
	
	String loginSheet = "login";
	String email;
	String password;
	String verifyName;
	
	Date dates;
	
	String dayWeekText;
	int dayofMonth;
	

	@BeforeTest                                               
	 public void before_test()  
	  {  
		reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		softAssert = new SoftAssert();
		utility = new Utility();
		
		email = reader.getData(loginSheet, 0, 2);
      	password = reader.getData(loginSheet, 1, 2);
      	verifyName = reader.getData(loginSheet, 2, 2);
      	dates=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dates);
        dayWeekText = new SimpleDateFormat("EEEE").format(dates);
        dayofMonth = c.get(Calendar.DAY_OF_MONTH);
		
	  }  
	
	@Test
	public void Veedoc_MessageChat() throws Exception {
		
		loginpage = new PageVeeDoc_Login(driver);
	
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		loginpage.clickonLoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		dashboard =  new PageVeeDoc_Dashboard(driver);
		dashboard.navigateToMenu("Messages");
		test.log(Status.INFO, "Navigate to Messages option Icon from Menu");
		
		msg = new PageVeeDoc_Messages(driver);
		
		msg.searchUser("kk hh");
		test.log(Status.INFO, "Searching the User to chat");
		
		String gmsg = "Test Message " + utility.randomIdentifier();
		
		msg.sendMessage(gmsg);
		test.log(Status.INFO, "Sending the message");
		
		//following is the verification to Verify the message
		softAssert.assertEquals(msg.verifyMessage(gmsg), gmsg);
		test.log(Status.INFO, "Verify that send message must be matches with the added one");
		
		test.log(Status.INFO, "Clicked on SignOut Button");
		
		test.log(Status.INFO, "VeeDoc Message Chat Test Completed");
		
		softAssert.assertAll();
	}		
	
}
