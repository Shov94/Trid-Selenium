package com.trid.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountsPage {
	
	//Declaration
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement addAccountIcon;
	
	@FindBy(name="empid")
	private WebElement employeeDrop;
	
	@FindBy(xpath="//h5[text()='Add User Account']")
	private WebElement messageAddUser;
	
	//Initialization
	
	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getAddAccountIcon() {
		return addAccountIcon;
	}


	public WebElement getEmployeeDrop() {
		return employeeDrop;
	}
	
	//Business Libraries
	public void clickAddLookup() {
		addAccountIcon.click();
	}

	public void validateMessage(String expected) {
		String actual=messageAddUser.getAttribute("innerHTML");
		Assert.assertEquals(actual, expected,"Add User Account Pop-up is not Present");
		System.out.println("Present");
	}
	
}
