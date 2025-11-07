package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewTicketPage {

	public CreatingNewTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "ticket_title")
	private WebElement titleEdt;

	@FindBy(xpath = "//input[@id='parentid']/following-sibling::img")
	private WebElement selectContactImg;

	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img")
	private WebElement selectProductImg;

	@FindBy(name = "ticketstatus")
	private WebElement statusDD;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getSelectContactImg() {
		return selectContactImg;
	}

	public WebElement getSelectProductImg() {
		return selectProductImg;
	}

	public WebElement getStatusDD() {
		return statusDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
