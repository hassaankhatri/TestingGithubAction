package Tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import Pages.PageVeeDoc_AddGroupAppointment;
import Pages.PageVeeDoc_AddPatientGroup;
import Pages.PageVeeDoc_Dashboard;
import Pages.PageVeeDoc_GroupSessions;
import Pages.PageVeeDoc_Login;
import Pages.PageVeeDoc_More;
import Pages.PageVeeDoc_ProfileManagement;
import Pages.PageVeeDoc_Settings;
import Pages.Utility;
import Utilities.Xls_Reader;

public class TestVeeDoc_GroupSessions extends BaseClass{
	
	SoftAssert softAssert;
	Xls_Reader reader;
	Utility utility;
	PageVeeDoc_Dashboard dashboard;
	PageVeeDoc_More morepage;
	PageVeeDoc_Settings settings;
	PageVeeDoc_ProfileManagement profile;
	PageVeeDoc_GroupSessions groupsession;
	PageVeeDoc_AddGroupAppointment addgroup;
	PageVeeDoc_AddPatientGroup patient;
	Date dates;
	
	String dayWeekText;
	int dayofMonth;
	
	String loginSheet = "login";
	String email;
	String password;
	String verifyName;
	
	@DataProvider(name="groupdata")
	public Object[][] passData(){
		
		Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
		
		//Get row count from Sheet/ SheetName
		int row = reader.getRowCount("group");
		Object[][] data = new Object[row][5];
		
		for(int i = 0; i<row; i++) {
			
			data[i][0]= reader.getCellData("group", 0, i);
			data[i][1]= reader.getCellData("group", 1, i);
			data[i][2]= reader.getCellData("group", 2, i);
			data[i][3]= reader.getCellData("group", 3, i);
			data[i][4]= reader.getCellData("group", 4, i);
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
		
     	dates=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dates);
        dayWeekText = new SimpleDateFormat("EEEE").format(dates);
        dayofMonth = c.get(Calendar.DAY_OF_MONTH);
	  }  
	
 
	@Test(dataProvider = "groupdata", priority=1)
	public void Veedoc_AddGroupAppointment(String groupName, String fName, String lName, String eMail,
			String number) throws Exception {
		
        PageVeeDoc_Login loginpage = new PageVeeDoc_Login(driver);
 
		//functions for login to Veedoc with valid credentials
		loginpage.enterCreds(email, password);
		test.log(Status.INFO, "Enter Email, Password to Login");
		
		//functions for Click on Login Button
		loginpage.clickonLoginBtn();
		test.log(Status.INFO, "Clicked on Login Button");
		
		dashboard =  new PageVeeDoc_Dashboard(driver);
		dashboard.navigateToMenu("More");
		test.log(Status.INFO, "Navigate to More option Icon from Menu");
		
		morepage = new PageVeeDoc_More(driver);
		morepage.groupSession();
		test.log(Status.INFO,"Clicked on Group Session button");
		
		groupsession =new PageVeeDoc_GroupSessions(driver);
		groupsession.navigateTo("Group");
		test.log(Status.INFO,"Navigated to Group Tab");
		
		groupsession.createNewGroup();
		
		addgroup = new PageVeeDoc_AddGroupAppointment(driver);
		//function for Add group appointment
		addgroup.addGroupInfo(groupName);
		test.log(Status.INFO,"Adding Group appointment Info/ Details");
		
		patient = new PageVeeDoc_AddPatientGroup(driver);
		//function for Add Patient details
	    patient.addPatient(fName, lName, eMail, number);
		test.log(Status.INFO,"Adding Patient Details in Group appointment");
	     
	    addgroup.saveGroupInfo();
		
	    softAssert = new SoftAssert();
		softAssert.assertEquals(groupsession.getName(), groupName);
		test.log(Status.INFO, "Verify that Group appointment must be created and group name must be displayed on Group session grid");
			
		String date = groupsession.createdDate();
		softAssert.assertTrue(date.contains(String.valueOf(dayofMonth)));
		test.log(Status.INFO, "Verify that created appointment date must be displayed on group session grid");
		
		groupsession.openCreatedGroup();
		addgroup.patientRow(fName);
		softAssert.assertEquals(addgroup.verifypatient(), fName);
		test.log(Status.INFO, "Verify that Patient Details must be added in created Group appointment and Patient Name must be displayed");
		
		addgroup.back();
		
		test.log(Status.INFO, "VeeDoc Create Group Session Test Completed");
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void Veedoc_DeleteGroupAppointment() throws Exception {
        
		groupsession.deleteGroupAppointment();
		test.log(Status.INFO, "VeeDoc Created Group Session Deleted successfully");
		softAssert.assertAll();
	}
}
