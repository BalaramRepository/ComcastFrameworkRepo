package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[@class='calAddButton']")
	private WebElement addBtn;

	@FindBy(id = "addcall")
	private WebElement addCallLink;

	@FindBy(id = "addtodo")
	private WebElement addToDoLink;

	@FindBy(linkText = "All Events & Todos")
	private WebElement allEventsAndToDoLink;

	public WebElement getAddCallLink() {
		return addCallLink;
	}

	public WebElement getAddToDoLink() {
		return addToDoLink;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getAllEventsAndToDoLink() {
		return allEventsAndToDoLink;
	}

}
