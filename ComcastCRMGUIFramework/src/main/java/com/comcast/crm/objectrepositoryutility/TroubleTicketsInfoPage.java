package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsInfoPage {

	public TroubleTicketsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	@FindBy(id = "mouseArea_Title")
	private WebElement titleInfo;

	@FindBy(xpath = "//td[text()='Contact Name']/following-sibling::td/a")
	private WebElement contactNameInfo;

	@FindBy(id = "mouseArea_Product Name")
	private WebElement productNameInfo;

	@FindBy(id = "dtlview_Status")
	private WebElement statusInfo;

	@FindBy(xpath = "//td[text()='Ticket No']/following-sibling::td")
	private WebElement ticketIdInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getTitleInfo() {
		return titleInfo;
	}

	public WebElement getContactNameInfo() {
		return contactNameInfo;
	}

	public WebElement getProductNameInfo() {
		return productNameInfo;
	}

	public WebElement getStatusInfo() {
		return statusInfo;
	}

	public WebElement getTicketIdInfo() {
		return ticketIdInfo;
	}

}
