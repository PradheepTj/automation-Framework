package Securelandlogin;

import org.secureurlandz.SeleniumFramework.SeleniumFramework;
import org.testng.Assert;
import org.testng.annotations.Test;

import EnumBase.browser;
import EnumBase.locators;

public class login extends SeleniumFramework {

	public void launch() {

		setUp(browser.CHROME, "http://localhost/SecureUrlandz/");

	}

	public void Firefox() {

		setUp(browser.FIREFOX, "http://localhost/SecureUrlandz/");
	}

	@Test(priority = 0)
	public void adminlogin() {

		launch();
		element(locators.xpath, "/html/body/div[1]/div/div/div/li[1]/a").click();
		element(locators.id, "email").sendKeys("17bcapradheep@gmail.com");
		element(locators.id, "password").sendKeys("lokiloki");
		element(locators.xpath, "/html/body/div/div/div/div[2]/div/form/div[3]/button").click();

		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "http://localhost/SecureUrlandz/";
		Assert.assertEquals(ExpectedUrl, ActualUrl);

	}

	@Test(priority = 1)
	public void empLogin() {

		Firefox();
		element(locators.xpath, "/html/body/div[1]/div/div/div/li[1]/a").click();
		element(locators.id, "email").sendKeys("Teej@gmail.com");
		element(locators.id, "password").sendKeys("lokiloki");
		element(locators.xpath, "/html/body/div/div/div/div[2]/div/form/div[3]/button").click();

		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "http://localhost/SecureUrlandz/";
		Assert.assertEquals(ExpectedUrl, ActualUrl);

	}

	@Test(priority = 2)
	public void createUser() {

		Firefox();

		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "http://localhost/SecureUrlandz/";
		Assert.assertEquals(ExpectedUrl, ActualUrl);

		element(locators.xpath, "/html/body/div/div/div/div/li[3]/a").click();
		element(locators.id, "name").sendKeys("Dhabu");
		element(locators.id, "number").sendKeys("5656565666");
		element(locators.id, "email").sendKeys("teeejay@gmail.com");
		element(locators.id, "password").sendKeys("lokiloki");
		element(locators.id, "password_confirmation").sendKeys("lokiloki");
		element(locators.xpath, "/html/body/div/div/div/form/div/div/div[4]/button[1]").click();

		String ActualUrl2 = driver.getCurrentUrl();
		String ExpectedUrl2 = "http://localhost/SecureUrlandz/";
		Assert.assertEquals(ExpectedUrl2, ActualUrl2);

	}

	@Test(priority = 3)
	public void createUser2() {

		launch();

		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "http://localhost/SecureUrlandz/";
		Assert.assertEquals(ExpectedUrl, ActualUrl);

		element(locators.xpath, "/html/body/div/div/div/div/li[3]/a").click();
		element(locators.id, "name").sendKeys("Dhabu2");
		element(locators.id, "number").sendKeys("5656565665");
		element(locators.id, "email").sendKeys("teejay@gmail.com");
		element(locators.id, "password").sendKeys("lokiloki");
		element(locators.id, "password_confirmation").sendKeys("lokiloki");
		element(locators.xpath, "/html/body/div/div/div/form/div/div/div[4]/button[1]").click();

		String ActualUrl2 = driver.getCurrentUrl();
		String ExpectedUrl2 = "http://localhost/SecureUrlandz/";
		Assert.assertEquals(ExpectedUrl2, ActualUrl2);

	}

}
