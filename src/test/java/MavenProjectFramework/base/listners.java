package MavenProjectFramework.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MavenProjectFramework.pro.ExtentReportUtility;

public class listners extends BaseTest1 implements ITestListener{

	
	ExtentTest et;
	ExtentReports exr=ExtentReportUtility.ReportMethod();
	ThreadLocal<ExtentTest> s=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		
		 et=exr.createTest(result.getName());
		 s.set(et);
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		s.get().log(Status.FAIL, "test case failed for this value");
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String f = null;
		try {
		 f=	screenshottaking(result.getName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.get().addScreenCaptureFromPath(f, result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		/*s.get().log(Status.PASS, "test case passed for this value");
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String f = null;
		try {
		 f=	screenshottaking(result.getName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.get().addScreenCaptureFromPath(f, result.getName());*/
		
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		s.get().log(Status.SKIP, "test case failed for this value");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		exr.flush();
	}

}
