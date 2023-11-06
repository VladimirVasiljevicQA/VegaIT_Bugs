package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class SubmitButton extends Base{
	public  WebDriver driver;
	HomePage HomePage;
	AfterHooks AfterHooks;
	
	@Before("@Submit")
	public void openBrowser() throws IOException {
			
	driver=initializeBrowser();
			
		} 
	@Given("^i go to app Vega$")
    public void VegaITApp() {
		driver.get(prop.getProperty("url"));
    }

    @When("^i accept alert on app$")
    public void acceptAlertOnApp() {
    	HomePage = new HomePage(driver);
    	HomePage.AcceptAlert().click();
    }
    @And("^i click on submit button$")
    public void clickOnSubmit() {
    	HomePage.Submit().click();
    }
    @Then("^i see proper warning text for every field$")
    public void warningText() {
    	 String warningText=HomePage.warningText().getText();
    	 String actualText=null;
    	 try {
    		 actualText=driver.findElement(By.xpath("//div[@class='footer-newsletter__content js-footer-newsletter-content']//div[1]//span[1]")).getText();
    		 if(actualText.equals(warningText)) {
    			 System.out.println("Test fail, same warning text");
    		 }
    	 }
    	 catch(Exception e) {
    		 System.out.println("Test pass");
    	 }
    	 Assert.assertNotEquals(actualText, warningText);
    	 
    }
  
    @After(order = 1, value = "@Submit")
	public void afterFail(Scenario scenario) {
		
		AfterHooks = new AfterHooks(driver);
		 
		 AfterHooks.screenshot(scenario);
   
       
    }
	@After(order = 0, value = "@Submit")
	public void tearDown() {
		
		AfterHooks.close();
	
	}
}


