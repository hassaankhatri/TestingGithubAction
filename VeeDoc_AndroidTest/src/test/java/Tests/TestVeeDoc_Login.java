package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Pages.PageVeeDoc_Dashboard;
import Pages.PageVeeDoc_Login;
import Pages.Utility;
import Utilities.Xls_Reader;


public class TestVeeDoc_Login extends BaseClass{
	
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	
	@DataProvider(name="logindata")
	public Object[][] passData(){
		
		Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		
		//Get row count from Sheet/ SheetName
		int row = reader.getRowCount("veedocLogin");
		Object[][] data = new Object[row][3];
		
		for(int i = 0; i<row; i++) {
			
			data[i][0]= reader.getCellData("veedocLogin", 0, i);
			data[i][1]= reader.getCellData("veedocLogin", 1, i);
			data[i][2]= reader.getCellData("veedocLogin", 2, i);
		}
		
		return data;
	}
 
	@Test(dataProvider = "logindata")
	public void Veedoc_Login(String email, String pass, String verifyName) throws Exception {
        
//        //*********Page class of Veedoc Login**********
        PageVeeDoc_Login loginpage = new PageVeeDoc_Login(driver);
// 
//		//functions for login to Veedoc with valid credentials
//		loginpage.enterCreds(email, pass);
//		test.log(Status.INFO, "Enter Email, Password to Login");
//		
//		//functions for Click on Login Button
//		loginpage.clickonLoginBtn();
//		test.log(Status.INFO, "Clicked on Login Button");
//		
//		//**********Page class of Veedoc Dashboard*********
//		PageVeeDoc_Dashboard dashboard =  new PageVeeDoc_Dashboard(driver);
//		softAssert = new SoftAssert();
//		//following is the verification to Verify the Logged-in User name must be displayed on dashboard
//		softAssert.assertEquals(dashboard.getName(), verifyName);
//		test.log(Status.INFO, "User must be logged in with the Specified User, User name must be displayed");
//		
//		//functions for Signout
//		dashboard.signOut();
//		test.log(Status.INFO, "Clicked on SignOut Button");
//		
//		test.log(Status.INFO, "VeeDoc Login Test Completed");
		
		loginpage.clickTestButton();
		
		
		
	}
}
