package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CourseListPage {

	// Declaration

	@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
	private WebElement pageHeader;

	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement successAlert;

	@FindBy(id = "addproduct")
	private WebElement newButton;

	private String commonDeletePath = "//td[text()='%s']/following-sibling::td/child::button[text()=' Delete']";

	@FindBy(name = "delete")
	private WebElement deleteButton;

	// Initialization

	public CourseListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public boolean pageHeaderIsDisplayed() {
		if (pageHeader.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void deleteCourse(WebDriverUtility web, String courseName) {
		web.convertDynamicXpathToWebElement(commonDeletePath, courseName).click();
		deleteButton.click();
	}
	
	public String getSuccessAlert() {
		return successAlert.getText();
	}

}
