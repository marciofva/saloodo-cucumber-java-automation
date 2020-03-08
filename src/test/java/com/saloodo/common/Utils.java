package com.saloodo.common;

import java.math.BigInteger;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {
	
	
	public static String generateEmail() {
		Random random = new Random();
        return new BigInteger(50, random).toString(32) + "@gmail.com";
	}
	
	
	public static String generateVATID() {
		long vatId = 100000000 + new Random().nextInt(200000000);
		return "GB".concat(String.valueOf(vatId));
	}
	
	
	public static String generatePassword() {
		String password = RandomStringUtils.randomAlphabetic(4).toLowerCase() + 
						  RandomStringUtils.randomNumeric(3) +
						  RandomStringUtils.randomAlphabetic(1).toUpperCase() +
						  "?";
		return password;
	}
	
	
	public static WebDriver chooseBrowser() {
		String browser = System.getProperty("browser");
		
		if (browser == null || browser.equalsIgnoreCase("chrome")) {
    		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    		
    		ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--dns-prefetch-disable");
            chromeOptions.addArguments("--disable-gpu");
            return new ChromeDriver(chromeOptions);
		}else {
        	return new FirefoxDriver();
		}
	}
}
