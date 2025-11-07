package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method maximizes the window
	 * 
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will wait until the element loaded in WebPage (Implicit Wait)
	 * provided with driver and timeunits
	 * 
	 * @param driver
	 */
	public void toImplictlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * This method will wait until the element is clickable provided with driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait until the element is visible provided with driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */
	public void visibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method gives us the mechanism to take a screenshot of an entire webpage
	 * provided the screenshot name
	 * 
	 * @param driver
	 * @param fileName
	 * @throws IOException
	 */
	public void takeScreenshotOfWebPage(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/" + fileName+".png");
		FileHandler.copy(temp, src);
	}

	/**
	 * This method gives us the mechanism to take a screenshot of an webelement
	 * provided the screenshot name
	 * 
	 * @param driver
	 * @param element
	 * @param fileName
	 * @throws IOException
	 */
	public void takeScreenshotOfWebElement(WebDriver driver, WebElement element, String fileName) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/" + fileName);
		FileHandler.copy(temp, src);
	}

	/**
	 * This method gives us mechanism to handle dropdown using index provided with
	 * element
	 * 
	 * @param element
	 * @param index
	 */
	public void toSelect(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method gives us mechanism to handle dropdown using value provided with
	 * element
	 * 
	 * @param element
	 * @param value
	 */
	public void toSelect(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method gives us mechanism to handle dropdown using visible text provided
	 * with element
	 * 
	 * @param element
	 * @param visibleText
	 */
	public void toSelect(String visibleText, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to switch to frame using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toSwitchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to frame using id or name
	 * 
	 * @param driver
	 * @param index
	 */
	public void toSwitchToFrame(WebDriver driver, String name_id) {
		driver.switchTo().frame(name_id);
	}

	/**
	 * This method is used to switch to frame using element
	 * 
	 * @param driver
	 * @param index
	 */
	public void toSwitchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch back to main window
	 * 
	 * @param driver
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to switch to a new window provided partial Url
	 * 
	 * @param driver
	 * @param partialUrl
	 */
	public void toSwitchWindowWithURL(WebDriver driver, String partialUrl) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			driver.switchTo().window(id);
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.contains(partialUrl))
				break;
		}
	}

	/**
	 * This method is used to switch to a new window provided partial title
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void toSwitchWindowWitTitle(WebDriver driver, String partialTitle) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			driver.switchTo().window(id);
			String title = driver.getTitle();
			if (title.contains(partialTitle))
				break;
		}
	}

	/**
	 * This method is used to mouse hover to an element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform right click action provided element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This method is used to perform drag and drop action provided source and
	 * target elements
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void toDragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	/**
	 * This method is used to perform drag and drop action provided source and
	 * target coordinates
	 * 
	 * @param driver
	 * @param source
	 * @param x
	 * @param y
	 */
	public void toDragAndDrop(WebDriver driver, WebElement source, int x, int y) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(source, x, y).perform();
	}
}
