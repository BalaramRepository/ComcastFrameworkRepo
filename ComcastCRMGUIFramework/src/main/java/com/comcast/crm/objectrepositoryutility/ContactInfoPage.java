package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastnameInfo;

	@FindBy(id = "mouseArea_Mobile")
	private WebElement mobileInfo;

	@FindBy(xpath = "//td[text()='Contact Id']/following-sibling::td")
	private WebElement contactIdInfo;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getLastnameInfo() {
		return lastnameInfo;
	}

	public WebElement getMobileInfo() {
		return mobileInfo;
	}

	public WebElement getContactIdInfo() {
		return contactIdInfo;
	}
	
	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}

}
