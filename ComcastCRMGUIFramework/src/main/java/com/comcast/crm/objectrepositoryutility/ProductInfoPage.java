package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerInfo;

	@FindBy(id = "mouseArea_Product Name")
	private WebElement productNameInfo;

	@FindBy(xpath = "//td[text()='Product No']/following-sibling::td")
	private WebElement productIdInfo;

	@FindBy(id = "mouseArea_Sales Start Date")
	private WebElement salesStartDateInfo;

	@FindBy(id = "mouseArea_Sales End Date")
	private WebElement salesEndDateInfo;
	
	@FindBy(id = "mouseArea_Vendor Name")
	private WebElement vendorNameInfo;

	public WebElement getVendorNameInfo() {
		return vendorNameInfo;
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getProductNameInfo() {
		return productNameInfo;
	}

	public WebElement getProductIdInfo() {
		return productIdInfo;
	}

	public WebElement getSalesStartDateInfo() {
		return salesStartDateInfo;
	}

	public WebElement getSalesEndDateInfo() {
		return salesEndDateInfo;
	}

}
