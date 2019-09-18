package com.qwic.buyacar.common;

import java.io.IOException;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class commonActions {
	
	  public WebDriver driver;
    public ExtentTest test;
    public ExtentReports extent;
    public ExtentHtmlReporter htmlReporter;
    public WebDriverWait wait;
    private static Properties prop = readConfigProperties.getProperties();
    public final static String URL = prop.getProperty("url");


    @BeforeTest
    public void beforeTest() throws  Exception{

        //Prepare Report Data

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/BuyACarTestReport.html");
        htmlReporter.config().setDocumentTitle("DoD Trigger Tool Test Report");
        htmlReporter.config().setReportName("Functional Test Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //Prepare Tester Data
        extent.setSystemInfo("Tester Name", "Kirti Nair");
        extent.setSystemInfo("Browser", "Mozilla Firefox");
        
    }
    
    @BeforeMethod
    public void beforeMethod() {
        //Open the website url
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get(URL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='searchBoxTitle' and text()='Buy a car']")));

    }

    public void tearDown(ITestResult result) throws IOException, InterruptedException {
        driver.quit();

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
            test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

            String screenshotPath = ScreenshotUtil.getScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
            Thread.sleep(1000);
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
            Thread.sleep(1000);
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());

            String screenshotPath = ScreenshotUtil.getScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
            Thread.sleep(1000);
        }
    }

    @AfterTest
    public void afterTest() throws InterruptedException {

        extent.flush();
    }

    

}
