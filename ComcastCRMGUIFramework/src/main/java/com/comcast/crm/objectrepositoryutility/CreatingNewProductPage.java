package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {

	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement productNameEdt;

	@FindBy(name = "sales_start_date")
	private WebElement salesStartDateEdt;

	@FindBy(name = "sales_end_date")
	private WebElement salesEndDateEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement selectVendorBtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getSalesStartDateEdt() {
		return salesStartDateEdt;
	}

	public WebElement getSalesEndDateEdt() {
		return salesEndDateEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSelectVendorBtn() {
		return selectVendorBtn;
	}

}
