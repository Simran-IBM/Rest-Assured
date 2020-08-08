package testAssured.Listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;		
import org.testng.ITestListener;		
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;

import testAssured.ExtentReportHelper.ExtentManager;
import testAssured.ExtentReportHelper.ExtentTestManager;

public class ListenerTest implements ITestListener{
	
	public static final Logger log = Logger.getLogger(ListenerTest.class.getName());

	public void onTestStart(ITestResult result) {
		log.info(result.getName()+" test case started");
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("The name of the testcase passed is :"+result.getName());
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		log.info(("The name of the testcase Failed is :"+result.getName()));
		ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		log.info("The name of the testcase Skipped is :"+result.getName());
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		
	}

}

