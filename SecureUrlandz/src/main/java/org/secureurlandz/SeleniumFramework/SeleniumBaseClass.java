package org.secureurlandz.SeleniumFramework;


import EnumBase.browser;
import EnumBase.locators;
import org.openqa.selenium.WebElement;



public interface SeleniumBaseClass {



	/**
	 * This method will launch the chrome browser with the given URL
	 * @author- Pradheep
	 * @param url
	 * @exception NullPointerException, InvalidArgumentException
	 */

	void setUp(String url);

	/**
	 * This method will launch the given browser with the given URL
	 * @author LetCode - Pradheep
	 * @param url
	 * @param browserName
	 */

	void setUp(browser browserName, String url);

	/**
	 *	This function is used to close the active browser
	 * 	@author LetCode - Pradheep
	 *
	 */
	void close();

	/**
	 *	This function is used to quit the driver instance
	 * 	@author LetCode - Pradheep
	 *
	 */
	void quit();

	/**
	 * This method is used to find any webelement with in the page
	 * @author LetCode - Pradheep
	 * @param type - element type eg - id, name or linkText
	 * @param value - element value
	 * @return WebElement
	 */

	WebElement element(locators type, String value);

	/**
	 * This function is used to switch to specific tab
	 * @author LetCode - Pradheep
	 * @param i
	 */
	
	void switchToWindow(int i);

	/**
	 * This function is used to select the dropdown with the given value
	 * @author LetCode - Pradheep
	 * @param ele
	 * @param value
	 */

	void selectValue(WebElement ele, String value);


	/**
	 * This function is used to select the dropdown with the given text
	 * @author LetCode - Pradheep
	 * @param ele
	 * @param text
	 */

	void selectText(WebElement ele, String text);

	/**
	 * This function is used to select the dropdown with the given index
	 * @author LetCode - Pradheep
	 * @param ele
	 * @param position
	 */
	void selectIndex(WebElement ele, int position);
	
	/**
	 * This function will wait until the element is clickable and then click
	 * @param ele
	 */

	void click(WebElement ele);
	
	/**
	 * This function will wait until the element is ready and clear the existing value and type
	 * @param ele
	 */
	
	void type(WebElement ele, String testData);
	
	/**
	 * This function will wait until the element is ready and gets the input
	 * @param ele
	 */
	
	void appendText(WebElement ele, String testData);
	
	/**	
	 * This function return the active page title
	 * @return String
	 */

	String getTitle();

	/**	
	 * This function return the active page URL
	 * @return String
	 */
	
	String getURL();
	
	/**	
	 * This function return the element is visible or not
	 * @return boolean
	 */

	boolean isDisplayed(WebElement ele);
     /**	
	 * This function return the element is Button is enable or not
	 * @return boolean
	 */
    boolean isEnabled( WebElement ele);

     /**	
	 * This function return the element is visible or not
	 * @return boolean
	 */

    boolean isSelected(WebElement ele);
}
    

