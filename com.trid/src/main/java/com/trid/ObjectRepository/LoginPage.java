package com.trid.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.WebUtilities;

public class LoginPage {


	//Declaration
	@FindBy (xpath="//input[@placeholder='Username']")
	private WebElement userNameTxt;

	@FindBy (xpath="//input[@placeholder='Password']")
	private WebElement passWordTxt;

	@FindBy (xpath="//button[text()='Login']")
	private 	WebElement loginBtn;

	//Initialization
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

		//Utilization

	}

	public WebElement getUserNameTextF() {
		return userNameTxt;
	}

	public WebElement getPassWordTextF() {
		return passWordTxt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//Business Library
	

	public void loginAsAdmin(WebDriver driver) throws Throwable {
		FileUtilities fl=new FileUtilities();
		WebUtilities wLib= new WebUtilities();
		
		String USERNAME=fl.readDataFromPropertyFile("username");
		String PASSWORD=fl.readDataFromPropertyFile("password");
		userNameTxt.sendKeys(USERNAME);
		passWordTxt.sendKeys(PASSWORD);
		loginBtn.click();
		wLib.alertAccept(driver);
	
	}
	
	public void loginAsUser(WebDriver driver) throws Throwable {
		FileUtilities fl=new FileUtilities();
		WebUtilities wLib= new WebUtilities();
		String USERNAME=fl.readDataFromPropertyFile("user");
		String PASSWORD=fl.readDataFromPropertyFile("pass");
		userNameTxt.sendKeys(USERNAME);
		passWordTxt.sendKeys(PASSWORD);
		loginBtn.click();
		wLib.alertAccept(driver);
	}

}




