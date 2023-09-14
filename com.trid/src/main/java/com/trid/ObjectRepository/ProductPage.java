package com.trid.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trid.GenericUtilities.JavaUtilities;
import com.trid.GenericUtilities.WebUtilities;

public class ProductPage extends WebUtilities {

	//Declaration
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement addProductIcon;

	@FindBy(name="prodcode")
	private WebElement productCodeTxt;

	@FindBy(name="name")
	private WebElement productNameTxt;

	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptionTxt;

	@FindBy(name="quantity")
	private WebElement prodQuantityTxt;

	@FindBy(name="onhand")
	private WebElement prodOnhandTxt;

	@FindBy(name="category")
	private WebElement prodCategoryDrop;

	@FindBy(name="supplier")
	private WebElement supplierDrop;

	@FindBy (xpath="//input[@name='datestock']")
	private WebElement dateStockCal;

	@FindBy(xpath="//input[@name='datestock']/../following-sibling::button[1]")
	private WebElement saveBtn;

	@FindBy(xpath="//input[@name='datestock']/../following-sibling::button[text()='Cancel']")
	private WebElement cancelBtn;

	//Initialization
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getAddProductIcon() {
		return addProductIcon;
	}

	public WebElement getProductCodeTxt() {
		return productCodeTxt;
	}

	public WebElement getProductNameTxt() {
		return productNameTxt;
	}

	public WebElement getDescriptionTxt() {
		return descriptionTxt;
	}

	public WebElement getProdQuantityTxt() {
		return prodQuantityTxt;
	}

	public WebElement getProdOnhandTxt() {
		return prodOnhandTxt;
	}

	public WebElement getProdCategoryDrop() {
		return prodCategoryDrop;
	}

	public WebElement getSupplierDrop() {
		return supplierDrop;
	}

	public WebElement getDateStockCal() {
		return dateStockCal;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	//Business Libraries
	public void clickAddIcon() {
		addProductIcon.click();
	}
	public void clickSaveBtn() {
		saveBtn.click();
	}
	public void clickSupplierDrop() {
		supplierDrop.click();
	}
	public void addProduct(HashMap<String, String> map,WebDriver driver,String expectedData,String supplierName,String categoryName,String stockDate) {
		clickAddIcon();
		JavaUtilities jLib=new JavaUtilities();
		for (Entry<String, String> set: map.entrySet()) {

			if(set.getKey().contains(expectedData)){

				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNo());	
			}
			else {
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}
		fromDropDown(supplierName,supplierDrop );
		fromDropDown(categoryName,prodCategoryDrop);
		dateStockCal.click();
		dateStockCal.sendKeys(stockDate);
	}

	public void clickCancelBtn() {
		cancelBtn.click();
	}

	public void fromSupplierDropDown(String supplierName,WebDriver driver) {
		fromDropDown(supplierName,supplierDrop );
		driver.navigate().refresh();
		System.out.println("Supplier is present");
	}

	public void validateProductInPOS(WebDriver driver,String expected) {
		String numPath="//td[normalize-space()='Fantech EG1']";
		String actual = driver.findElement(By.xpath(numPath)).getText();
		Assert.assertEquals(actual,expected,"Product is not present");
		System.out.println("Product is present");
	}
}



