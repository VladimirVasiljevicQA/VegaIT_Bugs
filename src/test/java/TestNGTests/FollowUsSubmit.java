package TestNGTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import resources.Base;

public class FollowUsSubmit extends Base {
	public  WebDriver driver;
	Logger log;
	HomePage HomePage;
	
	@BeforeMethod
	public void open() throws IOException {
	log = LogManager.getLogger(SearchOption.class.getName());
	driver= initializeBrowser();
	log.debug("Browser got launched");
	driver.get(prop.getProperty("url"));
	log.debug("Go to url");
	}

@Test
public void Submit () {
	 HomePage = new HomePage(driver);
	 HomePage.AcceptAlert().click();
	 log.debug("Accept alert");
	 
	 HomePage.Submit().click();
	 log.debug("Click on submit button");
	 
	 String warningText=HomePage.warningText().getText();
	 String actualText=null;
	 try {
		 actualText=driver.findElement(By.xpath("//div[@class='footer-newsletter__content js-footer-newsletter-content']//div[1]//span[1]")).getText();
		 if(actualText.equals(warningText)) {
			 log.error("Test fail, same warning text");
			 System.out.println("Test fail, same warning text");
		 }
	 }
	 catch(Exception e) {
		 log.debug("Test pass, text is different");
		 System.out.println("Test pass");
	 }
	 Assert.assertNotEquals(actualText, warningText);
	 
}

@AfterMethod
public void tearDown() {
	driver.quit();
	log.debug("Browser is closed");
}
}
