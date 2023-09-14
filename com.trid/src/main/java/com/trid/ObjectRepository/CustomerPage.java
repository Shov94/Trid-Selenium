package com.trid.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage {

	//Declaration
	
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement addCustomerIcon;
	
	@FindBy(name="firstname")
	private WebElement customerFirstnameTxt;
	
	@FindBy(name="lastname")
	private WebElement customerLastnameTxt;
	
	@FindBy(name="phonenumber")
	private WebElement customerPhonenumberTxt;
	
	@FindBy(xpath="(//button[@class='btn btn-success'])[1]")
	private WebElement customerSaveBtn;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchCustomerTxt;

	//Initialization

	public CustomerPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getAddCustomerIcon() {
		return addCustomerIcon;
	}

	public WebElement getCustomerFirstnameTxt() {
		return customerFirstnameTxt;
	}

	public WebElement getCustomerLastnameTxt() {
		return customerLastnameTxt;
	}

	public WebElement getCustomerPhonenumberTxt() {
		return customerPhonenumberTxt;
	}
	
	public WebElement getCustomerSaveBtn() {
		return customerSaveBtn;
	}

	public WebElement getSearchCustomerTxt() {
		return searchCustomerTxt;
	}

	//Business Libraries
	public void searchCustomer(String customerName) {
		searchCustomerTxt.sendKeys(customerName);
	
	}
	
	public void validateCustomerName(WebDriver driver,String expectedName) {
		String actualName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals(actualName, expectedName,"Customer name not displayed");
        System.out.println("Customer name displayed");
	
	}
}
