package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewDocumentPage {

	public CreatingNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "notes_title")
	private WebElement titleEdt;
	
	@FindBy(name = "filename")
	private WebElement fileUploadBtn;

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getFileUploadBtn() {
		return fileUploadBtn;
	}
	
}
