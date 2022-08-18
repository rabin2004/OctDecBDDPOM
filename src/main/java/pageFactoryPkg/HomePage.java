package pageFactoryPkg;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainPkg.BaseClass;

public class HomePage extends BaseClass { 
	Actions action;
	
	@FindBy(id="icp-nav-flyout")
	WebElement flagIcon;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTxnField;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlagIcon() {
		flagIcon.click();
	}
	
	public String returnCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public void enterProductInSearchTxtField(String product) {
		searchTxnField.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void hitEnterKey() {
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
}
