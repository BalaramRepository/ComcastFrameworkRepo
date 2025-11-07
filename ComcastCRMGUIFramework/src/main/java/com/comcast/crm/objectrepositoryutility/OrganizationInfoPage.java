package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameInfo;

	@FindBy(id = "dtlview_Industry")
	private WebElement industryNameInfo;

	@FindBy(id = "dtlview_Type")
	private WebElement typeInfo;

	@FindBy(xpath = "//td[text()='Organization No']/following-sibling::td")
	private WebElement orgIdInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}

	public WebElement getIndustryNameInfo() {
		return industryNameInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

	public WebElement getOrgIdInfo() {
		return orgIdInfo;
	}

}
