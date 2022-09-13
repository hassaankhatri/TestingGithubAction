package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Pages.PageVeeDoc_Dashboard;
import Pages.PageVeeDoc_Login;
import Pages.PageVeeDoc_ProfileManagement;
import Pages.PageVeeDoc_Settings;
import Pages.PageVeeDoc_More;
import Pages.Utility;
import Utilities.Xls_Reader;


public class TestVeeDoc_ProfileUpdate extends BaseClass{
	
	PageVeeDoc_Login loginpage;
	PageVeeDoc_Dashboard dashboard;
	PageVeeDoc_More morepage;
	PageVeeDoc_Settings settings;
	PageVeeDoc_ProfileManagement profile;
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	
	String loginSheet = "login";
	String email;
	String password;
	String verifyName;
	
	String profileSheet = "profile";
	String fname;
	String lname;
	String zip;
	String group;
	
	@DataProvider(name="profileUpdate")
	public Object[][] passData(){
		
		Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		
		//Get row count from Sheet/ SheetName
		int row = reader.getRowCount("profiledata");
		Object[][] data = new Object[row][6];
		
		for(int i = 0; i<row; i++) {
			
			data[i][0]= reader.getCellData("profiledata", 0, i);
			data[i][1]= reader.getCellData("profiledata", 1, i);
			data[i][2]= reader.getCellData("profiledata", 2, i);
			data[i][3]= reader.getCellData("profiledata", 3, i);
			data[i][4]= reader.getCellData("profiledata", 4, i);
			data[i][5]= reader.getCellData("profiledata", 5, i);
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
      	
//      //following lines are for getting the login data from excel sheet
//      	fname = reader.getCellData(profileSheet, 1, 2);
//        lname = reader.getCellData(profileSheet, 2, 2);
//        zip = reader.getCellData(profileSheet, 3, 2);
//        group = reader.getCellData(profileSheet, 4, 2);
		
	  }  
	
	@Test(dataProvider = "profileUpdate")
	public void Veedoc_ProfileUpdate(String fname, String lname, String number, String old_fname,
			String old_lname, String old_number) throws Exception {
		
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
		settings.clickOnProfile();
		test.log(Status.INFO,"Clicked on Profile button");
		
		//Updating the profile of VeeDoc user
		profile = new PageVeeDoc_ProfileManagement(driver);
		profile.updateProfile(fname, lname, number);
		test.log(Status.INFO, "Updating profile Information");
		
		settings.clickOnProfile();
		System.out.println("Clicked on Profile button");
		
		softAssert = new SoftAssert();
		//following is the verification to Verify the data must be updated 
		softAssert.assertEquals(profile.getFirstName(), fname);
		test.log(Status.INFO, "Verify that First Name must be updated and matches with the new one");
		
		softAssert.assertEquals(profile.getLastName(), lname);
		test.log(Status.INFO, "Verify that Last Name must be updated and matches with the new one");
		
		softAssert.assertEquals(profile.getMobileNumber(), number);
		test.log(Status.INFO, "Verify that Phone Number must be updated and matches with the new one");
		
		//Reverting back profile of VeeDoc user to original
		profile.revertProfile(old_fname, old_lname, old_number);
		test.log(Status.INFO, "Reverting profile back to original form");
		
		settings.clickOnProfile();
		System.out.println("Clicked on Profile button");
		
		//following is the verification to Verify the data must be reverted back to original 
		softAssert.assertEquals(profile.getFirstName(), old_fname);
		test.log(Status.INFO, "Verify that First Name must be reverted back to previous one");
		
		softAssert.assertEquals(profile.getLastName(), old_lname);
		test.log(Status.INFO, "Verify that Last Name must be reverted back to previous one");
		
		softAssert.assertEquals(profile.getMobileNumber(), old_number);
		test.log(Status.INFO, "Verify that Phone Number must be reverted back to previous one");
		
		test.log(Status.INFO, "VeeDoc Profile Update and Revert Test Completed");
		
		softAssert.assertAll();
	}
}
