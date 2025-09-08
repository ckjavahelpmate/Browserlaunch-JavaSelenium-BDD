package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

	public static byte[] takeScreenshot() {

		TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
		return ts.getScreenshotAs(OutputType.BYTES);

	}
}
