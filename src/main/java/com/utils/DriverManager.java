package com.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void launchBrowser(WebDriver driver) {
        drivers.set(driver);
        drivers.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void closeBrowser() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.remove(); 
        }
    }
	

}
