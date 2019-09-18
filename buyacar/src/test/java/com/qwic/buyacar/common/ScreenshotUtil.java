package com.qwic.buyacar.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.OutputType;

public class ScreenshotUtil {
	
	 public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);

	        String destination = System.getProperty("user.dir") + "/Screenshots" + screenshotName + ".png";
	        File finalDestination = new File (destination);
	        FileUtils.copyFile(source,finalDestination);
	        return destination;
	    }
	    	
}
