package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
WebDriver driver;
	
	public HomePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")
	private WebElement AcceptAlert;
	@FindBy(xpath="//button[@aria-label='Main menu']")
	private WebElement MenuButton;
	@FindBy(xpath="//input[@id='nav__search-input-Search']")
	private WebElement SearchField;
	@FindBy(xpath="//span[@class='nav__search-icon font-ico-search']")
	private WebElement SearchIcon;
	@FindBy (xpath="//h1[normalize-space()='Search results']")
	private WebElement SearchResult;
	
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement Submit;
	@FindBy(xpath="//div[@class='footer-newsletter__form-group footer-newsletter__form-group--last']//span[@role='alert'][normalize-space()='Please insert your email.']")
	private WebElement warningText;

	
	 public WebElement AcceptAlert() {
		 return AcceptAlert;
	 }
	 public WebElement MenuButton() {
		 return MenuButton;
	 }
	 public WebElement SearchField() {
		 return SearchField;
	 }
	 public WebElement SearchIcon() {
		 return SearchIcon;
	 }
	 public WebElement SearchResult() {
		 return SearchResult;
	 }
	 
	 
	 public WebElement Submit() {
		 return Submit;
	 } public WebElement warningText() {
		 return warningText;
	 }
}
