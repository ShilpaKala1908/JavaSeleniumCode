package MavenProjectFramework.pro;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	public static ExtentReports ReportMethod() {
		String s=System.getProperty("user.dir")+"\\reports\\indexreport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(s);
		reporter.config().setReportName("Automation report name");
		reporter.config().setDocumentTitle("Automation documnet name");
		ExtentReports ex=new ExtentReports();
		ex.attachReporter(reporter);
		ex.setSystemInfo("Tester", "Shilpa Kala Konda");
		return ex;
	}

}
