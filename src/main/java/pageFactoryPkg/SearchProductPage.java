package pageFactoryPkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainPkg.BaseClass;

public class SearchProductPage extends BaseClass{
	
	@FindBy(xpath="//div[@class='a-row']/span[2]")
	WebElement invalidSearchProductElement;
	
	public SearchProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateInvalidProductDisplay() {
		return invalidSearchProductElement.isDisplayed();
	}
	
	public String validateInvalidProductTxt() {
		return invalidSearchProductElement.getText();
	}
	
	public String returnSearchProductPageURL() {
		return driver.getCurrentUrl();
	}
}
