package com.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

	public static String takeScreenshot(String scenarioName) {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

		String filePath = "screenshots/" + scenarioName + "_" + timestamp + ".png";
		File destFile = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			destFile = new File(filePath);

			destFile.getParentFile().mkdirs();

			FileHandler.copy(srcFile, destFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return destFile.getName();
	}
}
