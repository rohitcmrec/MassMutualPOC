package com.massmutual.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	
	private WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public int getElementsSize(By locator) {
		return getElements(locator).size();
	}
	
	public String getElementText(By locator) {
		return getElement(locator).getText();
		
	}
	
	public List<String> getElementsText(By locator) {
		List<WebElement>elementsList = getElements(locator);
		List<String> elementsListText = new ArrayList<String>();
		for(WebElement e: elementsList) {
			elementsListText.add(e.getText());
		}
		
		return elementsListText;
	}
	


}
