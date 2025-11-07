package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnameEdt;

	@FindBy(id = "mobile")
	private WebElement mobileEdt;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgBtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getMobileEdt() {
		return mobileEdt;
	}

	public WebElement getSelectOrgBtn() {
		return selectOrgBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
