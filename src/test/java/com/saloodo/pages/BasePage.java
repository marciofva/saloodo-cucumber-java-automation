package com.saloodo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;
	protected static final int MAX_SECONDS_TIMEOUT = 40;
	protected WebDriverWait wait;

	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, MAX_SECONDS_TIMEOUT);
	}
	
	
	protected void clickOn(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	protected void sendValue(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}
	
	
	public boolean waitForTitle(String title) {
		return wait.until(ExpectedConditions.titleIs(title));
	}
	
	
	protected String getText(WebElement element) {
		this.wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	
	protected void waitForElementVisibility(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
