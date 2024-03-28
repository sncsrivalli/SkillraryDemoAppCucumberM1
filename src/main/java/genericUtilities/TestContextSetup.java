package genericUtilities;

import org.openqa.selenium.WebDriver;

import objectRepository.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public PropertiesUtility property;
	public WebDriverUtility web;
	public JavaUtility jutil;
	public ExcelUtility excel;
	
	public TestContextSetup() {
		property = new PropertiesUtility();
		web = new WebDriverUtility();
		jutil = new JavaUtility();
		excel = new ExcelUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		String browser_maven = System.getProperty("Browser");
		String browser_prop = property.readFromProperties("browser");
		String browser = null;
		
		if(browser_maven == null)
			browser = browser_prop;
		else
			browser = browser_maven;
		
		driver = web.launchBrowser(browser);
		pageObjectManager = new PageObjectManager(driver);

	}
}
