package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import mainPkg.BaseClass;

public class Hooks extends BaseClass{
	
	@Before
	public void loadApp() {
		initialization();
	}
	
	@After
	public void closeApp() {
		tearDown();
	}

}
