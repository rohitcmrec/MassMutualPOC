package AppHooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.massmutual.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	
	private DriverFactory df;
	private Properties prop;
	private WebDriver driver;
	
	@Before
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	

}
