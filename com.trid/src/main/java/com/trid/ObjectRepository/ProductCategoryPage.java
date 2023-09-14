package com.trid.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trid.GenericUtilities.WebUtilities;

public class ProductCategoryPage extends WebUtilities {

	//Declaration
	@FindBy(xpath="//a[contains(text(),'Keyboard')]")
	private WebElement keyboardLink;

	@FindBy(xpath="//a[contains(text(),'Mouse')]")
	private WebElement prodCategoryMouseLink;

	@FindBy(xpath="//a[contains(text(),'Headset')]")
	private WebElement prodCategoryHeadsetLink;

	@FindBy(xpath="//a[contains(text(),'CPU')]")
	private WebElement prodCategoryCPULink;

	@FindBy(xpath="//a[contains(text(),'Monitor')]")
	private WebElement prodCategoryMonitorLink;

	@FindBy(xpath="//a[contains(text(),'Motherboard')]")
	private WebElement prodCategoryMotherboardLink;

	@FindBy(xpath="//a[contains(text(),'Processor')]")      
	private WebElement prodCategoryProcessorLink;

	@FindBy(xpath="//a[contains(text(),'Power Supply')]")
	private WebElement prodCategoryPowersupplyLink;

	@FindBy(xpath="//a[contains(text(),'Others')]")
	private WebElement prodCategoryOthersLink;

	@FindBy(xpath="//div[@class='card-body col-md-3']")
	private WebElement submitBtn;	

	@FindBy(xpath="//div[@class='btn bg-gradient-danger btn-danger']")
	private WebElement deleteBtn;

	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement addCustomerIconBtn;

	@FindBy(xpath="//select[@name='customer']")
	private WebElement customerDropdown;

	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']//input[@placeholder='First Name']")
	private WebElement firstNameTxt;

	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']//input[@placeholder='Last Name']")
	private WebElement lastNameTxt;

	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']//input[@placeholder='Phone Number']")
	private WebElement phoneNumberTxt;

	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']//button[@type='submit'][normalize-space()='Save']")
	private WebElement customerSaveBtn;

	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']/descendant::button[@class='btn btn-danger']")
	private WebElement customerResetBtn;

	@FindBy(xpath="//form[@action='cust_pos_trans.php?action=add']/descendant::button[@class='btn btn-secondary']")
	private WebElement customerCancelBtn;

	//Initialization
	public ProductCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getKeyboardLink() {
		return keyboardLink;
	}
	public WebElement getProdCategoryMouseLink() {
		return prodCategoryMouseLink;
	}
	public WebElement getProdCategoryHeadsetLink() {
		return prodCategoryHeadsetLink;
	}
	public WebElement getProdCategoryCPULink() {
		return prodCategoryCPULink;
	}
	public WebElement getProdCategoryMonitorLink() {
		return prodCategoryMonitorLink;
	}
	public WebElement getProdCategoryMotherboardLink() {
		return prodCategoryMotherboardLink;
	}
	public WebElement getProdCategoryProcessorLink() {
		return prodCategoryProcessorLink;
	}
	public WebElement getProdCategoryPowersupplyLink() {
		return prodCategoryPowersupplyLink;
	}
	public WebElement getProdCategoryOthersLink() {
		return prodCategoryOthersLink;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	public WebElement getAddCustomerIconBtn() {
		return addCustomerIconBtn;
	}
	public WebElement getCustomerDropdown() {
		return customerDropdown;
	}
	public WebElement getFirstNameTxt() {
		return firstNameTxt;
	}
	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}
	public WebElement getPhoneNumberTxt() {
		return phoneNumberTxt;
	}

	//Business Libraries

	public void clickKeyboard() {
		keyboardLink.click();
	}
	public void clickOthers() {
		prodCategoryOthersLink.click();
	}
	public void clickCPU() {
		prodCategoryCPULink.click();
	}

	public void clickDelete() {
		deleteBtn.click();
	}

	public void addCustomer() {
		addCustomerIconBtn.click();
	}

	public void clickHeadset() {
		prodCategoryHeadsetLink.click();
	}

	public void addRequiredQuatity(WebDriver driver, String productName,String quantity) {
		String qty="//h6[text()='"+productName+"']/ancestor::div[@class='products']/descendant::input[@name='quantity']";
		driver.findElement(By.xpath(qty)).sendKeys(Keys.CONTROL+"a"+"delete");
		
		driver.findElement(By.xpath(qty)).sendKeys(quantity);
		driver.findElement(By.xpath("//h6[text()='"+productName+"']/ancestor::div[@class='products']/descendant::input[@name='addpos']")).click();
	}

	public void addCustomerDetails(WebDriver driver,HashMap<String, String> map,String expectedData,String productName,String quantity) {
		addRequiredQuatity(driver, productName, quantity);
		addCustomerIconBtn.click();
		//JavaUtilities jLib=new JavaUtilities();
		for (Entry<String, String> set: map.entrySet()) {

			if(set.getKey().contains(expectedData)){

				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());	
			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
			customerSaveBtn.click();
		}
		alertAccept(driver);
		
	}
	public void deleteProduct(WebDriver driver,String productName,String quantity) {
		addRequiredQuatity(driver, productName, quantity);
		deleteBtn.click();
	}
	
}