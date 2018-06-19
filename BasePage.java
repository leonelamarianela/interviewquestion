package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class BasePage {

	//Method to navigate to url
	public void navigateToUrl(String url) {
		SharedSD.getDriver().navigate().to(url);
	}

	public void clickOn(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}


	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	// Method to send input
	public void sendInput(By locator, String string) {
		SharedSD.getDriver().findElement(locator).sendKeys(string);
	}


	// Method to select from a dropdown box
	public void selectDropDown(By locator, String string) {
		Select dropdown = new Select(SharedSD.getDriver().findElement(locator));
		dropdown.selectByVisibleText(string);
	}

	//    Method to select from a dropdown box by index
	public void selectDropDownByIndex(By locator, int index) {
		Select dropdown = new Select(SharedSD.getDriver().findElement(locator));
		dropdown.selectByIndex(index);
	}

    // get text from element
	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public void clickOnBrowserBackArrow() {

		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {

		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {

		SharedSD.getDriver().navigate().refresh();
	}


	public void isSelected(By locator) {
		boolean result = SharedSD.getDriver().findElement(locator).isSelected();
		System.out.println("Element is selected: " + result);
	}

	public void isDisplayed(By locator) {
		boolean result = SharedSD.getDriver().findElement(locator).isDisplayed();
		System.out.println("Element is displayed: " + result);
	}


	public void isEnabled(By locator) {
		boolean result = SharedSD.getDriver().findElement(locator).isEnabled();
		System.out.println("Element is enabled: " + result);
	}

	public void selectFromCalendar(By locator, String string) {
		WebElement dates = SharedSD.getDriver().findElement(locator);
		List<WebElement> listOfDates = dates.findElements(locator);
	}

	//    Method to select window by index
	public void selectWindow(int index) {
		List<String> listOfWindows = new ArrayList<>(SharedSD.getDriver().getWindowHandles());
		SharedSD.getDriver().switchTo().window(listOfWindows.get(index));
	}

	//    Method to select root window
	public void selectRootWindow() {
		List<String> listOfWindows = new ArrayList<>(SharedSD.getDriver().getWindowHandles());
		SharedSD.getDriver().switchTo().window(listOfWindows.get(0));
	}

	//    Method to close all windows and switch to root window
	public void closeAllAndSwitchToRoot() {
		List<String> listOfWindows = new ArrayList<>(SharedSD.getDriver().getWindowHandles());
		for (int i = 1; i < listOfWindows.size(); i++) {
			SharedSD.getDriver().switchTo().window(listOfWindows.get(i));
			SharedSD.getDriver().close();
		}
		SharedSD.getDriver().switchTo().window(listOfWindows.get(0));
	}

	public static void mouseOver(By locator) throws InterruptedException {
		WebElement element = SharedSD.getDriver().findElement(locator);

		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
	}

	public void switchToFrame(String string) {
		SharedSD.getDriver().switchTo().frame(string);
	}

	// ACCEPT alert
	public void acceptAlert() {
		SharedSD.getDriver().switchTo().alert().accept();
	}

	public void dismissAlert() {
		SharedSD.getDriver().switchTo().alert().dismiss();
	}

	public void sendInputToAlert(String string) {
		SharedSD.getDriver().switchTo().alert().sendKeys(string);
	}

	//    Click element from auto complete dropdown
	public void clickFromAutoCompleteByText(By locator, String string) throws InterruptedException {
		List<WebElement> elements = SharedSD.getDriver().findElements(locator);
		for (WebElement s1 : elements) {
			if (s1.getText().contains(string)) {
				s1.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

	public void selectTomorrowDate (){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1); // to get tomorrows day
		Date day = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		String tomorrow = sdf.format(day.getTime());
		return;


	}

	public void daysToBeBooked (){
		Calendar chkout = Calendar.getInstance();
		chkout.add(Calendar.DAY_OF_YEAR, 7);
		Date plus6days = chkout.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		String sixNights = sdf.format(plus6days.getTime());
		return ;

	}
}

