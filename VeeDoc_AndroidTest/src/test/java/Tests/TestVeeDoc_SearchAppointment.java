package Tests;

import java.util.Calendar;
import java.util.Date;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import Pages.PageVeeDoc_AddQuickAppointment;
import Pages.PageVeeDoc_Appointments;
import Pages.PageVeeDoc_Dashboard;
import Pages.PageVeeDoc_Login;
import Pages.PageVeeDoc_More;
import Pages.PageVeeDoc_SearchAppointment;
import Pages.Utility;
import Utilities.Xls_Reader;

public class TestVeeDoc_SearchAppointment extends BaseClass{
	
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	
	String loginSheet = "login";
	String email;
	String password;
	String verifyName;
	String nameWithRadomDigit;
	int dayofMonth;
	PageVeeDoc_Dashboard dashboard =  new PageVeeDoc_Dashboard(driver);
	

	@DataProvider(name="appointdata")
	public Object[][] passData(){
		
		Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		
		//Get row count from Sheet/ SheetName
		int row = reader.getRowCount("quickApp");
		Object[][] data = new Object[row][5];
		
		for(int i = 0; i<row; i++) {
			
			data[i][0]= reader.getCellData("quickApp", 0, i);
			data[i][1]= reader.getCellData("quickApp", 1, i);
			data[i][2]= reader.getCellData("quickApp", 2, i);
			data[i][3]= reader.getCellData("quickApp", 3, i);
			data[i][4]= reader.getCellData("quickApp", 4, i);
		}
		
		return data;
	}
	
	@BeforeTest                                               
	 public void before_test()  
	  {  
		reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		softAssert = new SoftAssert();
		utility = new Utility();
		
		email = reader.getData(loginSheet, 0, 2);
    	password = reader.getData(loginSheet, 1, 2);
		
    	Date date = new Date();
    	Calendar c = Calendar.getInstance();
        c.setTime(date);
       // String dayWeekText = new SimpleDateFormat("EEEE").format(date);
        dayofMonth = c.get(Calendar.DAY_OF_MONTH);
        
	  }  
	
 
	@Test(dataProvider = "appointdata", priority = 1)
	public void Veedoc_QuickAppointment(String fname, String lname, String eemail, String number, String reason) 
			throws Exception {
		
		nameWithRadomDigit = fname + utility.randomIdentifier();
		verifyName = nameWithRadomDigit + ' ' + lname;
        
        PageVeeDoc_Login loginpage = new PageVeeDoc_Login(driver);
 
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		test.log(Status.INFO, "Enter Email, Password to Login");
		
		//functions for Click on Login Button
		loginpage.clickonLoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		
		softAssert = new SoftAssert();
		dashboard =  new PageVeeDoc_Dashboard(driver);
		dashboard.navigateToMenu("Appointment");
		test.log(Status.INFO, "Navigate to Appointment from Menu");
		
		dashboard.createAppointment();
		PageVeeDoc_AddQuickAppointment addappoint = new PageVeeDoc_AddQuickAppointment(driver);
		addappoint.createQuickAppointment(nameWithRadomDigit, lname, eemail, number, reason);
		test.log(Status.INFO,"Creating Quick Appointment");
		
		PageVeeDoc_Appointments appoint = new PageVeeDoc_Appointments(driver);
		appoint.scrollToPatientName(verifyName);
		softAssert.assertTrue(appoint.verifyPname(verifyName).contains(verifyName));
		System.out.println("name verfiication passed");
		test.log(Status.INFO, "Verify that quick appointment must be created and full name must be displayed on appointment session grid");
			
		String date = appoint.verifyDate();
		softAssert.assertTrue(date.contains(String.valueOf(dayofMonth)));
		System.out.println("date verfiication passed");
		test.log(Status.INFO, "Verify that created appointment date must be displayed on quick appointment session grid");
		
		softAssert.assertAll();	
	}
	
	@Test(priority = 2)
	public void VeeDoc_SearchAppointment() throws Exception { 
		
		 dashboard =  new PageVeeDoc_Dashboard(driver);
		 dashboard.navigateToMenu("More");
		 test.log(Status.INFO, "Navigate to more tab");
		 
		 PageVeeDoc_More morePage = new PageVeeDoc_More(driver);
		 morePage.searchAppointment();
		 test.log(Status.INFO, "Navigate to Search Appointment Page");
		 
		 PageVeeDoc_SearchAppointment sa = new PageVeeDoc_SearchAppointment(driver);
		 sa.searchAppointment(nameWithRadomDigit);
		 test.log(Status.INFO, "Appointment Searched");
		 
		 softAssert.assertEquals(sa.getPatientName(), verifyName);
		 test.log(Status.INFO, "Verified Quick Appointment patient name after search");
			
		 //functions for Signout
		 dashboard.signOut();
		 test.log(Status.INFO, "Clicked on SignOut Button");
					
		 test.log(Status.INFO, "VeeDoc Search Appointment Test Completed");
		 
		 softAssert.assertAll();
	}
	
}
