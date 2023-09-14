package com.trid.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
	
	@FindBy(xpath="//span[contains(text(),'Customer')]")
	private WebElement customerLink;
	
	@FindBy(xpath="//span[contains(text(),'Employee')]")
	private WebElement employeeLink;
	
	@FindBy (xpath="//span[contains(text(),'Product')]")
	private WebElement productLink;
	
	@FindBy (xpath="//span[contains(text(),'Inventory')]")
	private WebElement inventoryLink;
	
	@FindBy (xpath="//span[contains(text(),'Transaction')]")
    private WebElement transactionLink;
	
	@FindBy (xpath="//span[contains(text(),'Supplier')]")
	private WebElement supplierLink;
	
	@FindBy (xpath="//span[contains(text(),'Accounts')]")
	private WebElement accountsLink;

	@FindBy(xpath="//img[@class='img-profile rounded-circle']")
	private WebElement lookUpImageLogout;
	
	@FindBy(xpath="//a[@data-target='#logoutModal']")
	private WebElement logoutBtn;
	
	@FindBy (xpath="//div[@aria-modal='true']/descendant::a")
	private WebElement logoutAlertBtn;
	
	@FindBy(xpath="//span[contains(text(),'POS')]")
	private WebElement posBtn;
	
	
	//Initialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getCustomerLink() {
		return customerLink;
	}

	public WebElement getEmployeeLink() {
		return employeeLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getInventoryLink() {
		return inventoryLink;
	}

	public WebElement getTransactionLink() {
		return transactionLink;
	}

	public WebElement getSupplierLink() {
		return supplierLink;
	}

	public WebElement getAccountsLink() {
		return accountsLink;
	}
	
	
	public WebElement getLookUpImageLogout() {
		return lookUpImageLogout;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getLogoutAlertBtn() {
		return logoutAlertBtn;
	}

	//Business Library
	public void clickCustomer() {
		customerLink.click();
	}
	
	public void clickEmployee() {
		employeeLink.click();
	}
	
	public void clickProduct() {
		productLink.click();
	}

	public void clickInventory() {
		inventoryLink.click();
	}
	
	public void clickTransaction() {
		transactionLink.click();
	}
	public void clickSupplier() {
		supplierLink.click();
	}
	public void clickAccount() {
		accountsLink.click();
	}
	
	public WebElement getPosBtn() {
		return posBtn;
	}

	public void logout(WebDriver driver) {
		//WebUtilities wu=new WebUtilities();
		lookUpImageLogout.click();
		logoutBtn.click();
		logoutAlertBtn.click();
	}
	
	public void clickPOSBtn() {
		posBtn.click();
	}
}
