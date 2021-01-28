package com.game.tv.utilities;
import static io.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.game.tv.pageobjects.BasePage;

public class Utilities extends BasePage {
	
	/**
	 * Return the status code.
	 * @param uri Uri to get status code.
	 * @return Status code of the uri.
	 */
	public int getStatusCode(String uri) {
		return given().get(uri).getStatusCode();
	}
	
	/**
	 * Return the current url of the page.
	 * @return
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * Return the text of webelement
	 * @param element : Webelement to get text.
	 * @return Text of the Webelement
	 */
	public String getWebElementText(WebElement element) {
		return element.getText();
	}
	
	/**
	 * Return the text of webelement
	 * @param by: By Locator
	 * @return Text of by locator
	 */
	public String getWebElementText(By by) {
		return getWebElement(by).getText();
	}
	
	/**
	 * Return the webelement using by.
	 * @param by
	 * @return
	 */
	public WebElement getWebElement(By by) {
		return driver.findElement(by);
	}
	
	/**
	 * Return the size of list of webelements
	 * @param by
	 * @return Size of list of by locators
	 */
	public int getWebelementCount(By by) {
		return driver.findElements(by).size();
	}
	
	/**
	 * Click on webelement
	 * @param by
	 */
	public void clickOnWebelemet(By by) {
		getWebElement(by).click();
	}
	
	/**
	 * Navigate back to page
	 */
	public void navigateBack() {
		driver.navigate().back();
	}

}
