package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;

public class Search extends Base{
	public  WebDriver driver;
	HomePage HomePage;
	AfterHooks AfterHooks;
	
	@Before("@Search")
	public void openBrowser() throws IOException {
			
	driver=initializeBrowser();
			
		} 
	@Given("^i go to app VegaIT$")
    public void goToVegaITApp() {
        driver.get(prop.getProperty("url"));
    }

    @When("^i accept alert$")
    public void acceptAlert() {
    	HomePage = new HomePage(driver);
    	HomePage.AcceptAlert().click();
    }

    @And("^i click on Menu button$")
    public void clickOnMenuButton() {
    	HomePage.MenuButton().click();
    }

    @And("^i enter \"([^\"]*)\" in search field$")
    public void enterDataInSearchField(String data) {
    	HomePage.SearchField().sendKeys(data);
    }

    @And("^i click on search icon$")
    public void clickOnSearchIcon() {
    	HomePage.SearchIcon().click();
    }

    @Then("^i see search results$")
    public void verifySearchResults() {
    	 WebElement ExpectedElement =HomePage.SearchResult();
    	 WebElement ActualElement=null;
    	 try {
    		 ActualElement=driver.findElement(By.xpath("//h1[normalize-space()='Search results']"));
    		 System.out.println("Test pass");
    	 }
    	 catch(Exception e) {
    		 System.out.println("Test fail");
    	 }
    	 Assert.assertEquals(ActualElement, ExpectedElement);
    }
    @After(order = 1, value = "@Search")
	public void afterFail(Scenario scenario) {
		
		AfterHooks = new AfterHooks(driver);
		 
		 AfterHooks.screenshot(scenario);
   
       
    }
	@After(order = 0, value = "@Search")
	public void tearDown() {
		
		AfterHooks.close();
	
	}
}
