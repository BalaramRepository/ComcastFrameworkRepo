package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEventPage {

	public AddEventPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement eventNameEdt;

	@FindBy(name = "date_start")
	private WebElement startDateEdt;

	@FindBy(id = "starthr")
	private WebElement startHrEdt;

	@FindBy(id = "startmin")
	private WebElement startMinEdt;

	@FindBy(name = "due_date")
	private WebElement endDateEdt;

	@FindBy(id = "endhr")
	private WebElement endHrEdt;

	@FindBy(id = "endmin")
	private WebElement endMinEdt;

	@FindBy(name = "eventsave")
	private WebElement saveBtn;

	public WebElement getEventNameEdt() {
		return eventNameEdt;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getStartHrEdt() {
		return startHrEdt;
	}

	public WebElement getStartMinEdt() {
		return startMinEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getEndHrEdt() {
		return endHrEdt;
	}

	public WebElement getEndMinEdt() {
		return endMinEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
