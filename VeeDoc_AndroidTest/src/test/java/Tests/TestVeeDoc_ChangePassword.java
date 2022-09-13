package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Pages.PageVeeDoc_ChangePassword;
import Pages.PageVeeDoc_Dashboard;
import Pages.PageVeeDoc_Login;
import Pages.PageVeeDoc_ProfileManagement;
import Pages.PageVeeDoc_Settings;
import Pages.PageVeeDoc_More;
import Pages.Utility;
import Utilities.Xls_Reader;


public class TestVeeDoc_ChangePassword extends BaseClass{
	
	PageVeeDoc_Login loginpage;
	PageVeeDoc_Dashboard dashboard;
	PageVeeDoc_More morepage;
	PageVeeDoc_Settings settings;
	PageVeeDoc_ProfileManagement profile;
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	PageVeeDoc_ChangePassword changepass;
	
	String loginSheet = "login";
	String email;
	String password;
	String verifyName;
	
	String profileSheet = "profile";
	String fname;
	String lname;
	String zip;
	String group;
	
	@DataProvider(name="changePass")
	public Object[][] passData(){
		
		Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		
		//Get row count from Sheet/ SheetName
		int row = reader.getRowCount("password");
		Object[][] data = new Object[row][2];
		
		for(int i = 0; i<row; i++) {
			
			data[i][0]= reader.getCellData("password", 0, i);
			data[i][1]= reader.getCellData("password", 1, i);
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
      	verifyName = reader.getData(loginSheet, 2, 2);
      	
		
	  }  
	
	@Test(dataProvider = "changePass")
	public void Veedoc_ChangeNewPassword(String oldPass, String newPass) throws Exception {
		
		loginpage = new PageVeeDoc_Login(driver);
	
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		loginpage.clickonLoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		dashboard =  new PageVeeDoc_Dashboard(driver);
		dashboard.navigateToMenu("More");
		test.log(Status.INFO, "Navigate to More option Icon from Menu");
		
		morepage = new PageVeeDoc_More(driver);
		morepage.settings();
		test.log(Status.INFO,"Clicked on Setting button");
		
		settings = new PageVeeDoc_Settings(driver);
		settings.ChangePassword();
		test.log(Status.INFO,"Clicked on Change Password  button");
		
		//Changing the Password of VeeDoc user
		changepass = new PageVeeDoc_ChangePassword(driver);
		changepass.changeToNewPassword(oldPass, newPass, newPass);
		test.log(Status.INFO, "Updating New Password");
		
		test.log(Status.INFO, "VeeDoc Change Password Test Completed");
		
		softAssert.assertAll();

	}
	
	@Test(dataProvider = "changePass")
	public void Veedoc_ChangeOldPassword(String oldPass, String newPass) throws Exception {
		
		loginpage = new PageVeeDoc_Login(driver);
	
		/////////////////////////////////
		//Again sign-in to verify that user must be logged in to new updated password
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, newPass);
		loginpage.LoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
				
		dashboard =  new PageVeeDoc_Dashboard(driver);
		softAssert = new SoftAssert();
		//following is the verification to Verify the Logged-in User name must be displayed on dashboard
		softAssert.assertEquals(dashboard.getName(), verifyName);
		test.log(Status.INFO, "User must be logged in with the new password, User name must be displayed");
		
		dashboard.navigateToMenu("More");
		test.log(Status.INFO, "Navigate to More option Icon from Menu");
				
		morepage = new PageVeeDoc_More(driver);
		morepage.settings();
		test.log(Status.INFO,"Clicked on Setting button");
				
		settings = new PageVeeDoc_Settings(driver);
		settings.ChangePassword();
		test.log(Status.INFO,"Clicked on Change Password  button");
				
		//Changing the Password of VeeDoc user
		changepass = new PageVeeDoc_ChangePassword(driver);
		changepass.changeToOldPassword(newPass, oldPass, oldPass);
		test.log(Status.INFO, "Reverting to Old Password");
		
		test.log(Status.INFO, "VeeDoc Revert Password Test Completed");
		
		softAssert.assertAll();

		
	}
}
