package com.CongaDemo.init;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.CongaDemo.tests.PrecticePage;
import com.utility.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Init {
	public WebDriver driver=null;
	public int steps = 0;
	public PrecticePage precticePage;
	public static int rowID;
	public String userName = "";
	public String password = "";
	public static int MAX_WAIT = 30;
	
	@BeforeTest
	public void setup(ITestContext test) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		steps = 1;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		readPropertyFile();
		driver.get("http://Automationpractice.com/");
		precticePage = new PrecticePage(driver);
	}

	@AfterMethod()
	public void tearDown(ITestResult testResult) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		if (!testResult.isSuccess()) {

			System.out.println("TEST FAILED - ");
			/* Make a screenshot for test that failed */
			String screenshotName = Common.getCurrentTimeStampString();
			Reporter.log("<br> <b>Please look to the screenshot - " + screenshotName + "</b>");
			Common.makeScreenshot(driver, screenshotName);

		} else {
			String screenshotName = Common.getCurrentTimeStampString();
			Reporter.log("<br> <b>Please look to the screenshot - " + screenshotName + "</b>");
			Common.makeScreenshot(driver, screenshotName);
			System.out.println("TEST PASSED - " + testResult.getName() + "\n");
			log("TEST PASSED - " + testResult.getName() + "\n");
		}

			driver.close();
			driver.quit();
	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg Message/Log to be reported.
	 */
	public static void log(String msg) {
		System.out.println(msg);
		Reporter.log("<br></br>" + msg);
	}

	public void readPropertyFile() throws IOException {
		FileReader reader = new FileReader("creds.properties");
		Properties p = new Properties();
		p.load(reader);
		userName = p.getProperty("username");
		password = p.getProperty("password");
	}
}
