package com.trid.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trid.GenericUtilities.WebUtilities;

public class SupplierPage extends WebUtilities {

	//Declaration
	@FindBy (xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement addSupplierIcon;

	@FindBy(name="companyname")
	private WebElement companyNameTxt;

	@FindBy (name="phonenumber")
	private WebElement phoneNumberTxt;

	@FindBy(id="province")
	private WebElement provinceDrop;

	@FindBy(id="city")
	private WebElement cityDrop;
	
	@FindBy(xpath="//div[@class='modal fade show']//div/following-sibling::button[@class='btn btn-success']")
	private WebElement saveBtn;

	@FindBy(xpath="//div[@class='modal fade show']//div/following-sibling::button[@class='btn btn-danger']")
	private WebElement resetBtn;
	
	@FindBy(xpath="//div[@class='modal fade show']//div/following-sibling::button[@class='btn btn-secondary']")
	private WebElement cancelBtn;
	//Initialization
	public SupplierPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getAddSupplierIcon() {
		return addSupplierIcon;
	}

	public WebElement getCompanyNameTxt() {
		return companyNameTxt;
	}

	public WebElement getPhoneNumberTxt() {
		return phoneNumberTxt;
	}

	public WebElement getProvinceDrop() {
		return provinceDrop;
	}

	public WebElement getCityDrop() {
		return cityDrop;
	}

	//Business Libraries
	public void clickAddSupplier() {
		addSupplierIcon.click();
	}
	public void addSupplier(WebDriver driver,HashMap<String, String> map,String province,String city,String expectedData) {
		clickAddSupplier();
		//JavaUtilities jLib=new JavaUtilities();
		for (Entry<String, String> set: map.entrySet()) {

			if(set.getKey().contains(expectedData)){

				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());	
			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}
		fromDropDown(province,provinceDrop);
		fromDropDown(city, cityDrop);
		saveBtn.click();	
	}
	public void clickReset() {
		resetBtn.click();
	}
	
	public void clickCancel() {
		cancelBtn.click();
	}
	
	public void validateSupplier(WebDriver driver,String expected) {
		String actual=driver.findElement(By.xpath("//h4[contains(text(),'Supplier')]")).getText();
	
		Assert.assertEquals(actual,expected,"Supplier page not displayed");
	
		System.out.println("Supplier page displayed");
	
	
	
	}
}
