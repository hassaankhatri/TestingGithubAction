package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Pages.PageVeeDoc_Dashboard;
import Pages.PageVeeDoc_Endpoint;
import Pages.PageVeeDoc_EndpointSession;
import Pages.PageVeeDoc_Login;
import Pages.Utility;
import Utilities.Xls_Reader;


public class TestVeeDoc_EndPointSession extends BaseClass{
	
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	PageVeeDoc_Login loginpage;
	PageVeeDoc_Dashboard dashboard;
	PageVeeDoc_Endpoint endpoint;
	PageVeeDoc_EndpointSession  epsession;
	
	String loginSheet = "login";
	String endpointSheet = "endpoint";
	String email;
	String password;
	String verifyName;
	String epname;
	String offline_epname;
	String facilityname;
	
	@BeforeTest                                               
	 public void before_test()  
	  {  
		reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		softAssert = new SoftAssert();
		utility = new Utility();
		
		email = reader.getData(loginSheet, 0, 2);
     	password = reader.getData(loginSheet, 1, 2);
     	epname = reader.getData(endpointSheet, 0, 2);
     	facilityname = reader.getData(endpointSheet, 1, 2);
     	offline_epname = reader.getData(endpointSheet, 0, 3);     	
		
	  }  
	//@Test(enabled=false)
	@Test(priority=1)
public void Veedoc_OfflineEndpointFavourite() throws Exception {
       
        loginpage = new PageVeeDoc_Login(driver);
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		test.log(Status.INFO, "Enter Email, Password to Login");
		
		//functions for Click on Login Button
		loginpage.clickonLoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		dashboard =  new PageVeeDoc_Dashboard(driver);
		//functions for Navigate to Menu
		dashboard.navigateToMenu("Endpoints");
		test.log(Status.INFO, "Navigate to Endpoints option Icon from Menu");
		
		endpoint = new PageVeeDoc_Endpoint(driver);
		//functions for Search EndPoint
		endpoint.navigateTo("Offline");
		endpoint.searchEndpoint(offline_epname);
		test.log(Status.INFO, "Search the offline endpoint in Offline tab");
		
		softAssert.assertEquals(endpoint.getOfflinestatus(), "offline");
		test.log(Status.INFO, "Verify that Endpoint status must be displayed as offline");
		
		endpoint.favouriteEP();
		test.log(Status.INFO, "Marked endpoint as favourite");
		
		endpoint.navigateToTab("Favourites");
		softAssert.assertEquals(endpoint.getEPname(), offline_epname);
		test.log(Status.INFO, "Verify that Offline Endpoint name must be displayed as Favourite in favourite tab");
		
		endpoint.unfavouriteEP();
		test.log(Status.INFO, "Marked endpoint as unfavourite");
		
		if(endpoint.isElementPresent() == false) {
			
			//softAssert.assertTrue(endpoint.isElementPresent());
			test.log(Status.INFO, "Removed from favourite tab as user unfavourited it, Test Passed");
			System.out.println("Removed from favourite tab as user unfavourited it, Test Passed");
		}
		else {
			
			test.log(Status.INFO, "Endpoint exist in favourite tab, Test Failed");
			System.out.println("Endpoint exist in favourite tab, Test Failed");
			
		}
		
		//functions for Signout
		dashboard.signOut();
		test.log(Status.INFO, "Clicked on SignOut Button");
		
		//endpoint.navigateTo("Offline");
		test.log(Status.INFO, "Veedoc Offline Endpoint Favourite Test Completed");
		
		softAssert.assertAll();

		
}
	@Test(priority=2)
	public void Veedoc_ConnectEndpoint() throws Exception {
		       
        loginpage = new PageVeeDoc_Login(driver);
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		test.log(Status.INFO, "Enter Email, Password to Login");
		
		//functions for Click on Login Button
		loginpage.LoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		dashboard =  new PageVeeDoc_Dashboard(driver);
		//functions for Navigate to Menu
		dashboard.navigateToMenu("Endpoints");
		test.log(Status.INFO, "Navigate to Endpoints option Icon from Menu");
		
		endpoint = new PageVeeDoc_Endpoint(driver);
		//functions for Search and Connect EndPoint
		endpoint.searchEndpoint(epname);
		test.log(Status.INFO, "Search Endpoint name and connect to the endpoint session");
		
		endpoint.connectEndpoint();
		test.log(Status.INFO, "Connect to the endpoint session");
		
		epsession = new PageVeeDoc_EndpointSession(driver);
		softAssert = new SoftAssert();
		
		softAssert.assertEquals(epsession.getFacilityName(), facilityname);
		test.log(Status.INFO, "Verify that connected Endpoint facility name must be displayed on connected session page");
		
		softAssert.assertTrue(epsession.getEndpointName().contains(epname));
		test.log(Status.INFO, "Verify that connected Endpoint name must be displayed on connected session page");
		
		//functions for EndSession
		epsession.endSession();
		test.log(Status.INFO, "Ending the session");
		
		softAssert.assertEquals(endpoint.navigatedToEP(), "Endpoints");
		test.log(Status.INFO, "Session must be ended and user must be navigated to Endpoints Page");
		
		test.log(Status.INFO, "VeeDoc Connect Endpoint Test Completed");
		
		softAssert.assertAll();

	}
	
	@Test(priority=3)
	public void Veedoc_BusyEndpoint() throws Exception {
        
        utility.relaunch();
        
        loginpage = new PageVeeDoc_Login(driver);
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		test.log(Status.INFO, "Enter Email, Password to Login");
		
		//functions for Click on Login Button
		loginpage.clickonLoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		dashboard =  new PageVeeDoc_Dashboard(driver);
		//functions for Navigate to Menu
		dashboard.navigateToMenu("Endpoints");
		test.log(Status.INFO, "Navigate to Endpoints option Icon from Menu");
		
		endpoint = new PageVeeDoc_Endpoint(driver);
		//functions for Search and Connect EndPoint
		endpoint.searchEndpoint(epname);
		test.log(Status.INFO, "Search Endpoint name and connect to the endpoint session");
		
		endpoint.connectEndpoint();
		test.log(Status.INFO, "Connect to the endpoint session");
		
		utility.relaunch();
		
		loginpage = new PageVeeDoc_Login(driver);
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		test.log(Status.INFO, "Enter Email, Password to Login");
		
		//functions for Click on Login Button
		loginpage.clickonLoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		endpoint.reconnectSession();
		test.log(Status.INFO, "Reconnect to the session");
		
		softAssert.assertEquals(epsession.getFacilityName(), facilityname);
		test.log(Status.INFO, "Verify that connected Endpoint facility name must be displayed on connected session page");
		
		softAssert.assertTrue(epsession.getEndpointName().contains(epname));
		test.log(Status.INFO, "Verify that connected Endpoint name must be displayed on connected session page");
		
		epsession.endSession();
		test.log(Status.INFO, "Ending the session");
		
		softAssert.assertAll();

	}
}
