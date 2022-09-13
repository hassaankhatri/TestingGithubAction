package Tests;


import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reports {


	  public static ExtentHtmlReporter htmlReporter;
	    public static ExtentReports extent;
	    public static ExtentTest test;

	    @BeforeSuite

	public void setupReport() {


		//where we need to generate the report
		htmlReporter = new ExtentHtmlReporter("VeeDocAutomationResults.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		 extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Host Name", "Hassaan Khatri");
		extent.setSystemInfo("Environment", "Automation Android Testing");
		extent.setSystemInfo("User Name", "Hassaan Khatri");

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Automatio VeeDoc Android Results");

		htmlReporter.config().setReportName("Automation Android Testing");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a ");
		

	}
	    @BeforeMethod
	    public void startTest(Method m)
	    {
	        test = extent.createTest(m.getName(),"This is the description of Test" + m.getName());


	    }


	    @AfterMethod
	    public void getResult(ITestResult result)
	    {
	        if(result.getStatus() == ITestResult.FAILURE)
	        {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	        }
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }


	    @AfterSuite


	public void teardownReport() {
		
		extent.flush();


	}

}
