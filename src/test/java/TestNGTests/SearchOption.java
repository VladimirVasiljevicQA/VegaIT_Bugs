package TestNGTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import resources.Base;


public class SearchOption extends Base{
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

@Test(dataProvider="searchData")
public void Search (String searchdata) throws InterruptedException {
	 HomePage = new HomePage(driver);
	 HomePage.AcceptAlert().click();
	 log.debug("Accept alert");
	 
	 HomePage.MenuButton().click();
	 log.debug("Click on menu button");
	 
	 HomePage.SearchField().sendKeys(searchdata);
	 log.debug("Provide data");
	 Thread.sleep(1000);
	 
	 HomePage.SearchIcon().click();
	 log.debug("Click on search icon");
	 
	 WebElement ExpectedElement =HomePage.SearchResult();
	 WebElement ActualElement=null;
	 try {
		 ActualElement=driver.findElement(By.xpath("//h1[normalize-space()='Search results']"));
		 log.debug("Test pass, driver find element");
		 System.out.println("Test pass");
	 }
	 catch(Exception e) {
		 log.error("Test fail, no such element");
		 System.out.println("Test fail");
	 }
	 Assert.assertEquals(ActualElement, ExpectedElement);
}

@AfterMethod
public void tearDown() {
	driver.quit();
	log.debug("Browser is closed");
}
@DataProvider
public Object[][] searchData() {
	Object [][] data= {{".."},{"..."}}; 
	return data;
}
	
}
