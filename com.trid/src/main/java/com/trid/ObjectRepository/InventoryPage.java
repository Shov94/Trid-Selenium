package com.trid.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	//Declaration
	@FindBy(xpath="//input[@type='search']")
	private WebElement inventorySearchTxt;
	
	@FindBy(xpath="//a[contains(text(),'Next')]")
	private WebElement nextBtn;
	
	//Initialization
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getInventorySearchTxt() {
		return inventorySearchTxt;
	}


	public WebElement getNextBtn() {
		return nextBtn;
	}
	

	//Business Libraries
	
	public void searchInventory(String productName) {
		inventorySearchTxt.sendKeys(productName);
	}
	
	
}
