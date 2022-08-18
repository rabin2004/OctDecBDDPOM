package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainPkg.BaseClass;
import pageFactoryPkg.ChangeLanguagePage;
import pageFactoryPkg.HomePage;

public class ChangLanguageFunctionalityTest extends BaseClass{
	// Pre-Post requisite code
//	@Before
//	public void initialization() {
//		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(appURL);
//	}
//	
//	@After
//	public void tearDown() {
//		driver.close();
//	}
	
	HomePage hp = new HomePage();
	ChangeLanguagePage clp = new ChangeLanguagePage();
	
	@Given("customer is in homepage")
	public void customer_is_in_homepage() {
		Assert.assertEquals(hp.returnCurrentURL(), prop.getProperty("testURL"));
	}

	@When("customer clicks on flag icon")
	public void customer_clicks_on_flag_icon() {
	   hp.clickFlagIcon();
	}

	@Then("customer should see English radiobutton default selected")
	public void customer_should_see_english_radiobutton_default_selected() {
	   Assert.assertTrue(clp.validateEnglishOptionDefaultSelection());
	}
	
	@When("customer clicks {string} radio button")
	public void customer_clicks_radio_button(String language) {
	    if(language.equalsIgnoreCase("English")) {
	    	clp.clickEnglishRadioBtn();
	    }else if(language.equalsIgnoreCase("Spanish")) {
	    	clp.clickSpanishRadioBtn();
	    }
	}

	@Then("language should change {string}")
	public void language_should_change_accordingly(String language) {
		if(language.equalsIgnoreCase("English")) {
	    	Assert.assertEquals(clp.validateChangeLanguageHeader(), prop.getProperty("expectedEnglishLangTitle"));
	    }else if(language.equalsIgnoreCase("Spanish")) {
	    	Assert.assertEquals(clp.validateChangeLanguageHeader(), prop.getProperty("expectedSpanishLangTitle"));
	    }
	}
}
