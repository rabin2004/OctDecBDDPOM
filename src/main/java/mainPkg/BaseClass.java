package mainPkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\OctDecCucumber\\src\\main\\java\\configPkg\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialization() {
		System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("testURL"));
		driver.manage().deleteAllCookies();
	}
	
	public void tearDown() {
		driver.close();
	}
}
