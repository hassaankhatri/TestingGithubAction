package Tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import Pages.PageVeeDoc_ChangePassword;
import Pages.PageVeeDoc_Dashboard;
import Pages.PageVeeDoc_DayOff;
import Pages.PageVeeDoc_InpatientSchedule;
import Pages.PageVeeDoc_Login;
import Pages.PageVeeDoc_ProfileManagement;
import Pages.PageVeeDoc_Settings;
import Pages.PageVeeDoc_More;
import Pages.Utility;
import Utilities.Xls_Reader;


public class TestVeeDoc_Schedule extends BaseClass{
	
	PageVeeDoc_Login loginpage;
	PageVeeDoc_Dashboard dashboard;
	PageVeeDoc_More morepage;
	PageVeeDoc_Settings settings;
	PageVeeDoc_ProfileManagement profile;
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	PageVeeDoc_ChangePassword changepass;
	PageVeeDoc_DayOff dayOff;
	PageVeeDoc_InpatientSchedule inpatient;
	
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
	public void Veedoc_DayOff() throws Exception {
		
		loginpage = new PageVeeDoc_Login(driver);
	
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		loginpage.clickonLoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		dashboard =  new PageVeeDoc_Dashboard(driver);
		dashboard.navigateToMenu("More");
		test.log(Status.INFO, "Navigate to More option Icon from Menu");
		
		morepage = new PageVeeDoc_More(driver);
		morepage.dayOffSchedule();
		test.log(Status.INFO,"Clicked on Day Off Option");
		
		dayOff = new PageVeeDoc_DayOff(driver);
		dayOff.markDayOff();
		test.log(Status.INFO,"Marking currentday as Day Off");
		
		morepage.inPatientSchedule();
		
		inpatient = new PageVeeDoc_InpatientSchedule(driver);
		//following is the verification to Verify the Logged-in User name must be displayed on dashboard
		softAssert.assertEquals(inpatient.getDate(), String.valueOf(dayofMonth));
		test.log(Status.INFO, "Verify that, Current date/day of month must be displayed as Day OFF");
		
		softAssert.assertEquals(inpatient.getDayoffStatus(), "OFF");
		test.log(Status.INFO, "Verify that, Day OFF status must be displayed as 'OFF'");
		inpatient.goBack();
		
		morepage.dayOffSchedule();
		test.log(Status.INFO,"Clicked on Day Off Option");
		
		dayOff.unmarkDayOff();
		test.log(Status.INFO,"Un-Marking currentday, removing Day OFF schedule");
		
		//functions for Signout
		dashboard.signOut();
		test.log(Status.INFO, "Clicked on SignOut Button");
		
		test.log(Status.INFO, "VeeDoc Day OFF Test Completed");
		
		 softAssert.assertAll();
	}
		
}

