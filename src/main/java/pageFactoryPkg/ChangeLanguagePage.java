package pageFactoryPkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainPkg.BaseClass;

public class ChangeLanguagePage extends BaseClass{
	@FindBy(xpath="//input[@value='en_US']")
	WebElement englishOptionDefaultSelected;
	
	@FindBy(xpath="//input[@value='en_US']/following-sibling::i")
	WebElement englishRadioBtn;
	
	@FindBy(xpath="//input[@value='es_US']/following-sibling::i")
	WebElement spanishRadioBtn;
	
	@FindBy(id="icp-language-heading")
	WebElement changeLanguageHeader;
	
	public ChangeLanguagePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateEnglishOptionDefaultSelection() {
		return englishOptionDefaultSelected.isSelected();
	}
	
	public void clickEnglishRadioBtn() {
		englishRadioBtn.click();
	}
	
	public void clickSpanishRadioBtn() {
		spanishRadioBtn.click();
	}
	
	public String validateChangeLanguageHeader() {
		return changeLanguageHeader.getText();
	}
}
