package com.qa.testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AutomationPanda extends TestBase{
	@Test(priority = 0)
	public void checkTitle() throws IOException {
	  boolean homepagetitle=driver.getTitle().contains("Automation Pandas");
	  if(homepagetitle){
		  Assert.assertTrue(true);
	  }
	  else {
		  captureScreenshot(driver,"checkTitle");
		  Assert.assertTrue(false,"Title shown is Incorrect");
	  }
	}
	@Test(priority = 1)
	public void checkContactButton() throws IOException {
		boolean contactbutton=p.getContactButton().isEnabled();
		if(contactbutton) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver, "checkContactButton");
			Assert.assertTrue(false,"Contact Button is not enabled");
		}
		p.getContactButton().click();
		String contacttitle=driver.getTitle();
		Assert.assertEquals(contacttitle,"Contact | Automation Panda","contact page title is incorrect");
	}

	@Test(priority = 2,dependsOnMethods = "checkContactButton")
	public void checkSubmit() throws IOException {
		p.getName().sendKeys("Aishwariah");
		p.getEmail().sendKeys("aishalampally@gmail.com");
		p.getMessage().sendKeys("Hi hello!!");
		if(p.getContactMe().isEnabled()) {
            Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver,"checkSubmit");
			Assert.assertTrue(false,"submit button is not enabled");
		}
		p.getContactMe().click();
		String message=p.getSentMessage().getText();
		if(message.contains("Your message has been sent")) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot(driver, "checkSubmit");
			Assert.assertTrue(false,"message is incorrect");
		}
	}

}


