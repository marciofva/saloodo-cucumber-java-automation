package com.saloodo.factory;

import org.openqa.selenium.WebDriver;
import com.saloodo.common.URL;
import com.saloodo.common.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public static void setup() {		
		driver = Utils.chooseBrowser();
        driver.manage().window().maximize();
		driver.get(URL.BASE_URL.getValue());
	}
	
	@After
	public static void tearDown() {
	    if (driver != null) {
	        driver.quit();
	      }
	}
}
