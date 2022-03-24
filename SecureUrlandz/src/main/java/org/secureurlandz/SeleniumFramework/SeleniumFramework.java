package org.secureurlandz.SeleniumFramework;



import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import EnumBase.browser;
import EnumBase.locators;



public  class SeleniumFramework implements SeleniumBaseClass {

	long timeOuts = 30;
	long maxWaitTime = 10;

	public static ExtentReports extent;
	public static ExtentTest test;

	String desc = "";
	String author = "";
	String category = "";
	String Os = "";


	protected static RemoteWebDriver driver = null;
	WebDriverWait wait = null;


	public void setUp(String url) {
		//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		driver.get(url);
		wait = new WebDriverWait(driver, maxWaitTime);


	}


	public void setUp(browser browserName, String url) {

		switch (browserName) {

			case CHROME:
				driver = new ChromeDriver();
				break;

			case FIREFOX:
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
				driver.get(url);
				wait = new WebDriverWait(driver, maxWaitTime);
				break;
			case EDGE:
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
				driver.get(url);
				wait = new WebDriverWait(driver, maxWaitTime);
				break;

			default:
				System.out.println(" Browser is not defind");
				break;
		}
		//   System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","E:\\Pradheep\\Projects\\HRMS Project\\automation\\test_hrms\\Drivers\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		driver.get(url);
		wait = new WebDriverWait(driver, maxWaitTime);

	}


	public void close() {

		driver.close();
	}


	public void quit() {
		driver.quit();

	}


	public WebElement element(locators type, String value) {


		try {
			switch (type) {
				case id:
					return driver.findElement(By.id(value));
				case name:
					return driver.findElement(By.name(value));

				case className:
					return driver.findElement(By.className(value));
				case link:
					return driver.findElement(By.linkText(value));

				case PartialLinktext:
					return driver.findElement(By.partialLinkText(value));

				case xpath:
					return driver.findElement(By.xpath(value));

				case css:
					return driver.findElement(By.cssSelector(value));
				default:
					break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element Not found=>" + e.getMessage());
			throw new NoSuchElementException("Element Not Found");
		} catch (WebDriverException e) {
			System.err.println(e.getMessage());
			throw new WebDriverException("This Unkown Error");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			// throw new Exception("this is unkown error");
		}


		return null;
	}

	//window Switch
	public void switchToWindow(int i) {

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(i));
	}


	// dropdown Methods

	public void selectValue(WebElement ele, String value) {

		try {
			WebElement element = isElementVisible(ele);
			new Select(element).selectByValue(value);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		} catch (WebDriverException e) {
			System.err.println(e.getMessage());
		}

	}


	public void selectText(WebElement ele, String text) {
		try {
			WebElement element = isElementVisible(ele);
			new Select(element).selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		} catch (WebDriverException e) {
			System.err.println(e.getMessage());
		}

	}


	public void selectIndex(WebElement ele, int position) {
		try {
			WebElement element = isElementVisible(ele);
			new Select(element).selectByIndex(position);


		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		} catch (WebDriverException e) {
			System.err.println(e.getMessage());
		}

	}

	//

	public void click(WebElement ele) {

		WebElement element = wait.withMessage("element not clickable")
				.until(ExpectedConditions.elementToBeClickable(ele));
		element.click();
	}


	public void type(WebElement ele, String testData) {
		try {
			WebElement element = isElementVisible(ele);
			element.clear();
			element.sendKeys(testData);
		} catch (NullPointerException e) {
			System.err.println("Nullpointer=>" + e.getMessage());

		} catch (WebDriverException e) {
			System.err.println(e.getMessage());
		}


	}

	public WebElement isElementVisible(WebElement ele) {
		WebElement element = wait.
				withMessage("Element is not visible")
				.until(
						ExpectedConditions
								.visibilityOf(ele));
		return element;
	}

	public void TypeEnter(WebElement ele, String testData, Keys key) {

		WebElement element = isElementVisible(ele);
		element.clear();
		element.sendKeys(testData, key);
	}

	public void appendText(WebElement ele, String testData) {
		WebElement element = isElementVisible(ele);
		element.sendKeys(testData);

	}


	public String getTitle(String text) {

		return driver.getTitle();

	}

	public String getURL() {

		return driver.getCurrentUrl();
	}

	public boolean isDisplayed(WebElement ele) {

		return ele.isDisplayed();
	}

	public boolean isEnabled(WebElement ele) {

		return ele.isEnabled();
	}

	public boolean isSelected(WebElement ele) {

		return ele.isSelected();
	}


	public static ExtentReports startReport() {
		//get current date
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-MM-SS");
		Date date = new Date();
		String ActualDate = format.format(date);
		//String Path=System.getProperty("user.dir"+ "./Reports/ExecutionReport_"+ActualDate +".html");

		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/TestReport_" + ActualDate + ".html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);


		reporter.config().setDocumentTitle("documentTitle");
		reporter.config().setTheme(Theme.STANDARD);


		return extent;
	}

	public void createTest(String author, String category) {

		test.assignAuthor(author);
		test.assignCategory(category);


	}


	public void stepReport(String Message, String description) {

		switch (Message.toLowerCase()) {
			case "pass":
				test.log(Status.PASS, description);
				break;
			case "fail":
				test.log(Status.FAIL, description);
				break;
			case "info":
				test.log(Status.INFO, description);
				break;
			case "warning":
				test.log(Status.WARNING, description);
				break;
			default:
				System.err.println("Status is not defined");
				break;
		}
	}


	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getScreenshot(String imageName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "./Screenshots/" + imageName;
		FileUtils.copyFile(source, new File(dest));
		
		return dest;


	}

	
	

	}








