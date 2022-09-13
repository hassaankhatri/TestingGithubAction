package Pages;


import org.openqa.selenium.By;
import Utilities.Xls_Reader;
import Utilities.YmlUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageVeeDoc_Login extends BasePage{

	String loginSheet = "login";
	Utility utility = new Utility();
	YmlUtil yamlData = new YmlUtil();
	Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
	
	//following are the locators identification
	By email_txt=  By.id("emailEditText_main");
	
	By password_txt=  By.id("passwordEditText_main");
	
	By login_btn = By.id("signInButton_main");

	By dialog_Never = By.id("btnNever");
	
	
	public PageVeeDoc_Login(AppiumDriver<MobileElement> driver) {
		super(driver);
	
	}
	
	public void enterCreds(String id, String pass) throws Exception {
		
		//utility.Wait();
		utility.setText(this.email_txt, id);
		utility.setText(this.password_txt, pass);
	
	}
	
	public void clickonLoginBtn() throws Exception {
		
		//utility.Wait();
		utility.clickElement(login_btn);
		utility.Wait();
		//MobileElement never_opt = driver.findElement(By.id(dialog_Never));
		utility.clickElement(dialog_Never);
	}
	
	public void LoginBtn() throws Exception {
		
		//utility.Wait();
		utility.clickElement(login_btn);
		
	}
	
//	@DataProvider(name="logindata")
//	public Object[][] passData(){
//		
//		Xls_Reader reader = new Xls_Reader("./src/test/resources/TestData/TestData.xlsx");
//		
//		int row = reader.getRowCount("login");
//		Object[][] data = new Object[row][2];
//		
//		for(int i = 0; i<row; i++) {
//			
//			data[i][0]= reader.getCellData("login", i, 1);
//			data[i][0]= reader.getCellData("login", i, 2);
//			
//		}
//		
//		return data;
//	}
	}



