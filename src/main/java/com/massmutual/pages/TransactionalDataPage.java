package com.massmutual.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.massmutual.utils.ElementUtils;

public class TransactionalDataPage {

	// By locators
	private WebDriver driver;
	private ElementUtils elementutils;
	private By lable1 = By.id("lbl_val_1");
	private By lables = By.xpath("//*[contains(@id='lbl_val')");
	private By values = By.xpath("//*[contains(@id='txt_val')");
	private By total_balance_lable = By.id("lbl_ttl_val");
	private By total_balance_value = By.id("txt_ttl_val");

	// constructor of the page class
	public TransactionalDataPage(WebDriver driver) {
		this.driver=driver;
		elementutils = new ElementUtils(this.driver);

	}

	//page actions
	
	public String getPageTitle() {
		return elementutils.getPageTitle();
	}
	public int getValuesCount() {
		return elementutils.getElementsSize(values);
	}
	
	public boolean isTotalBalanceDisplayed (){
		return elementutils.isElementDisplayed(total_balance_value);
	}
	
	public boolean isFirstLableDisplayed (){
		return elementutils.isElementDisplayed(lable1);
	}
	

	public int getLablesCount() {
		return elementutils.getElementsSize(lables);
	}

	/**
	 * to check if all the values are greater than 0
	 * @return
	 */
	public boolean rangeOfVlaues() {
		boolean status = true;
		List<String> valueList= elementutils.getElementsText(values);
		valueList.add(elementutils.getElementText(total_balance_value));
		try {
		for(String e: valueList) {
			String value = e.replace("$", "");
			if(Double.parseDouble(value)<0) {
				status = false;
			}
		}
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	/**
	 * to check if the total balance is equal to sum of all the values
	 * @return
	 */
	public boolean verifyTotalBalance() {
		String total = elementutils.getElementText(total_balance_value);
		double total_value = Double.parseDouble(total);
		List<String>valueList = elementutils.getElementsText(values);
		double sum = 0;
		try {
		for(String e:valueList) {
			String value = e.replace("$", "");
			sum = sum +Double.parseDouble(value);
		}
		}
		catch(ArithmeticException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		if(sum == total_value) { 
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * to check if the string contains $ with a decimal thereby certifying it is in a currency format
	 * @return
	 */
	public boolean verify$CurrencyFormat() {
		boolean status = true;
		List<String>valueList = elementutils.getElementsText(total_balance_value);
		for(String e:valueList) {
			if(!e.contains("$")) {
				status = false;
			}
		}
		return status;
	}
	public boolean verifyDecimalCurrencyFormat() {
		boolean status = true;
		List<String>valueList = elementutils.getElementsText(total_balance_value);
		for(String e:valueList) {
			if(!e.contains(".")) {
				status = false;
			}
		}
		return status;
	}

}



