package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateToDoPage {

	public CreateToDoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "task_subject")
	private WebElement todoNameEdt;

	@FindBy(id = "task_date_start")
	private WebElement startDateEdt;

	@FindBy(id = "starthr")
	private WebElement startHrEdt;

	@FindBy(id = "startmin")
	private WebElement startMinEdt;

	@FindBy(id = "task_due_date")
	private WebElement endDateEdt;

	@FindBy(name = "todosave")
	private WebElement saveBtn;

	public WebElement getTodoNameEdt() {
		return todoNameEdt;
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

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
