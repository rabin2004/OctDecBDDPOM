package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainPkg.BaseClass;
import pageFactoryPkg.HomePage;
import pageFactoryPkg.SearchProductPage;

public class SearchFunctionalityTest extends BaseClass{

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
	SearchProductPage spp = new SearchProductPage();
	
	@Given("customer is in home page")
	public void customer_is_in_home_page() {
		Assert.assertEquals(hp.returnCurrentURL(), prop.getProperty("testURL"));
	}

	@When("customer provides valid product for search")
	public void customer_provides_valid_product_for_search() {
		hp.enterProductInSearchTxtField(prop.getProperty("searchProduct"));;
	}

	@And("clicks search icon")
	public void clicks_search_icon() {
		hp.clickSearchBtn();;
	}

	@Then("related product should be displayed")
	public void related_product_should_be_displayed() {
		Assert.assertTrue(hp.returnCurrentURL().contains(prop.getProperty("searchProduct")));
	}
	
	@And("customer hits enter key")
	public void customer_hits_enter_key() {
	    hp.hitEnterKey();
	}
	
	@When("customer provides invalid product for search")
	public void customer_provides_invalid_product_for_search() {
		hp.enterProductInSearchTxtField(prop.getProperty("invalidSearchProduct"));
	}
	
	@Then("related product shouldnot be displayed")
	public void related_product_shouldnot_be_displayed() {
		Assert.assertTrue(spp.returnSearchProductPageURL().contains(prop.getProperty("invalidSearchProduct")));
		Assert.assertTrue(spp.validateInvalidProductDisplay());
	}
	
	// older format of snippet
//	@When("^customer provides valid (.+) for search$") // expression to be used for scenario outline -> (.+) -> \"(.*)\"
//    public void customer_provides_valid_for_search(String product) {
//        
//    }
//
//    @Then("^related (.+) should be displayed$")
//    public void related_should_be_displayed(String product) throws Throwable {
//        throw new PendingException();
//    }

	@When("customer provides valid {string} for search")
	public void customer_provides_valid_item_for_search(String product) {
		hp.enterProductInSearchTxtField(product);
	}
	@Then("related {string} should be displayed")
	public void related_item_should_be_displayed(String product) {
		Assert.assertTrue(hp.returnCurrentURL().contains(product));
	}
	
	// changes 123 - rabin
}
