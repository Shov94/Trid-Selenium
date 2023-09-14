package com.trid.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//Execution Start
		String method = result.getMethod().getMethodName();
		test=report.createTest(method);
		Reporter.log(method+"----------Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String method = result.getMethod().getMethodName();
		test.log(Status.PASS, method+"----------PASS");
		Reporter.log(method+"--------Testscript passed ");
		
	}

	public void onTestFailure(ITestResult result) {
		String method = result.getMethod().getMethodName();
		String abc = method+new JavaUtilities().getSimpleDateFormat();
//		EventFiringWebDriver efdriver=new EventFiringWebDriver(BaseClass.driver);
//		File source=efdriver.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./Screenshots/"+abc+".png");
		
		try {
			String failedscript = WebUtilities.getScreenshot(BaseClass.edriver, abc);
			test.addScreenCaptureFromPath(failedscript);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL,result.getThrowable());
		test.log(Status.FAIL,method+"----------Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		String method = result.getMethod().getMethodName();
		test.log(Status.SKIP,method+"----------Skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(method+"-----------------Skipped");
		
	}

	public void onStart(ITestContext context) {
		//Create the HTML Report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReports/report.html");
		htmlreport.config().setDocumentTitle("Sales and Inventory");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Trid");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Url", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		report.setSystemInfo("Reporter Name", "Shobhan");
	}

	public void onFinish(ITestContext context) {
		//Consolidate the report
		report.flush();
	}
	
	

}
