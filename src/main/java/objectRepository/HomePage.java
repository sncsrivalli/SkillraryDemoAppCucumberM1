package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Declaration
	
	@FindBy(xpath = "//a[text()=' Home']")
	private WebElement homeLink;
	
	@FindBy(xpath = "//span[text()='Courses']")
	private WebElement coursesTab;
	
	@FindBy(xpath = "//a[text()=' Course List']")
	private WebElement courseListLink;
	
	@FindBy(xpath = "//a[text()=' Category']")
	private WebElement categoryLink;
	
	@FindBy(xpath = "//span[text()='SkillRary Admin']")
	private WebElement skillraryAdminIcon;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signOutLink;
	
	// Initialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public boolean homeLinkIsDisplayed() {
		if(homeLink.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void navigateToCourseListPage() {
		coursesTab.click();
		courseListLink.click();
	}
	
	public void navigateToCategoryPage() {
		coursesTab.click();
		categoryLink.click();
	}
	
	public void signoutOfApp() {
		skillraryAdminIcon.click();
		signOutLink.click();
	}
}
