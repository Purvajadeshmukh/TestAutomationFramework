package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilites.ReadXSLdata;

public class MyFirstTestFW extends BaseTest {

	@Test(dataProviderClass = ReadXSLdata.class,dataProvider = "bvtdata")
	public void LoginTest(String username, String password) throws InterruptedException {

		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement login = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("email_field"))));
		login.sendKeys(username);

		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	}

}